FROM docker.io/adoptopenjdk/openjdk11:alpine
ADD . /app
VOLUME /app
WORKDIR /app
EXPOSE 8080
# this is a development machine
ENTRYPOINT /app/gradlew --no-daemon --watch-fs build bootRun
