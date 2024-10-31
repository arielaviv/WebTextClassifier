# WebTextClassifier

A Java-based web text categorization application that categorizes URLs based on predefined keywords using a REST API. The project is containerized using Docker for easy deployment.

## Features
- Categorizes web page content based on predefined categories.
- Provides a REST API for URL categorization.
- Dockerized for seamless deployment.

## Technologies Used
- **Java 8**
- **Spark Framework** for REST API
- **Gson** for JSON processing
- **Jsoup** for HTML parsing
- **Docker** for containerization

## Getting Started

### Prerequisites
- Java 8+
- Docker (optional, if running with Docker)
- Gradle

### Installation
1. **Clone the repository**:
   ```
   git clone https://github.com/yourusername/WebTextClassifier.git
    ```
### Navigate to the project's directory:
   ```
      cd WebTextClassifier
   ```

### Build the project:
To build the application, run:
```
 gradle build
```

## Running the Application
### Run Locally
Start the application:
```
   gradle run
```

### Run with Docker
1. Build the Docker image:
```
   docker build -t webtextclassifier .
``` 
3. Run the Docker image:
   ```
   docker run -p 4567:4567 webtextclassifier
   ```
   
4. Access the API: You can access the API at http://localhost:4567/categorize in the same way as the local setup.
   
## API Documentation
Endpoint: /categorize
Method: POST
Description: Categorizes content from the provided URLs based on predefined keywords.
Request Body:
json
```
{
  "urls": ["<URL1>", "<URL2>", ...]
}
```

Response: JSON object with each URL as a key and a list of categories as the value.

Example response:
json
```
{
  "https://www.bbc.com": ["News", "World"],
  "https://www.nba.com/news/heat-unveil-statue-of-dwyane-wade-at-kaseya-center-in-miami": ["Basketball"]
}
```

## Contributing
If you would like to contribute, feel free to fork the repository and make changes. Pull requests are welcome.

## License
This project is licensed under the MIT License.
