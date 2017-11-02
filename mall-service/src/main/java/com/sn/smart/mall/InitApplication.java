package com.sn.smart.mall;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sn.smart.mall.dao.ExecuteSqlDao;

/**
 * 项目启动时预加载的资源
 * 
 * @author gxzhou2
 *
 */
@Component
public class InitApplication implements ApplicationListener<ContextRefreshedEvent> {

	public static final Logger logger = LoggerFactory.getLogger(InitApplication.class);

	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info("====================Init table begin!====================");
		executeSql(SqlType.TABLE);
		logger.info("====================Init table end!====================");
		logger.info("====================Init data begin!====================");
		executeSql(SqlType.DATA);
		logger.info("====================Init data end!====================");
		logger.info("====================Init update begin!====================");
		executeSql(SqlType.UPDATE);
		logger.info("====================Init update end!====================");
	}

	@Autowired
	private ExecuteSqlDao executeSqlDao;

	/**
	 * 根元素
	 */
	private String rootElement = "table";
	/**
	 * 第一个元素
	 */
	private String firstElement = "check";
	/**
	 * 第二个元素
	 */
	private String secondElement = "sql";
	/**
	 * 分隔字符
	 */
	private String splitChar = ";";
	/**
	 * 占位符
	 */
	private static String replaceStr = "${check}";

	/**
	 * sql类型
	 * 
	 * @author gxzhou2
	 *
	 */
	enum SqlType {
		/**
		 * 表结构
		 */
		TABLE("/sql/initTable.xml", "select count(1) from user_tables t where t.table_name = '" + replaceStr + "'"),
		/**
		 * 数据
		 */
		DATA("/sql/initData.xml", "select count(1) from " + replaceStr),
		/**
		 * 升级
		 */
		UPDATE("/sql/initUpdate.xml", replaceStr);

		/**
		 * 路径
		 */
		private String path;
		/**
		 * 校验语句
		 */
		private String check;

		SqlType(String path, String check) {
			this.path = path;
			this.check = check;
		}

		public String getPath() {
			return path;
		}

		public String getCheck() {
			return check;
		}

	}

	/**
	 * 初始化表信息
	 * 
	 * @param sqlType
	 *            sql类型
	 */
	@SuppressWarnings("unchecked")
	private void executeSql(SqlType sqlType) {
		SAXReader reader = new SAXReader();
		Document document;
		try {
			document = reader.read(this.getClass().getResourceAsStream(sqlType.getPath()));
			Element root = document.getRootElement();
			List<Element> list = root.elements(rootElement);
			for (Element object : list) {
				String check = "";
				String sql = "";
				for (Element element : (List<Element>) object.elements()) {
					if ((element).getName().equals(firstElement)) {
						check = element.getText();
					}
					if ((element).getName().equals(secondElement)) {
						sql = element.getText();
					}
				}
				if (!check.trim().isEmpty() && !sql.trim().isEmpty()) {
					executeSql(sqlType.getCheck().replace(replaceStr, check.trim().toUpperCase()), sql.trim());
				}
			}
		} catch (DocumentException e) {
			logger.info(e.getMessage());
		}
	}

	/**
	 * 初始化表信息
	 * 
	 * @param check
	 *            校验语句
	 * @param sql
	 *            初始化语句
	 */
	private void executeSql(String check, String sql) {
		if (executeSqlDao.executeCountSql(check) == 0) {
			String[] sqls = sql.split(splitChar);
			for (String executeSql : sqls) {
				if (!executeSql.trim().isEmpty()) {
					executeSqlDao.executeUpdateSql(executeSql);
				}
			}
		}
	}

}
