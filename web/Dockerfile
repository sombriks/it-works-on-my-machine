FROM docker.io/library/node:14

ADD . /web

WORKDIR /web

EXPOSE 3000
EXPOSE 5050

RUN [ "npm", "install" ]

# this is a development machine
ENTRYPOINT [ "npm", "run", "dev" ]
