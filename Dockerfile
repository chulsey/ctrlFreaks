FROM openjdk:21-jdk-slim
COPY app.jar app.jar
CMD ["java","-jar","app.jar"]