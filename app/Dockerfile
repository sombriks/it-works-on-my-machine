FROM docker.io/adoptopenjdk/openjdk11:alpine

ADD . /app

WORKDIR /app

EXPOSE 8080

RUN ["/app/gradlew", "build"]

ENTRYPOINT ["/app/gradlew", "bootRun"]
