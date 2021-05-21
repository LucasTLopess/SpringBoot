FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} appPromotion.jar
ENTRYPOINT ["java","-jar","/appPromotion.jar"]