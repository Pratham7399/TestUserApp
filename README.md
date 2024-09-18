# Spring Boot CRUD Application with Kafka and MySQL
Spring Boot CRUD Application with Kafka and MySQL
This is a simple Spring Boot web application that implements CRUD operations with a MySQL database and event-driven messaging using Kafka. Every time a user is created, updated, or deleted, a message is sent to Kafka, and a Kafka consumer listens to these messages and stores audit logs in a MySQL audit table.

Table of Contents
Features
Prerequisites
Setup Instructions
Database Configuration
Kafka Configuration
Running the Application
Testing the API
License
Features
CRUD Operations: Create, Read, Update, Delete for user entity.
Event-Driven Messaging: Messages are published to Kafka on Create, Update, and Delete operations.
Audit Logs: Kafka consumer listens for messages and logs the events into an audit table in the MySQL database.
Prerequisites
Java 17 or later
Maven
MySQL (Cloud-hosted or local instance)
Kafka (Local or cloud-managed Kafka broker)
Setup Instructions
1. Clone the Repository
bash
Copy code
git clone https://github.com/yourusername/spring-boot-kafka-crud.git
cd spring-boot-kafka-crud
2. Install Maven Dependencies
Navigate to the root folder of the project and run:

bash
Copy code
mvn clean install
This will install all the necessary dependencies for the project.

Database Configuration
Configure your MySQL cloud database in the src/main/resources/application.properties file. Below is an example for connecting to a cloud-hosted MySQL database:

properties
Copy code
spring.datasource.url=jdbc:mysql://mysql-7399-prathamdb.c.aivencloud.com:15520/defaultdb?ssl-mode=REQUIRED
spring.datasource.username=avnadmin
spring.datasource.password=AVNS_76jNmqUosTodx06wvm_
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
Make sure to replace the URL, username, and password with your actual cloud database details.

3. Kafka Configuration
In the same application.properties file, configure Kafka by providing the bootstrap server information. If you're using a local Kafka broker, this is typically localhost:9092:

properties
Copy code
# Kafka Configuration
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=group_id
For cloud Kafka providers, replace localhost:9092 with the appropriate Kafka broker address.

Running the Application
You can run the Spring Boot application using Maven:

bash
Copy code
mvn spring-boot:run
Alternatively, you can build a JAR file and run it:

bash
Copy code
mvn clean package
java -jar target/spring-boot-kafka-crud-0.0.1-SNAPSHOT.jar
Testing the API
You can test the REST API using a tool like Postman or curl.

Create User
bash
Copy code
curl -X POST http://localhost:8080/users \
-H 'Content-Type: application/json' \
-d '{"name": "John", "email": "john@example.com"}'
Get All Users
bash
Copy code
curl http://localhost:8080/users
Update User
bash
Copy code
curl -X PUT http://localhost:8080/users/1 \
-H 'Content-Type: application/json' \
-d '{"name": "John Doe", "email": "john.doe@example.com"}'
Delete User
bash
Copy code
curl -X DELETE http://localhost:8080/users/1
Kafka messages will be automatically triggered on Create, Update, and Delete operations, and the consumer will log these into an audit table.

License
This project is licensed under the MIT License - see the LICENSE file for details.
