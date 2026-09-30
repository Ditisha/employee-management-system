# Employee Management System

A full stack Java web application to manage employees and departments.
Built with **Spring Boot, Spring Data JPA, MySQL** and a simple **HTML/CSS/JavaScript** frontend that calls the REST API.

## Features
- Create, view, update and delete employees (CRUD)
- Search employees by name
- Department management (one department has many employees)
- Input validation with clear error messages
- Global exception handling with proper HTTP status codes (400, 404, 409)
- Runs on MySQL, or on an in-memory H2 database with no setup

## Tech stack
| Layer | Technology |
|-------|------------|
| Backend | Java 17, Spring Boot 3, Spring Web, Spring Data JPA, Bean Validation |
| Database | MySQL (H2 for quick demo) |
| Frontend | HTML, CSS, JavaScript (fetch API) |
| Build tool | Maven |

## Project structure
```
src/main/java/com/ditisha/ems
├── controller   REST controllers (EmployeeController, DepartmentController)
├── service      Business logic (EmployeeService)
├── repository   Spring Data JPA repositories
├── model        JPA entities (Employee, Department)
└── exception    Custom exception + global handler
src/main/resources
├── static/index.html   Frontend
└── application*.properties
```

## How to run

**Prerequisites:** JDK 17+, Maven, MySQL (optional)

### Option 1: Quick start with H2 (no database setup)
```
mvn spring-boot:run -Dspring-boot.run.profiles=h2
```

### Option 2: MySQL
1. Create the database: `CREATE DATABASE ems_db;`
2. Set your credentials (or edit `application.properties`):
   ```
   export DB_USERNAME=root
   export DB_PASSWORD=your_password
   ```
3. Run: `mvn spring-boot:run`

Open **http://localhost:8080** in your browser.

## REST API
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/employees` | List all employees (optional `?search=name`) |
| GET | `/api/employees/{id}` | Get one employee |
| POST | `/api/employees` | Create an employee |
| PUT | `/api/employees/{id}` | Update an employee |
| DELETE | `/api/employees/{id}` | Delete an employee |
| GET | `/api/departments` | List departments |
| POST | `/api/departments` | Create a department |

**Sample request body**
```json
{
  "name": "Asha Patil",
  "email": "asha@example.com",
  "salary": 45000,
  "department": { "id": 1 }
}
```

## Screenshots
_Add a screenshot of the running app here._

## Future improvements
- Spring Security login
- Pagination and sorting
- Unit tests with JUnit and Mockito
- Deployment on Render or Railway

## Author
Ditisha Mohite, BE Information Technology
