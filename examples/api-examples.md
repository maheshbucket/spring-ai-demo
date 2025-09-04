# API Examples - JSON Requests

## 1. Chat API Examples

### Simple Question
```json
POST /api/ai/chat
{
  "content": "What is Spring Framework?"
}
```

### Technical Question
```json
POST /api/ai/chat
{
  "content": "Explain microservices architecture with pros and cons"
}
```

### Code Request
```json
POST /api/ai/chat
{
  "content": "Show me a simple REST controller example in Spring Boot"
}
```

## 2. Template Generation Examples

### Beginner Tutorial
```json
POST /api/ai/generate
{
  "topic": "Kubernetes",
  "complexity": "beginner-friendly"
}
```

### Technical Deep Dive
```json
POST /api/ai/generate
{
  "topic": "GraphQL vs REST API",
  "complexity": "technical"
}
```

### Simple Overview
```json
POST /api/ai/generate
{
  "topic": "Cloud computing",
  "complexity": "simple"
}
```

## 3. Embedding Examples

### Technical Text
```json
POST /api/ai/embed
"Spring Boot is a Java framework that simplifies application development"
```

### Business Text
```json
POST /api/ai/embed
"Customer satisfaction is crucial for business success and growth"
```

### Code Description
```json
POST /api/ai/embed
"This function calculates the factorial of a given number using recursion"
```

## 4. Similarity Search Examples

### Finding Similar Concepts
```json
POST /api/ai/similar
"Artificial intelligence and machine learning"
```

### Technology Comparison
```json
POST /api/ai/similar
"React vs Angular framework comparison"
```

### Development Topics
```json
POST /api/ai/similar
"Agile methodology and scrum practices"
```

## Expected Response Formats

### Chat Response
```
"Spring Framework is a comprehensive programming and configuration model 
for modern Java-based enterprise applications..."
```

### Embedding Response
```json
[0.0128, -0.0234, 0.0456, -0.0123, 0.0891, ...]
```

Note: Embedding responses contain 1536 dimensions for OpenAI's text-embedding-ada-002 model.