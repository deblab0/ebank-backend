# 🏦 eBank Backend - Spring Boot

This is the **Spring Boot backend** for the eBank mini-projet, developed as part of the *Architecture des Composants d’Entreprise* coursework. It manages authentication, banking logic, and REST API endpoints for clients and agents.

---

## 🚀 Stack
- Java 17
- Spring Boot 3.x
- Spring Security (JWT)
- Spring Data JPA (MySQL)
- Lombok
- JavaMailSender (optional for notifications)

---

## ⚙️ Project Setup in IntelliJ IDEA

### 1. Clone the repository
```bash
git clone https://github.com/your-username/ebank-backend.git
cd ebank-backend
```

### 2. Create a MySQL database
```sql
CREATE DATABASE ebank_db;
CREATE USER 'ebank_user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON ebank_db.* TO 'ebank_user'@'localhost';
FLUSH PRIVILEGES;
```

### 3. Configure `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ebank_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=ebank_user
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

jwt.secret=MySuperSecretKeyForJWT1234567890@!
```

### 4. Run the project
- Open `EbankBackendApplication.java`
- Click ▶️ to start the server at `http://localhost:8080`

---

## 🧪 Endpoints Overview
| Endpoint                     | Method | Role             | Description                          |
|-----------------------------|--------|------------------|--------------------------------------|
| `/auth/login`               | POST   | Public           | Authenticate and receive JWT         |
| `/auth/change-password`     | POST   | Authenticated    | Update user password (RG_1)          |
| `/agent/clients`            | POST   | AGENT_GUICHET    | Add new client                       |
| `/agent/comptes`            | POST   | AGENT_GUICHET    | Create new bank account              |
| `/client/dashboard`         | GET    | CLIENT           | View user accounts                   |
| `/client/virement`          | POST   | CLIENT           | Transfer funds                       |
| `/client/transactions`      | GET    | CLIENT           | Get latest transactions by RIB       |

---

## ✅ Features Implemented
- JWT Authentication with secure filter
- Custom User + Role entity model
- CRUD for Client, CompteBancaire, Operation
- Virement with debit/credit tracking (RG_11 to RG_15)
- Global CORS support for frontend
- DTO separation from entities

---

## 🔐 Security Notes
- Passwords hashed with `BCryptPasswordEncoder`
- JWT stored in Authorization header (Bearer)
- `@PreAuthorize` used to enforce role access

---

## 🧩 Architecture
- **Entities:** Client, CompteBancaire, Operation, User
- **Enums:** Role, StatutCompte, OperationType
- **Repositories:** JPA interfaces for each entity
- **Services:** Business logic for client/account/auth
- **Controllers:** REST endpoints secured via Spring Security

---

## 📦 Build & Deploy
```bash
./mvnw clean install
java -jar target/ebank-backend-0.0.1-SNAPSHOT.jar
```

Or deploy to cloud platforms like Heroku, Render, etc.

---

## 🧠 Final Tips
- Be sure to start MySQL before backend
- Keep your JWT secret safe!
- Sync frontend `.env` with backend port and URL

> Project delivered for educational purposes under the supervision of your academic team.
