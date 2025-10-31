# CatLog

A JavaFX-based desktop application for managing cat adoptions with role-based access control, real-time inventory management, and reservation tracking.

## Overview

This system provides a comprehensive solution for pet adoption centers to manage their cat inventory, handle customer reservations, and maintain user profiles. The application features separate interfaces for administrators and customers with role-specific functionalities.

## Demo
![Demo](./demo.gif)

## Features

### Administrator Functions
- Add, update, and delete cat records
- Manage user accounts (customers and other administrators)
- View all reservations across the system
- Monitor cat availability in real-time
- Track customer information and reservation history

### Customer Functions
- Browse available cats with detailed information
- Make reservations for available cats
- Cancel existing reservations
- View personal reservation history
- Update profile information

### System Capabilities
- Role-based authentication and authorization
- Real-time availability updates
- Data validation and error handling
- Transactional integrity for reservations
- Responsive JavaFX user interface

## Technology Stack

- **Language**: Java 17
- **UI Framework**: JavaFX 21.0.1
- **Database**: MySQL 8.0
- **Build Tool**: Maven
- **Architecture**: MVC (Model-View-Controller)

## Prerequisites

Before running this application, ensure you have installed:

1. Java Development Kit (JDK) 17 or higher
2. MySQL Server 8.0 or higher
3. Maven 3.6 or higher
4. JavaFX Runtime (included in project dependencies)

## Installation

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/pet-adoption-system.git
cd pet-adoption-system
```

### 2. Database Setup

Create and configure the MySQL database:

```bash
mysql -u root -p
```

Then run the following SQL:

```sql
CREATE DATABASE cat_breeder_system;
USE cat_breeder_system;
```

Execute the schema creation script located in `resources/cat_breeder_system.sql`:

```bash
mysql -u root -p cat_breeder_system < resources/cat_breeder_system.sql
```

### 3. Configure Database Connection

Update the database credentials in `DatabaseConnection.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/cat_breeder_system?useSSL=false";
private static final String USER = "your_username"; 
private static final String PASSWORD = "your_password";
```

### 4. Build the Project

```bash
mvn clean install
```

### 5. Run the Application

```bash
mvn javafx:run
```

## Usage

### Login Credentials

The system comes with pre-configured test accounts:

**Administrator Account:**
- User ID: 0000
- Email: test@a.com

**Customer Account:**
- User ID: 0001
- Email: test@c.com

### Workflow Example

1. **Administrator Workflow**
   - Login with admin credentials
   - Add new cats to the inventory
   - Set pricing and availability
   - Monitor all reservations
   - Manage user accounts

2. **Customer Workflow**
   - Login with customer credentials
   - Browse available cats
   - Select a cat and make a reservation
   - View reservation history
   - Cancel reservations if needed

## Project Structure

```
cat-breeder-system/
├── src/
│   └── main/
│       ├── java/
│       │   └── catlog/
│       │       ├── App.java                
│       │       ├── DatabaseConnection.java 
│       │       ├── Cat.java            
│       │       ├── User.java           
│       │       ├── Admin.java          
│       │       ├── Customer.java       
│       │       ├── Reservation.java   
│       │       ├── LoginController.java
│       │       ├── AdminController.java
│       │       ├── CustomerController.java
│       │       └── ProfileController.java
│       └── resources/
│           ├── loginView.fxml
│           ├── adminView.fxml
│           ├── customerView.fxml
│           ├── profileView.fxml
│           └── cat_log.sql
├── pom.xml
└── README.md
```

## Database Schema

### Tables

**Cat Table**
- `catID` (VARCHAR): Primary key
- `name` (VARCHAR): Cat's name
- `birthdate` (DATE): Date of birth
- `gender` (ENUM): Male or Female
- `color` (VARCHAR): Cat's color
- `price` (INT): Adoption fee
- `availability` (BOOLEAN): Availability status

**User Table**
- `userID` (VARCHAR): Primary key
- `name` (VARCHAR): User's full name
- `email` (VARCHAR): Email address
- `phone` (VARCHAR): Contact number
- `role` (ENUM): admin or customer

**Reservation Table**
- `reserveID` (VARCHAR): Primary key
- `catID` (VARCHAR): Foreign key to Cat table
- `userID` (VARCHAR): Foreign key to User table
- `reserveDate` (DATE): Date of reservation

## API Documentation

### Key Classes

**DatabaseConnection**
- Manages MySQL database connections
- Implements connection pooling for performance
- Handles connection errors gracefully

**AdminController**
- Handles all administrator operations
- Manages CRUD operations for cats and users
- Provides dashboard view for system monitoring

**CustomerController**
- Manages customer-specific operations
- Handles reservation creation and cancellation
- Displays available cats and reservation history

## Testing

Run the test suite:

```bash
mvn test
```

## Performance Considerations

- Database connections are managed efficiently through connection pooling
- Lazy loading implemented for large datasets
- Optimized queries with proper indexing
- Client-side caching for frequently accessed data

## Security Features

- SQL injection prevention through PreparedStatements
- Role-based access control at controller level
- Input validation for all user entries

## Known Limitations

- Single database configuration (no multi-tenancy)
- No export functionality for reports
- Limited search and filter capabilities
- No email notification system

## Future Enhancements

- RESTful API for mobile applications
- Advanced search with multiple filters
- Payment gateway integration
- Email notifications for reservations
- Analytics dashboard for adoption trends
- Multi-language support

## Troubleshooting

### Common Issues

**Database Connection Failed**
- Verify MySQL service is running
- Check database credentials in DatabaseConnection.java
- Ensure database and tables are created

**JavaFX Runtime Error**
- Verify JavaFX modules are properly configured
- Check Java version compatibility (requires Java 17+)

**Build Failures**
- Clear Maven cache: `mvn clean`
- Update dependencies: `mvn dependency:purge-local-repository`

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License. See LICENSE file for details.

## Contact

Project Maintainer - your.email@example.com

Project Link: https://github.com/yourusername/pet-adoption-system