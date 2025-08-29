# 📖 Blog App Backend

This is a **Spring Boot based Blog Application Backend** built with Java.  
It provides APIs to manage **Users, Categories, Posts, and Comments** with full CRUD operations.

---

## 🔗 Entity Relationships
- **Post ↔ User** (Many-to-One)  
- **Post ↔ Category** (Many-to-One)  
- **Comment ↔ User** (Many-to-One)  
- **Comment ↔ Post** (Many-to-One)  

---

## 🚀 Features
- 👤 **User Management** – CRUD operations  
- 📂 **Category Management** – Manage blog categories  
- 📝 **Post Management** – Create posts mapped with users & categories  
- 💬 **Comment Management** – Add comments mapped with users & posts  
- 🌐 **RESTful APIs** – Structured endpoints  
- ✅ **Validation & Exception Handling**  
- 📄 **Swagger API Documentation**  

---

## 🏗️ Tech Stack
- **Java 17+**  
- **Spring Boot 3+**  
- **Spring Data JPA (Hibernate)**  
- **MySQL**  
- **Maven**  
- **Lombok**  

---

## ⚙️ Installation & Setup

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/tripathi1108/Blog_App
cd Blog-App
