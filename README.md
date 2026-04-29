<p align="center">
  <b>🎨 Online Art Gallery — Full Stack Project</b>
</p>

<p align="center">
React (Vite) Frontend + Spring Boot Backend for an Online Art Marketplace
</p>

---

## 🔗 Full Project Repository

👉 https://github.com/shaikreshmashaik2007-afk/FSAD_ONLINE_ART_GALLERY_FRONTEND_AND_BACKEND.git

---

## 🌐 Live Demo

* 🎨 **Frontend (Vercel):** https://online-art-gallery-frontend.vercel.app/
* ⚙️ **Backend (Render):** https://fsad-online-art-gallery-frontend-and.onrender.com/

> ⚠️ Root `/` returns 403 (secured API). Use endpoints like `/api/auth/login`

---

## 🧰 Tech Stack

### 🎨 Frontend

* React (Vite)
* Axios
* React Router DOM
* React Toastify
* Razorpay JS SDK
* Vercel Deployment

### ⚙️ Backend

* Spring Boot 3.1.5
* Java 21
* Spring Security + JWT
* MySQL (Railway)
* Hibernate / JPA
* Razorpay Integration
* Docker + Render Deployment

---

## ✨ Features

### 👤 Authentication

* User Signup & Login (JWT)
* Role-based access (Admin/User)

### 🖼 Artwork System

* Browse artworks
* View artwork details
* Admin CRUD operations

### 🛒 Payments

* Razorpay integration
* Order creation & verification

### 🔒 Security

* Protected APIs
* Secure routes

### 📱 UI/UX

* Fully responsive frontend
* Clean modern design

---

## 🔑 API Endpoints

### Auth

| Method | Endpoint             |
| ------ | -------------------- |
| POST   | `/api/auth/register` |
| POST   | `/api/auth/login`    |

### Artworks

| Method | Endpoint        | Auth    |
| ------ | --------------- | ------- |
| GET    | `/api/artworks` | ❌       |
| POST   | `/api/artworks` | ✅ Admin |

### Payments

| Method | Endpoint                     |
| ------ | ---------------------------- |
| POST   | `/api/payments/create-order` |
| POST   | `/api/payments/verify`       |

---

## ⚡ Local Setup

### 🔹 Frontend

```bash id="frontend-setup"
git clone https://github.com/shaikreshmashaik2007-afk/Online-Art-Gallery-Frontend.git
cd Online-Art-Gallery-Frontend
npm install
npm run dev
```

---

### 🔹 Backend

```bash id="backend-setup"
git clone https://github.com/shaikreshmashaik2007-afk/Online-Art-Gallery-BackEnd.git
cd Online-Art-Gallery-BackEnd
mvn clean package -DskipTests
java -jar target/*.jar
```

---

## 🐳 Docker (Backend)

```dockerfile id="dockerfile"
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## 🚀 Deployment

### Frontend (Vercel)

* Import repo
* Set root: `online-art-gallery`
* Deploy

### Backend (Render)

* Dockerfile Path: `gallery/Dockerfile`
* Build Context: `gallery`
* Add environment variables:

```
JWT_SECRET=your_secret
RAZORPAY_KEY_ID=your_key
RAZORPAY_KEY_SECRET=your_secret
```

---

## 📁 Project Structure

```
root/
├── gallery/                # Spring Boot backend
├── online-art-gallery/     # React frontend
```

---

## 🎯 Project Highlights

* Full-stack integration (React + Spring Boot)
* Secure authentication with JWT
* Payment gateway integration
* Cloud deployment (Vercel + Render + Railway)
* Production-ready architecture

---

## 🔗 Related

* 🎨 Frontend Repo: https://github.com/shaikreshmashaik2007-afk/Online-Art-Gallery-Frontend
* ⚙️ Backend Repo: https://github.com/shaikreshmashaik2007-afk/Online-Art-Gallery-BackEnd

---
