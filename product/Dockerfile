FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} appProduct.jar
ENTRYPOINT ["java","-jar","/appProduct.jar"]