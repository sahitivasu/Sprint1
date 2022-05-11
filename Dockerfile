FROM openjdk:8-jre-alpine
#LABEL maintainer="author@javatodev.com"
#VOLUME /main-app
ADD target/Sprint-1-0.0.1-SNAPSHOT.jar Sprint-1-0.0.1-SNAPSHOT.jar
EXPOSE 8235
ENTRYPOINT ["java", "-jar","Sprint-1-0.0.1-SNAPSHOT.jar"]