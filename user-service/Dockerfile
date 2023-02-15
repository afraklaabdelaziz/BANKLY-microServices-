FROM openjdk:11
WORKDIR user/
COPY target/user-service-0.0.1-SNAPSHOT.jar user/
ENTRYPOINT ["java","-jar","user/user-service-0.0.1-SNAPSHOT.jar"]