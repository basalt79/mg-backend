# Quarkus Quickstart

This project implements a simple Hello World REST service using Quarks.

## Build and run

With JDK8+
```bash
mvn compile quarkus:dev
```
## MongoDB config
```bash
docker run -ti --rm -p 27017:27017 mongo:4.0
```
change url in application.properties

## Run
go to localhost:8080/index.html