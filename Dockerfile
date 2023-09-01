FROM eclipse-temurin:11
RUN mkdir /opt/app
COPY target/testaverde-1.0.jar /opt/app/testaverde.jar
CMD ["java", "-jar", "/opt/app/testaverde.jar"]
