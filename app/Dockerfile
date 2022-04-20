FROM docker.io/adoptopenjdk/openjdk11:alpine

ADD . /app

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["/app/gradlew", "bootRun" ]
