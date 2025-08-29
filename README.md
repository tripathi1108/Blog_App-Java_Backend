Blog App Backend

This is a Spring Boot based Blog Application Backend built with Java.
It provides APIs to manage Users, Categories, Posts, and Comments with full CRUD operations.

The relationships are defined as:

Post ↔ User (Many-to-One)

Post ↔ Category (Many-to-One)

Comment ↔ User (Many-to-One)

Comment ↔ Post (Many-to-One)

🚀 Features

User Management – CRUD operations

Category Management – Manage blog categories

Post Management – Create posts mapped with users & categories

Comment Management – Add comments mapped with users & posts

RESTful APIs – Structured endpoints

Validation & Exception Handling

Swagger API Documentation

🏗️ Tech Stack

Java 17+
Spring Boot 3+
Spring Data JPA (Hibernate)
MySQL 
Maven
Lombok



⚙️ Installation & Setup
1️⃣ Clone the Repository
git clone: https://github.com/tripathi1108/Blog_App
cd Blog-App

2️⃣ Configure Database

Update src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/blogdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3️⃣ Build & Run
mvn clean install
mvn spring-boot:run
Server will start on:
👉 http://localhost:8080/

📌 API Endpoints
##User APIs

POST /api/users/ → Create user
GET /api/users/{id} → Get user by ID
PUT /api/users/{id} → Update user
DELETE /api/users/{id} → Delete user

Category APIs

POST /api/categories/ → Create category
GET /api/categories/{id} → Get category
PUT /api/categories/{id} → Update category
DELETE /api/categories/{id} → Delete category

Post APIs

POST /api/posts/user/{userId}/category/{categoryId} → Create post
GET /api/posts/{id} → Get post
PUT /api/posts/{id} → Update post
DELETE /api/posts/{id} → Delete post

Comment APIs

POST /api/comments/post/{postId}/user/{userId} → Add comment
GET /api/comments/{id} → Get comment
DELETE /api/comments/{id} → Delete comment

