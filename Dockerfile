FROM java:8
EXPOSE 9100
ADD target/api-train-0.0.1-SNAPSHOT.jar api-train-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","api-train-0.0.1-SNAPSHOT.jar"]