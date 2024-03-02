# Order Management Service

## Summary

This is sample code for a microservice that is responsible for managing the orders of an ecommerce website. 
The service exposes endpoints to create. update, retrieve and delete orders and all the items on the orders.
Updating the order includes moving the order from one state to another. For example, the order can progress 
from NEW -> CHECKOUT -> ACTIVE -> COMPLETED. Or the order can be CANCELLED prior to moving to COMPLETED state.

## Software Required
* Docker
* Java IDE (example: IntelliJ Idea, Eclipse etc, but basic editor like vi or notepad would also do)
* Eclipse Temurin JDK v21
* Maven

## Local Build and deployment

To run locally, you can take one of these options:
* Using Docker Compose Only
    * Run the following command from project root folder in a terminal/shell:
    ``` 
    docker-compose up --build 
    ```
* Using Docker Compose and Maven (TODO: Create a script for this)
    * Run Postgres locally using docker compose:
    ``` 
    docker-compose -f docker-compose-postgres.yml up
    ```
    * Build order-management-service microservice using maven command:
    ```
    mvn clean verify
    ```
    * Run the microservice
    ```
    java -jar .\order-management-service-impl\target\order-management-service-impl-0.0.1-SNAPSHOT.jar --spring.profiles.active=local
    ```
* Run Postgres (locally or docker-compose as listed above) and run microservice in a Java IDE

Swagger UI can be accessed locally with the following url:
http://localhost:8080/swagger-ui/index.html

## Continuous Integration Pipeline
Continuous Integration pipelines have been set up using github actions. 
It will be run on:
* a pull request to master branch
* merging a pull request to master

The pipeline ensures that the application builds successfully and all unit tests pass within a docker container.
Additionally, on master branch pipeline the docker image is pushed to 
[docker hub](https://hub.docker.com/repository/docker/yrlalal/order-management-service/general) with two tags: 
`latest` and github sha of the most recent master branch commit.

JaCoCo code coverage tool has been set up to ensure 80% code coverage is met, but it is currently disabled.

## Future Goals
* Create Helm charts to deploy application to a k8s instance hosted locally or in cloud
* Create Terraform scripts to set up the k8s infrastructure.  
* Setup continuous deployment pipeline to deploy changes automatically on master branch build.
* Write integration tests to run after deployment. If the tests fail, ideally the application
shall be rolled back to previous version. At a minumum, send a notification email.








