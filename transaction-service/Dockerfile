FROM openjdk:11
WORKDIR transaction/
COPY target/transaction-service-0.0.1-SNAPSHOT.jar transaction/
ENTRYPOINT ["java","-jar","transaction/transaction-service-0.0.1-SNAPSHOT.jar"]