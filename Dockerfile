FROM openjdk:8

WORKDIR /opt

COPY target/*.war webapp.war

CMD ["java" , "-jar" , "webapp.war"]
