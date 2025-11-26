# 🎵 Music Player Web Application

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
![Status](https://img.shields.io/badge/Status-Active-success)

A full-stack **Music Player Web Application** built using **Spring Boot** where users can register, log in, upload MP3 songs, and stream audio files. The project implements secure session-based authentication using **Spring Security**, and manages music storage and metadata using **MySQL and Hibernate**.

---

## ✨ Features

- 🔐 **User Authentication** with Spring Security
- 🆔 **Custom UserDetailsService** with password encryption (BCrypt)
- 📤 Upload and manage music tracks (MP3)
- 🎧 Stream audio directly in browser
- 🔁 REST APIs for music list and play endpoints
- 🛠 File handling and storage management
- 📦 Hibernate/JPA for database CRUD actions
- 🌐 Global model attributes using `@ControllerAdvice`
- 📋 Tested APIs using Postman
- 🎨 Frontend built with Thymeleaf, HTML, CSS, Bootstrap

---

## 🛠 Tech Stack

| Layer | Technology |
|--------|------------|
| Backend | Java, Spring Boot, Spring MVC, Spring Security |
| Frontend | Thymeleaf, HTML5, CSS3, JavaScript, Bootstrap |
| Database | MySQL, Hibernate/JPA |
| Tools | Maven, Git & GitHub, Postman |
| Server | Embedded Tomcat |

---

## 📂 Project Structure
- src
- ├── main
- │ ├── java
- │ │ └── com.example.MusicPlayer
- │ │ ├── Controller
- │ │ ├── Service
- │ │ ├── Repository
- │ │ ├── Models
- │ │ └── Config (Spring Security)
- │ └── resources
- │ ├── templates (Thymeleaf views)
- │ ├── static (CSS, JS)
- │ └── application.properties


---

## 🔗 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Home Page |
| GET | `/login` | Login Page |
| GET | `/register` | Registration Page |
| POST | `/register` | Register New User |
| POST | `/api/music/upload` | Upload MP3 File |
| GET | `/api/music/list` | List All Songs |
| GET | `/api/music/play/{id}` | Stream Music File |

---

## 🗄 Database Schema

### `users` Table
| Field | Type |
|--------|-------|
| id | bigint (PK) |
| email | varchar |
| password | varchar (BCrypt encrypted) |
| role | varchar |

### `music` Table
| Field | Type |
|--------|-------|
| id | bigint (PK) |
| title | varchar |
| file_path | text |
| user_id | bigint (FK) |

---

## 🔐 Authentication & Security

Implemented using:
```java
CustomUserDetailsService
BCryptPasswordEncoder
SecurityFilterChain
```
## 📦 Installation & Setup
# Clone the repository
git clone https://github.com/your-username/music-player.git

# Navigate into project folder
cd music-player

# Build & run the application
mvn spring-boot:run

##🧪 Testing

- API tested using Postman
- Verified session authentication & restricted endpoint access
- Multipart upload tested for MP3 files
