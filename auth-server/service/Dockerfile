FROM bellsoft/liberica-openjdk-alpine-musl:17

ARG JAR_FILE=target/auth-server-0.0.1-SNAPSHOT.jar


WORKDIR /opt/app
COPY ../target/auth-server-0.0.1-SNAPSHOT.jar app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]