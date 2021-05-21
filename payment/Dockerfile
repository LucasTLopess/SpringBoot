FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} appPayment.jar
ENTRYPOINT ["java","-jar","/appPayment.jar"]