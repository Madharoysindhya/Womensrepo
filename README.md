# Women's Safety Escort Request System for Campus

A campus safety application for requesting and managing women's safety escort services.

## Technology Stack
- Java 17+
- Spring Boot 3
- Spring Data JPA / Hibernate
- MySQL
- React + Vite
- REST APIs
- Git / GitHub

## Features
- Student escort request form
- Request status dashboard
- Available escort list
- Assign escort to a request
- Update request status
- Search/filter requests
- Form validation
- Loading, success and error states
- Responsive UI
- CORS configuration for React

## Project Structure
- `backend/` Spring Boot REST API
- `frontend/` React application

## Database
Create a MySQL database:
```sql
CREATE DATABASE campus_safety;
```

Then update `backend/src/main/resources/application.properties`.

Default development configuration:
- host: localhost
- port: 3306
- database: campus_safety
- username: root
- password: root

## Run Backend
```bash
cd backend
mvn spring-boot:run
```
Backend runs on `http://localhost:8080`.

## Run Frontend
```bash
cd frontend
npm install
npm run dev
```
Frontend runs on the Vite URL, normally `http://localhost:5173`.

## API Endpoints
- `GET /api/escorts/available`
- `GET /api/requests`
- `GET /api/requests/{id}`
- `POST /api/requests`
- `PUT /api/requests/{id}/assign/{escortId}`
- `PUT /api/requests/{id}/status`
- `GET /api/requests/search?keyword=...`

## Sample Request
```json
{
  "studentName": "Ananya",
  "studentId": "ACET2026001",
  "pickupLocation": "Girls Hostel",
  "destination": "Main Gate",
  "requestedTime": "19:30",
  "notes": "Please provide an escort."
}
```

## Git/GitHub
Suggested commits:
1. `Initial Spring Boot backend`
2. `Add JPA entities and repositories`
3. `Add escort request REST APIs`
4. `Create React dashboard`
5. `Add validation and request status UI`
6. `Add responsive styling`
7. `Add README and project documentation`
