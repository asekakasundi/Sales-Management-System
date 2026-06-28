# 🛒 Sales Management System

A Java Swing desktop application for managing products, customers, sales transactions, and invoices using MySQL and JDBC.

## Features

- User authentication (Login)
- Product management
  - Add products
  - Update products
  - Delete products
  - View product list
- Customer management
  - Add customers
  - View customer details
- Sales transaction management
  - Select customers
  - Add products to a sale
  - Calculate totals automatically
  - Save sales records
- Invoice generation
- MySQL database integration using JDBC
- Input validation and error handling

## Technologies Used

- Java
- Java Swing
- JDBC
- MySQL
- NetBeans IDE
- Object-Oriented Programming (OOP)

## Project Structure

```
src/
│
├── model/             # Entity classes
├── dao/               # Database operations
├── database/          # Database connection
├── ui/                # GUI forms
└── main/              # Application entry point
```

## Database

The application uses a MySQL database to store:

- Users
- Products
- Customers
- Sales
- Sale Items

Import the provided SQL file before running the project.

## Installation

1. Clone the repository

```bash
git clone https://github.com/your-username/sales-management-system.git
```

2. Open the project in NetBeans (or any Java IDE).

3. Create a MySQL database.

4. Import the provided SQL script.

5. Update the database credentials in the database connection class.

Example:

```java
private static final String URL = "jdbc:mysql://localhost:3306/salesdb";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

6. Build and run the project.

## Screenshots

Add screenshots here.

- Login Screen
- Dashboard
- Product Management
- Customer Management
- Sales Screen
- Invoice Screen

## OOP Concepts Used

- Encapsulation
- Inheritance
- Abstraction
- Polymorphism
- DAO (Data Access Object) Design Pattern

## Future Improvements

- Password hashing for improved security
- PDF invoice export
- Sales reports
- Product search and filtering
- Role-based user authentication
- Stock alerts
- Transaction management using JDBC

## Author

**Aseka Kasundi**

ICT 1062 – Object-Oriented Programming Final Assignment

University of Sri Jayewardenepura

## License

This project was developed for educational purposes only.
