FROM gradle:7-alpine AS build

COPY --chown=gradle:gradle . /home/gradle/app

WORKDIR /home/gradle/app

RUN gradle build --no-daemon

CMD ["ls"]

FROM amazoncorretto:17-alpine

RUN mkdir /app

COPY --from=build /home/gradle/app/build/libs/service-a-1.0-SNAPSHOT.jar /app/spring-boot-application.jar

ENTRYPOINT ["java", "-jar", "/app/spring-boot-application.jar"]