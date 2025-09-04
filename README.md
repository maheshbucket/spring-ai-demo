# Spring AI Demo Application

This is a demonstration application showcasing the integration of **Spring Boot** with the **Spring AI framework** to build AI-powered applications. The demo illustrates how to create REST APIs that leverage OpenAI's models for chat interactions, content generation, and text embeddings.

## 🌟 Features

### 1. Interactive Chat API
- **Endpoint**: `POST /api/ai/chat`
- **Description**: Send messages to OpenAI's GPT model and receive intelligent responses
- **Use Case**: Build chatbots, virtual assistants, or interactive Q&A systems

### 2. Template-Based Content Generation
- **Endpoint**: `POST /api/ai/generate`  
- **Description**: Generate structured content using templates with dynamic parameters
- **Use Case**: Create explanations, tutorials, or documentation with varying complexity levels

### 3. Text Embedding Generation
- **Endpoint**: `POST /api/ai/embed`
- **Description**: Convert text into numerical vector representations
- **Use Case**: Semantic search, similarity analysis, clustering, and recommendation systems

### 4. Similarity Search (Demo)
- **Endpoint**: `POST /api/ai/similar`
- **Description**: Find similar texts using embedding vectors (simplified demo implementation)
- **Use Case**: Content recommendation, duplicate detection, semantic search

## 🛠️ Technology Stack

- **Spring Boot 3.2.3** - Application framework
- **Spring AI 1.0.0-M6** - AI integration framework
- **OpenAI GPT-3.5-turbo** - Chat completion model
- **OpenAI text-embedding-ada-002** - Text embedding model
- **Java 17** - Programming language
- **Maven** - Build tool
- **Lombok** - Boilerplate code reduction

## 📋 Prerequisites

1. **Java 17 or higher**
2. **Maven 3.6+**
3. **OpenAI API Key** - Sign up at [OpenAI](https://platform.openai.com/)

## ⚙️ Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/maheshbucket/spring-ai-demo.git
cd spring-ai-demo
```

### 2. Set OpenAI API Key
Set your OpenAI API key as an environment variable:

**Linux/macOS:**
```bash
export OPENAI_API_KEY="your-openai-api-key-here"
```

**Windows:**
```cmd
set OPENAI_API_KEY=your-openai-api-key-here
```

**Alternative**: Create an `application-local.properties` file:
```properties
spring.ai.openai.api-key=your-openai-api-key-here
```

### 3. Build and Run
```bash
# Build the application
./mvnw clean compile

# Run tests
./mvnw test

# Start the application
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

## 🚀 API Usage Examples

### Chat API
Send a message to the AI assistant:

```bash
curl -X POST http://localhost:8080/api/ai/chat \
  -H "Content-Type: application/json" \
  -d '{
    "content": "Explain what is machine learning in simple terms"
  }'
```

### Template-Based Generation
Generate structured content:

```bash
curl -X POST http://localhost:8080/api/ai/generate \
  -H "Content-Type: application/json" \
  -d '{
    "topic": "Docker containers",
    "complexity": "beginner-friendly"
  }'
```

### Text Embeddings
Generate embeddings for text:

```bash
curl -X POST http://localhost:8080/api/ai/embed \
  -H "Content-Type: application/json" \
  -d "Machine learning is a subset of artificial intelligence"
```

### Similarity Search
Find similar texts (demo):

```bash
curl -X POST http://localhost:8080/api/ai/similar \
  -H "Content-Type: application/json" \
  -d "Deep learning neural networks"
```

## 📊 Example Responses

### Chat Response
```json
"Machine learning is a branch of artificial intelligence that enables computers to learn and make decisions from data without being explicitly programmed for every task..."
```

### Embedding Response
```json
[0.0128, -0.0234, 0.0456, -0.0123, ...]
```

## 🏗️ Project Structure

```
src/main/java/com/mahesh/spring/ai/demo/
├── SpringAiDemoApplication.java     # Main application class
├── controller/
│   └── AiController.java            # REST API endpoints
├── service/
│   └── AiService.java               # AI business logic
└── model/
    ├── ChatMessage.java             # Chat message model
    └── TemplateRequest.java         # Template request model
```

## 🔧 Configuration

The application uses the following configuration in `application.properties`:

```properties
# Application name
spring.application.name=spring-ai-demo

# OpenAI Configuration
spring.ai.openai.api-key=${OPENAI_API_KEY}
spring.ai.openai.model=gpt-3.5-turbo
spring.ai.openai.embedding-model=text-embedding-ada-002

# Server Configuration
server.port=8080
```

## 🔍 Key Components Explained

### AiService
The core service class that:
- Configures the ChatClient with system prompts
- Handles chat conversations with context
- Generates content using templates
- Creates text embeddings for similarity analysis
- Includes utility methods for cosine similarity calculation

### AiController
REST controller that exposes AI functionality through HTTP endpoints:
- `/chat` - Interactive conversations
- `/generate` - Template-based generation  
- `/embed` - Text embedding creation
- `/similar` - Similarity search (demo)

### Models
- **ChatMessage**: Represents user input with role and content
- **TemplateRequest**: Contains topic and complexity for content generation

## 🚦 Testing

Run the test suite to ensure everything works correctly:

```bash
./mvnw test
```

The tests verify:
- Application context loads correctly
- Spring AI dependencies are properly configured
- All components integrate successfully

## 🎯 Use Cases & Applications

This demo can be extended for various applications:

1. **Customer Support Chatbots** - Use the chat API for automated customer service
2. **Content Generation Tools** - Leverage templates for creating documentation, tutorials, or marketing content
3. **Semantic Search Systems** - Use embeddings to build intelligent search functionality
4. **Recommendation Engines** - Utilize similarity calculations for content recommendations
5. **Knowledge Management** - Create AI-powered FAQ systems or knowledge bases

## 🔮 Future Enhancements

Potential improvements and extensions:

- [ ] Add vector database integration (PostgreSQL with pgvector)
- [ ] Implement proper similarity search with stored embeddings
- [ ] Add conversation history and context management
- [ ] Include function calling capabilities
- [ ] Add streaming responses for real-time chat
- [ ] Implement rate limiting and API key management
- [ ] Add support for multiple AI providers
- [ ] Create a web UI for interactive testing

## 📚 Learn More

- [Spring AI Documentation](https://docs.spring.io/spring-ai/docs/current/reference/html/)
- [OpenAI API Documentation](https://platform.openai.com/docs)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👨‍💻 Author

**Mahesh** - AI enthusiast and Spring developer

---

**Note**: This is a demonstration application. For production use, implement proper error handling, security measures, rate limiting, and monitoring.