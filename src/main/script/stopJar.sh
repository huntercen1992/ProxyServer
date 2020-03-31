#!/bin/sh

PID=`ps -ef|grep proxyServer|grep -v grep|awk '{print $2}'`

if [ -n "${PID}" ]
then
	echo "kill ${PID}"
	kill -9 ${PID}
fi
