# TikiStore E-commerce API

## Project Overview
TikiStore is a robust E-commerce API built with Spring Boot, providing a complete solution for online shopping platforms. The API handles product management, user authentication, order processing, and more.

## Technology Stack
- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Gradle
- MySQL (or your preferred database)

## Project Structure
```
src/main/java/com/codegym/tikistore/
├── config/         # Configuration classes
├── constants/      # Application constants
├── controller/     # REST API controllers
├── dto/           # Data Transfer Objects
├── entitiy/       # JPA entities
├── exception/     # Custom exception handling
├── repository/    # JPA repositories
├── security/      # Security configuration
└── service/       # Business logic services
```

## Features
- User Authentication & Authorization
- Product Management
- Order Processing
- Shopping Cart
- Payment Integration
- Search and Filtering
- API Documentation

## Getting Started

### Prerequisites
- Java 17 or higher
- Gradle
- MySQL (or your preferred database)

### Installation
1. Clone the repository
```bash
git clone https://github.com/nguyenhuuton123/tiki-store-api.git
```

2. Configure the database
- Update `application.properties` with your database credentials

3. Build the project
```bash
./gradlew build
```

4. Run the application
```bash
./gradlew bootRun
```

## API Documentation
The API documentation is available at:
```
http://localhost:8080/swagger-ui.html
```

## Security
- JWT-based authentication
- Role-based access control
- Password encryption
- CSRF protection

## Contributing
1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License
This project is licensed under the MIT License - see the LICENSE file for details

## Contact
For any queries or support, please contact:
- Email: nhtonx1@gmail.com
