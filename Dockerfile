FROM maven AS build

COPY . .
RUN mvn clean package

# use a non-deprecated java image
# use multi stage build to optimize the image
FROM amazoncorretto:11-alpine
COPY --from=build target/spring-boot-redis.jar spring-boot-redis.jar

EXPOSE 8085
ENTRYPOINT ["java", "-jar", "spring-boot-redis.jar"]