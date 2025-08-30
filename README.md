# 📒 Notes Application

A full-stack notes application built with Spring Boot backend and React frontend.

## 📂 Project Structure
- **Backend** → Spring Boot (Java 21, Maven, MySQL)  
- **Frontend** → React + Vite (CSS)  
- **Database** → MySQL  

---

## ⚙️ Backend (Spring Boot)
The backend provides a RESTful API for managing notes.

### 🔧 Technologies Used
- Java 21  
- Spring Boot 3.4.9  
- Spring Data JPA  
- MySQL  
- Maven  

### 📡 API Endpoints
- `GET /notes` → Get all notes  
- `GET /notes/{id}` → Get a specific note  
- `POST /notes` → Create a new note  
- `PUT /notes/{id}` → Update an existing note  
- `DELETE /notes/{id}` → Delete a note  

### 🚀 Setup
Configure MySQL database in **application.properties**:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/notes
spring.datasource.username=root
spring.datasource.password=
```

Run backend:
```bash
cd notesBackend
./mvnw spring-boot:run
```

---

## 🎨 Frontend (React + Vite)
The frontend is built with React and Vite.

### 🔧 Technologies Used
- React  
- Vite  
- CSS  

### 🚀 Setup
Install dependencies:
```bash
npm install
```

Run development server:
```bash
npm run dev
```

The application will be available at → [http://localhost:5173](http://localhost:5173)

---

## ✨ Features
- Create, Read, Update, and Delete (CRUD) notes  
- Persistent storage using MySQL database  
- Responsive web interface  
- Cross-origin resource sharing (CORS) enabled  

---

## 🛠 Development
- Backend → [http://localhost:8080](http://localhost:8080)  
- Frontend → [http://localhost:5173](http://localhost:5173)  
- MySQL database → Port **3306**  

---

## 📜 License
This project is **MIT Licensed**.
