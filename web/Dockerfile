FROM docker.io/library/node:14
ADD . /web
VOLUME /web
WORKDIR /web
EXPOSE 3000
EXPOSE 5050
# this is a development machine
ENTRYPOINT npm install ; npm run dev
