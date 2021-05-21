FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} appNotification.jar
ENTRYPOINT ["java","-jar","/appNotification.jar"]