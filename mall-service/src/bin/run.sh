#!/bin/sh
#===================================================
APP_MAINCLASS=com.iflytek.society.nafc.provider.Provider
JMS_OPTS="-Xms256m -Xmx1024m"

APP_HOME=$(cd `dirname $0`;cd ..; pwd)
CLASSPATH=$APP_HOME/:$APP_HOME/*:$APP_HOME/lib/*
psid=0
#===================================================

checkpid2(){
  javaps=`$JAVA_HOME/bin/jps -l | grep $APP_MAINCLASS`
 
  if [ -n "$javaps" ]; then
      psid=`echo $javaps | awk '{print $1}'`
  else
      psid=0
  fi
}
checkpid(){
    if [ ! -f "$APP_HOME/server.pid" ]; then 
        psid=0
    else
        psid=`cat $APP_HOME/server.pid` 
        javaps=`ps -p $psid | grep java`
        if [ -z "$javaps" ]; then
            psid=0
            rm -rf $APP_HOME/server.pid   
        fi
    fi 
}

start() {
  checkpid
 
  if [ $psid -ne 0 ]; then
      echo "================================"
      echo "warn: $APP_MAINCLASS already started! (pid=$psid)"
      echo "================================"
  else
      echo -n "Starting $APP_MAINCLASS ..."
        if [ ! -d "$APP_HOME/log/" ]; then 
	    mkdir "$APP_HOME/log/"
	fi 
	cd $APP_HOME
	nohup java -classpath $CLASSPATH $JMS_OPTS  $APP_MAINCLASS >> $APP_HOME/log/server.log 2>&1 &   
	echo $! > $APP_HOME/server.pid
 
	checkpid
	if [ $psid -ne 0 ]; then
	    echo "(pid=$psid) [OK]"
        else
            echo "[Failed]"
      fi
  fi
}
 

stop() {
  checkpid
 
  if [ $psid -ne 0 ]; then
      echo -n "Stopping $APP_MAINCLASS ...(pid=$psid) "
      su - $RUNNING_USER -c "kill -9 $psid"
      rm -rf $APP_HOME/server.pid   
      if [ $? -eq 0 ]; then
        echo "[OK]"
      else
        echo "[Failed]"
      fi
 
      checkpid
      if [ $psid -ne 0 ]; then
        stop
      fi
  else
      echo "================================"
      echo "warn: $APP_MAINCLASS is not running"
      echo "================================"
  fi
}

status() {
  checkpid
 
  if [ $psid -ne 0 ];  then
      echo "$APP_MAINCLASS is running! (pid=$psid)"
  else
      echo "$APP_MAINCLASS is not running"
  fi
}

info() {
  echo "System Information:"
  echo "****************************"
  echo `head -n 1 /etc/issue`
  echo `uname -a`
  echo
  echo "JAVA_HOME=$JAVA_HOME"
  echo `$JAVA_HOME/bin/java -version`
  echo
  echo "APP_HOME=$APP_HOME"
  echo "APP_MAINCLASS=$APP_MAINCLASS"
  echo "****************************"
}
 

case "$1" in
start)
      start
 
;;
stop)
    stop
;;
restart)
    stop
    start
    ;;
status)
      status
;;
info)
      info
 ;;
*)
      echo "Usage: $0 {start|stop|restart|status|info}"
      exit 1
esac
exit 0