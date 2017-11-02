package com.sn.smart.mall.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 订单表
 * 
 * @author gxzhou2
 *
 */
@Repository
public interface ExecuteSqlDao {

	/**
	 * 执行统计语句
	 * 
	 * @param countSql
	 *            统计语句
	 * @return 统计数
	 */
	@Select("${countSql}")
	int executeCountSql(@Param("countSql") String countSql);

	/**
	 * 执行更新语句
	 * 
	 * @param updateSql
	 *            更新语句
	 * @return 更新数
	 */
	@Update("${updateSql}")
	int executeUpdateSql(@Param("updateSql") String updateSql);

}
