FROM library/redis

RUN apt-get update && apt-get install -y stunnel4 python3-pip && \
    rm -rf /var/lib/apt/lists/* && \
    pip3 install honcho

COPY Procfile /Procfile
COPY stunnel.conf /stunnel/stunnel.conf
COPY server-key.pem /etc/ssl/server-key.pem
COPY server-cert.pem /etc/ssl/server-cert.pem
COPY docker-entrypoint.sh /usr/bin/

EXPOSE 6379
WORKDIR /
ENV PYTHONUNBUFFERED=1
CMD ["honcho", "start"]
