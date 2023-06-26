FROM openjdk:17
EXPOSE 8080
ADD target/explore-india-app-0.0.1-SNAPSHOT.jar explore-india-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/explore-india-app-0.0.1-SNAPSHOT.jar"]
