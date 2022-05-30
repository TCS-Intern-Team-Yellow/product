FROM openjdk:14-jdk-alpine
VOLUME /tmp
ADD target/product-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]