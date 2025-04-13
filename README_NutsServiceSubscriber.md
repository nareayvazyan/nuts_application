# 🧠 Nuts Service Subscriber

A simple Java Spring Boot application that subscribes to a RabbitMQ queue , processes messages, and stores them into a PostgreSQL database.

---

## 🏗 Architecture

- **QueueConsumer**: Listens for messages from RabbitMQ
- **QueueMessageHandler**: Validates and processes messages
- **StoredMessage & StoredMessageRepository**: Persists messages to PostgreSQL

---

## 📦 Technologies Used

- Java 17
- Spring Boot 3
- RabbitMQ
- PostgreSQL
- JPA + Hibernate
- JUnit 5 + Mockito (for testing)

---

## ⚙ How to Run

1. Start RabbitMQ and PostgreSQL locally.

2. Configure `src/main/resources/application.properties` file
3. Build and run the application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. Send a test message using the RabbitMQ web console or publisher.

---

## 🧪 Testing

Run all tests:
```bash
mvn test
```

### Included Tests:
- `QueueMessageHandlerTest` (unit test using Mockito)
- `StoredMessageRepositoryTest` (integration test using PostgreSQL)

Ensure PostgreSQL is running before running integration tests.

---

## 📂 Project Structure

```
src
├── main
│   └── java/org/nutssubscriber
│       ├── api/QueueConsumer.java
│       ├── service/QueueMessageHandler.java
│       └── repository/
│           ├── StoredMessage.java
│           └── StoredMessageRepository.java
├── test
│   └── java/org/nutssubscriber
│       ├── service/QueueMessageHandlerTest.java
│       └── repository/StoredMessageRepositoryTest.java
└── resources
    └── application.properties
```
