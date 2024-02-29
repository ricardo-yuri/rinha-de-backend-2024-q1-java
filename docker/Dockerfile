FROM docker.io/openjdk:21-slim

ENV APP_NAME rinha

COPY ./target/${APP_NAME}.jar  /app/${APP_NAME}.jar

WORKDIR /app

CMD java -jar ${APP_NAME}.jar

EXPOSE 8080