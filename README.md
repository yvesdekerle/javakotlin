# javakotlin

Simple application that mixed Java for sources and Kotlin for tests

## Description : 
Unit tests :
 - JUnit 5
 - Mockk (Mockito)
 - Kluent (AssertJ)

Integration test :
 - Wiremock

## Project 
Build : ./mvnw clean install

Run : ./mvnw spring-boot:run

Call : 
 - simple : http://localhost:8080/spacex/launches
 - with filter : http://localhost:8080/spacex/launches?filter=Starlink
