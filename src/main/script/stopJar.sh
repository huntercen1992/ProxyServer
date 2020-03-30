#!/bin/sh

PID=`ps -e|grep proxyServer|grep -v grep|awk '{print \$1}'`

if[ -n "${PID}" ]
then
	echo "kill ${PID}"
	kill -9 ${PID}
fi
