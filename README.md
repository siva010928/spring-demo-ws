# Java REST API with Spring Boot

This project is a RESTful web service developed with Spring Boot. It is designed to provide a simple yet powerful framework for creating Java-based web services with minimal configuration.

## Prerequisites

Before you can run this project, you need to have the following installed:
- Java JDK 17
- Gradle (compatible with the version defined in `build.gradle`)

## Project Structure

The project uses the following key dependencies:
- **Spring Boot Starter Web**: Provides all the necessary dependencies to build a web application.
- **Jackson Dataformat XML**: Supports XML output.
- **Spring Boot Starter Validation**: Adds support for validation using the Hibernate Validator and Jakarta Validation API.
- **Spring Boot Starter Test**: Facilitates testing of the application using Spring Boot's testing support.

## Setup and Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/your-project-name.git
   cd your-project-name
   ```

2. **Build the project:**
   ```bash
   ./gradlew build
   ```

3. **Run the application:**
   ```bash
   ./gradlew bootRun
   ```

   This command will start the application on the default port `8080`.

## Testing

To run the tests included in the project:
```bash
./gradlew test
```

## Usage

Once the application is running, you can access the API endpoints using any HTTP client such as cURL, Postman, or your browser (for GET requests).

Example of a cURL request:
```bash
curl -X GET http://localhost:8080/api/resource
```

Replace `/api/resource` with the actual resource path you wish to access.