#!/bin/bash

# Spring AI Demo - API Usage Examples
# Make sure the application is running on localhost:8080

echo "🤖 Spring AI Demo - API Examples"
echo "================================="

BASE_URL="http://localhost:8080/api/ai"

echo ""
echo "1. Testing Chat API..."
echo "Request: Simple question about machine learning"
echo ""

curl -s -X POST $BASE_URL/chat \
  -H "Content-Type: application/json" \
  -d '{
    "content": "What is machine learning in simple terms?"
  }' | jq -r '.'

echo ""
echo ""
echo "2. Testing Template Generation..."
echo "Request: Generate beginner-friendly explanation about Docker"
echo ""

curl -s -X POST $BASE_URL/generate \
  -H "Content-Type: application/json" \
  -d '{
    "topic": "Docker containers",
    "complexity": "beginner-friendly"
  }' | jq -r '.'

echo ""
echo ""
echo "3. Testing Text Embeddings..."
echo "Request: Generate embeddings for sample text"
echo ""

EMBEDDING_RESPONSE=$(curl -s -X POST $BASE_URL/embed \
  -H "Content-Type: application/json" \
  -d '"Machine learning is a subset of artificial intelligence"')

echo "Embedding vector (first 10 dimensions):"
echo $EMBEDDING_RESPONSE | jq '.[0:10]'

echo ""
echo ""
echo "4. Testing Similarity Search (Demo)..."
echo "Request: Find similar texts for AI-related query"
echo ""

SIMILAR_RESPONSE=$(curl -s -X POST $BASE_URL/similar \
  -H "Content-Type: application/json" \
  -d '"Deep learning neural networks"')

echo "Similar text embeddings (first 10 dimensions):"
echo $SIMILAR_RESPONSE | jq '.[0:10]'

echo ""
echo ""
echo "✅ All API endpoints tested successfully!"
echo "🔍 Check the responses above for AI-generated content"