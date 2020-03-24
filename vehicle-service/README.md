# Vehicle API

## Dependencies
  - Java Runtime
  - Maven 
    - **MAC** - `brew install maven`
  - Docker Hub ID - {DID}

## Build Locally


```shell
  $ git clone https://github.com/rcherara/vehicle-service
  $ cd vehicle-service
  $ mvn package
  $ docker build -t {DID}/vehicle-service .
  $ cd target
  $ docker run -e JARFILE=vehicle-service-0.0.1-SNAPSHOT.jar -it {DID}/vehicle-service
  $ docker login --username={DID} --email=youremail@company.com
  $ docker push {DID}/vehicle-service
```


#  Running
To build and start the server simply type

```
  $ mvn clean install # add -DskipTests to omit running the tests
  $ mvn spring-boot:run -Dserver.port=8081
```


```curl
curl -X GET "http://localhost:8081/api/message?msg=welcome" -H "accept: */*"
Bienvenue dans ce guide!
```


# swagger UI

http://localhost:8081/swagger-ui.html#/

# DB 

http://localhost:8081/h2-console'. Database available at 'jdbc:h2:mem:testdb'



You can create, read, update, and delete vehicles with the following Curl commands:

```shell
  $ curl -X POST "http://localhost:8081/api/vehicle" -H "accept: */*" -H "Content-Type: application/json" -d "{ 
    \"AWD\": true, \"awd\": true, \"brand\": \"string\", \"color\": \"string\", \"cost\": 0, \"electric\": true, 
    \"engine\": \"FAST\", \"id\": 0, \"location\": \"string\", \"mileage\": 0, \"model\": \"SEDAN\", \"name\": \"string\", 
    \"numOfWindows\": 5, \"plate\": \"string\", \"position\": \"string\", \"price\": 0, \"tag\": \"string\", \"type\": 
    \"string\", \"tyre\": \"SNOW\", \"vin\": \"string\", \"year\": 0}"

```
output :

```shell
{"id":52,"vin":"string","name":"string","plate":"string","year":0,"position":"string","location":"string","tag":"string","model":"SEDAN","type":"string","brand":"string","mileage":0.0,"color":"string","engine":"FAST","tyre":"SNOW","price":0.0,"numOfWindows":5,"AWD":true,"cost":0.0,"electric":true,"awd":true}%                                                     ~ 
```

```shell
  $ curl -X GET "http://localhost:8081/api/vehicle/13" -H "accept: */*"
```
output :

```shell
{"id":13,"vin":"SAD23SDSSDSS","name":"Mercedes-Benz Classe A","plate":"SDE34422","year":2019,"position":"Alger","location":"Rue Didouche Mourad","tag":"WSDLKALK","model":"SUV","type":"Type","brand":"sfasfa","mileage":23434.0,"color":"Red","engine":"MEDIUM","tyre":"SUMMER","price":23333.0,"numOfWindows":6,"AWD":true,"cost":1.2312312E7,"electric":false,"awd":true}%
```