FROM openjdk:11.0.2
ADD ./target/webbanhang-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]