FROM docker.io/library/node:14

ADD . /web

WORKDIR /web

EXPOSE 3000

CMD [ "npm", "install" ]

# this is a development machine
ENTRYPOINT [ "npm", "run", "dev" ]
