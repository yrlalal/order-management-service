FROM maven:3.9.6-eclipse-temurin-21-jammy as builder
WORKDIR /usr/app
COPY . .
RUN mvn clean verify

FROM eclipse-temurin:21.0.2_13-jre-ubi9-minimal
WORKDIR /usr/app
COPY --from=builder /usr/app/target/order-management-service*.jar ./app.jar
CMD ["java", "-jar", "app.jar"]
