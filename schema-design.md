# Database Schema Design

## Table: Doctor
* id (INT, Primary Key)
* name (VARCHAR)
* specialty (VARCHAR)

## Table: Patient
* id (INT, Primary Key)
* name (VARCHAR)
* email (VARCHAR)

## Table: Appointment
* id (INT, Primary Key)
* doctor_id (INT, Foreign Key)
* patient_id (INT, Foreign Key)
* appointment_date (DATETIME)
