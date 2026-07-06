# Database Schema Design for Smart Clinic Management System

## Tables and Relationships

### 1. Doctor Table
```sql
CREATE TABLE doctor (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    specialty VARCHAR(100) NOT NULL
);

CREATE TABLE doctor_availability (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    doctor_id BIGINT NOT NULL,
    available_time VARCHAR(10) NOT NULL,
    FOREIGN KEY (doctor_id) REFERENCES doctor(id) ON DELETE CASCADE
);
