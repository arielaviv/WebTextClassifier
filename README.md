# Web Text Classifier

A Java-based REST API for URL text retrieval and categorization. This API fetches text content from given URLs, removes HTML tags, and categorizes the content based on predefined keyword categories. Built with SparkJava and Jsoup, it provides a simple yet robust backend solution for URL text analysis.

## Features
- **Text Retrieval**: Fetches and cleans text from URLs, removing HTML tags.
- **Categorization**: Matches the text against predefined categories based on keywords.
- **REST API**: Provides a POST endpoint for categorization requests.

## Prerequisites
- **Java 8** or higher
- **Gradle** for building the project
- **Git** for version control (if you're cloning the repository)

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/WebTextClassifier.git
   cd WebTextClassifier
   
# Build the project:
bash
Copy code
gradle build
Run the application:

bash
Copy code
gradle run -PmainClass=com.example.webtextclassifier.UrlCategorizationApi
API Usage
Endpoint
POST /categorize
Request Body (JSON)
Submit a JSON object with a list of URLs:

json
Copy code
{
  "urls": [
    "https://www.example.com",
    "https://www.another-example.com"
  ]
}
Response
The response will contain each URL with its matched categories:

json
Copy code
{
  "https://www.example.com": ["Category1", "Category2"],
  "https://www.another-example.com": []
}
Example Usage with cURL
bash
Copy code
curl -X POST http://localhost:4567/categorize \
-H "Content-Type: application/json" \
-d '{
  "urls": [
    "https://www.bbc.com",
    "https://www.nba.com/news/some-article"
  ]
}'

# Docker (Optional)
To run the application in a Docker container:

# Build the Docker image:
bash
Copy code
docker build -t webtextclassifier .
Run the container:
bash
Copy code
docker run -p 4567:4567 webtextclassifier

# License
This project is licensed under the MIT License. See the LICENSE file for details.

Future Improvements
Expand categorization to support more complex patterns.
Add monitoring and logging for production use.
Enhance keyword matching to handle synonyms.
