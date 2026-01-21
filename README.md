# Parking-System
Parking Management System is a console-based Java application developed using Java, JDBC, and MySQL. It manages parking slots, vehicle entry and exit, and maintains parking records using a menu-driven interface.


# 🚗 Parking Management System (Java JDBC + MySQL)

## 📌 Project Overview
The **Parking Management System** is a console-based Java application developed using **Java, JDBC, and MySQL**.  
This system is designed to manage parking slots efficiently by handling vehicle entry, exit, and slot availability in real time.

The project demonstrates real-world usage of **JDBC database connectivity** and **menu-driven console programming**.

---

## 🛠 Technologies Used
- Java (Core Java)
- JDBC (Java Database Connectivity)
- MySQL Database
- MySQL Connector/J
- Eclipse / IntelliJ IDEA

---

## ✨ Features
- Park a vehicle
- Remove a vehicle
- View currently parked vehicles
- Automatic parking slot allocation
- Update slot availability (AVAILABLE / OCCUPIED)
- Menu-driven console interface
- Secure database operations using PreparedStatement

---

## 📂 Project Structure

ParkingManagementSystem
│
├── DBConnection.java
├── ParkingService.java
├── VehicleService.java
└── MainApp.java


---

## 🗄 Database Structure

### Database Name


parking_db


### Tables

#### parking_slots
| Column | Type |
|------|------|
| slot_id | INT (PK, AUTO_INCREMENT) |
| status | VARCHAR (AVAILABLE / OCCUPIED) |

#### vehicles
| Column | Type |
|------|------|
| vehicle_id | INT (PK, AUTO_INCREMENT) |
| vehicle_no | VARCHAR |
| slot_id | INT (FK) |
| entry_time | TIMESTAMP |
| exit_time | TIMESTAMP |

---

## ⚙ How to Run the Project

1. Install **Java JDK**
2. Install **MySQL Server**
3. Create the database and tables using the provided SQL script
4. Insert initial parking slots into `parking_slots` table
5. Add **MySQL Connector/J** to the project
6. Update database username and password in `DBConnection.java`
7. Run `MainApp.java`

---

## 🎯 Learning Outcomes
- JDBC connection handling
- CRUD operations with MySQL
- Foreign key relationships
- PreparedStatement usage
- Menu-driven console application
- Real-world parking slot management logic

---

## 🚀 Future Enhancements
- Parking fee calculation based on time
- Vehicle search by number
- Daily parking report
- Admin login system
- GUI using JavaFX or Swing

---

## 👨‍💻 Author
**Manish Pal**  
Java Developer | Fresher  

---

## ⭐ Support

