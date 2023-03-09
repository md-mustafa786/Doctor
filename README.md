# Doctor-Patient
*   Now we have doctors and patients there are some relations between doctor and patient as patients visit doctor regarding health as one doctor can have more than one patient so we make a SQL relation between the doctor's data and patient's data for ease access the relationship present in the project is ManyToOne where one doctor has many patients and the details can be accesses through database and even can do manipulations in the data if needed easily and efficiently
##  Framework and Language use in this Project-
 *  Springboot
 *  Java
##  Dependencies
 *  Spring Web
 *  H2 Database
 *  Spring Boot DevTools
 *  Lombok 
 *  Spring Data JPA
 
### Requirments
 * IntelliJIDEA
 * Serverport: 8080 (use: localhost:8080)
 * Java version: 17
 * Everything is present in the pom.xml (no need to download any library)
### Steps to run Application
 * Download the source code and import in intellijIDEA.
 * Go to localhost:8080/
 * Type endpoints 
 * If need then provide RequestBody in json format and Path-variable or path-param.
 
## Doctor will perform following operations - 
 ##### 1) - Add Doctor Info -
* In AddDoctor functionality We Post Doctor info. through Postman and it gets added all Doctor Details in H2 database - 
 ##### -> Add Doctor EndPoints:
       * Home - localhost:8080/
       * Endpoint -/add-doctor

 
 ##### 2) - Get a Doctor Info by Id  or All Doctor Details-
* In this functionality We get a Doctor info. by sending the id in url through @Nullable @RequestParam. If I am not passing id then this functionality get all Doctor Details - 
  ##### -> EndPoints:
       * Home - localhost:8080/
       * Endpoint - /get-all-doctor
 
 
 ##### 3) - Get Docor by Experiance -
* This functionality provides all Docotr List Who have greater than 10 years experiance - 
 ##### -> EndPoints:
       * Home - localhost:8080/
       * Endpoint - /get-doctor-By-exp
 
 ## Patient will perform following operations - 
 ##### 1) - Add Patient Info-
* This functionality saved a Patient details - 
 ##### -> EndPoints:
       * Home - localhost:8080/
       * Endpoint -/admit-patient
 
 

 ##### 2) - Get all detils by providing Patien Id and Doctor Id-
 * This functionality get all details of Patient and Doctor by providing doctor Id and patient Id in @RequestParam -
 ##### -> EndPoints:
       * Home - localhost:8080/
       * Endpoint -/get-patient-by-id
 


### Note
* You can change server port by application.properties file i.e.

        server.port=8081
