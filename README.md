# 🎓 University Microservices System

<img width="1171" height="512" alt="image" src="https://github.com/user-attachments/assets/e7e58a5f-4049-4f16-8081-87c36322a4b3" />
<img width="1329" height="790" alt="image" src="https://github.com/user-attachments/assets/2b933383-3286-4428-8422-bf0340a8ec06" />



## 📖 About The Project

This project is a **Proof of Concept (PoC)** application designed to demonstrate a **Microservices Architecture**.

The main goal of this project was to move away from a monolithic structure and learn how to build, deploy, and connect independent services. It features a modern Single Page Application (SPA) frontend that communicates with multiple backend services via RESTful APIs, all orchestrated using Docker.

### Key Learning Outcomes
* Designing loose coupling between services (**Department Service** & **Scientist Service**).
* Implementing **REST API** endpoints.
* Containerizing a full-stack application using **Docker**.
* Consuming APIs with **Angular**.

---

## 🛠️ Tech Stack

### Frontend
* **Angular** - Main framework for the UI.
* **TypeScript** - Application logic.
* **HTML/SCSS** - Styling and layout.

### Backend (Microservices)
* **Java (Spring Boot)** - Framework for building the REST APIs.
* **Spring Data JPA** - For database interactions.
* **PostgreSQL** - Relational database (dedicated instances for each service).

### DevOps & Infrastructure
* **Docker** - Containerization of all services.
* **Docker Compose** - Orchestration and local development setup.

---

## 🏗️ Architecture

The system is split into isolated services to ensure separation of concerns:

1.  **Frontend App**: An Angular application serving as the user interface.
2.  **Department Service**: Handles logic related to University Departments (CRUD operations).
3.  **Scientist Service**: Handles logic related to Scientists/Employees.
4.  **Databases**: Each microservice connects to its own isolated PostgreSQL database instance to preserve data sovereignty.

---

## 🚀 Getting Started

To run this project locally, you don't need to install Java, Node.js, or Postgres on your machine. You only need **Docker**.

### Prerequisites
* [Docker Desktop](https://www.docker.com/products/docker-desktop) installed.

### Installation & Running

1.  **Clone the repository**
    ```bash
    git clone https://github.com/pieter0100/servicesInJavaAndAngularFrontend.git
    cd servicesInJavaAndAngularFrontend
    ```

2.  **Build and Run with Docker Compose**
    This command will build the Angular app and Spring Boot JARs, create the Docker images, and start the containers.
    ```bash
    docker-compose up --build
    ```

3.  **Access the Application**
    * **Frontend:** Open [http://localhost:80](http://localhost:80) in your browser.
    * **Database Management (Adminer):** [http://localhost:8090](http://localhost:8090) (if included in your compose).
