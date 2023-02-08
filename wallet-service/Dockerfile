FROM openjdk:11
WORKDIR wallet/
COPY target/wallet-service-0.0.1-SNAPSHOT.jar wallet/
ENTRYPOINT ["java","-jar","wallet/wallet-service-0.0.1-SNAPSHOT.jar"]