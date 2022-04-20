FROM registry.access.redhat.com/ubi8/openjdk-11

ADD . /app

WORKDIR /app

EXPOSE 8080

# this is a development container
ENTRYPOINT ["/app/gradlew" "bootRun"] 
