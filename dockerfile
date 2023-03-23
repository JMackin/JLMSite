FROM amazoncorretto:17-alpine-jdk
MAINTAINER ujlm
COPY target/JLMSite-0.0.1-SNAPSHOT.jar JLMSite-0.0.1.jar
ENTRYPOINT ["java","-jar","/JLMSite-0.0.1.jar"]
VOLUME /tmp
EXPOSE 8080
EXPOSE 5432