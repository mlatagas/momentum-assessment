**Active-shoppe api version 1** 
Facilitates the buying of Active Shoppe products with Daily Active customer points.  

**Build**

`mvn clean install`

creates a jar file in ~/active-shoppe/target/active-shoppe-0.0.1-SNAPSHOT.jar


**Run**

`mvn spring-boot:run`


**Swagger UI**

http://localhost:8080/active-shoppe-api/swagger-ui.html

**Swagger docs**

`http://localhost:8080/active-shoppe-api/v2/api-docs`

**REST API**

Request:

`GET /v1/products`

`curl -X GET "http://localhost:8080/active-shoppe-api/v1/products" -H "accept: */*"`

Response:

`[
   {
     "name": "Hatlam",
     "code": 1,
     "points": 10
   },
   {
     "name": "Phys Fintone",
     "code": 2,
     "points": 20
   },
   {
     "name": "New-Sing",
     "code": 3,
     "points": 30
   },
   {
     "name": "Biolam",
     "code": 4,
     "points": 40
   },
   {
     "name": "Kanstock",
     "code": 5,
     "points": 50
   }
 ]`
 
 Request:
 
 `GET v1/1/purchase-product`
 
 `curl -X POST "http://localhost:8080/active-shoppe-api/v1/1/purchase-product" -H "accept: */*" -H "Content-Type: application/json" -d "[ { \"name\": \"Hatlam\", \"code\": 1, \"points\": 10 }, { \"name\": \"Phys Fintone\", \"code\": 2, \"points\": 20 }, { \"name\": \"New-Sing\", \"code\": 3, \"points\": 30 }]"`
 
 Response:
 
 `[
    {
      "name": "Hatlam",
      "code": 1,
      "points": 10
    },
    {
      "name": "Phys Fintone",
      "code": 2,
      "points": 20
    },
    {
      "name": "New-Sing",
      "code": 3,
      "points": 30
    }
  ]`
  
  **Dependencies**
  
  Lombok
  
  `        <dependency>
               <groupId>org.projectlombok</groupId>
               <artifactId>lombok</artifactId>
               <optional>true</optional>
           </dependency>
           `

**Monitoring**

Prometheus (vanilla config)

`http://localhost:8080/active-shoppe-api/actuator`
   
   
           
           