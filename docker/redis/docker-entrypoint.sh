#!/bin/sh
set -e


if [ "${1#-}" != "$1" ] || [ "${1%.conf}" != "$1" ]; then
	set -- redis-server "$@"
	#echo "connect = $REDIS_PORT_6379_TCP_ADDR:$REDIS_PORT_6379_TCP_PORT" >> ./stunnel/stunnel.conf
	#stunnel4 ./stunnel/stunnel.conf
fi

if [ "$1" = 'redis-server' -a "$(id -u)" = '0' ]; then
	find . \! -user redis -exec chown redis '{}' +
	exec gosu redis "$0" "$@"
fi
# echo "connect = $REDIS_PORT_6379_TCP_ADDR:$REDIS_PORT_6379_TCP_PORT" >> /stunnel/stunnel.conf
# stunnel4 ./stunnel/stunnel.conf
#tail -f /dev/null
exec "$@"
