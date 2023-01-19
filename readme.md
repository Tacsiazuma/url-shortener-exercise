# Url shortener app

## Requirements

- maven 3.6+
- java 8+

## Build

    mvn clean install

## Run

    mvn spring-boot:run 

## Usage:

### Create shortened URL:

#### Request:

    POST http://localhost:8080/url 
    {
     "url" : "https://example.com"
    }

#### Response:

    { url: <id> }

### Resolve shortened URL:

#### Request: 

    GET http://localhost:8080/<id>

#### Response:

    HTTP/1.1
    Location: https://example.com