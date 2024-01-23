FROM ubuntu
RUN apt-get update
RUN apt-get install openjdk-8-jdk -y
WORKDIR /opt
COPY release-local-artifacts2/com/meportal/springboot-app/1.0./springboot-app-1.0..war
CMD ["java", "-jar", "welcomeapp.war"]