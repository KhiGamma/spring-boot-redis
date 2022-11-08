FROM maven
COPY . .
RUN mvn package
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "target/spring-boot-redis.jar"]