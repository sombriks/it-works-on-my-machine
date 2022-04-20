FROM docker.io/adoptopenjdk/openjdk11:alpine

ADD . /app

WORKDIR /app

EXPOSE 8080

RUN ["/app/gradlew", "build" ]

ENTRYPOINT ["java", "-jar", "/app/build/libs/app-0.0.1-SNAPSHOT.jar"] 
