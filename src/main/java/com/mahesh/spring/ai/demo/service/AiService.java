package com.mahesh.spring.ai.demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service class that provides AI-powered functionalities including:
 * - Chat conversations with OpenAI GPT models
 * - Template-based content generation
 * - Text embedding generation for similarity analysis
 * 
 * This service demonstrates the core capabilities of Spring AI framework
 * for building AI-powered applications.
 */
@Service
public class AiService {

    private final ChatClient chatClient;
    private final EmbeddingModel embeddingModel;

    @Autowired
    public AiService(ChatClient.Builder chatClientBuilder, EmbeddingModel embeddingModel) {
        // Configure the chat client with a system message for consistent behavior
        this.chatClient = chatClientBuilder
            .defaultSystem("""
                You are a helpful AI assistant with expertise in programming and technology.
                Provide clear, concise, and accurate responses.
                Include code examples when relevant.
                """)
            .build();
        this.embeddingModel = embeddingModel;
    }

    /**
     * Sends a chat message to the AI model and returns the response.
     * 
     * @param message The user's message/question
     * @return ChatResponse containing the AI's reply
     */
    public ChatResponse chat(String message) {
        return chatClient.prompt()
            .user(message)
            .call()
            .chatResponse();
    }

    /**
     * Generates content using a template with dynamic parameters.
     * 
     * @param topic The topic to explain
     * @param complexity The complexity level (e.g., "simple", "detailed", "technical")
     * @return ChatResponse containing the generated explanation
     */
    public ChatResponse generateWithTemplate(String topic, String complexity) {
        String templateMessage = String.format(
            "Create a %s explanation about %s. Include key points and examples where relevant.",
            complexity, topic
        );
        
        return chatClient.prompt()
            .user(templateMessage)
            .call()
            .chatResponse();
    }

    /**
     * Generates text embeddings for the given text.
     * Embeddings are vector representations that can be used for similarity analysis.
     * 
     * @param text The text to generate embeddings for
     * @return List of Double values representing the embedding vector
     */
    public List<Double> generateEmbedding(String text) {
        EmbeddingRequest request = new EmbeddingRequest(List.of(text), null);
        EmbeddingResponse response = embeddingModel.call(request);
        
        // Convert float[] to List<Double>
        float[] embedding = response.getResults().get(0).getOutput();
        List<Double> result = new java.util.ArrayList<>();
        for (float f : embedding) {
            result.add((double) f);
        }
        return result;
    }

    /**
     * Finds similar texts by generating embeddings.
     * Note: This is a simplified implementation that just returns embeddings.
     * In a real application, you would compare against a database of stored embeddings.
     * 
     * @param text The text to find similarities for
     * @return List of Double values representing the embedding vector
     */
    public List<Double> findSimilarTexts(String text) {
        // In a real implementation, this would:
        // 1. Generate embedding for the input text
        // 2. Query a vector database for similar embeddings
        // 3. Return the most similar texts
        // For demo purposes, we just return the embedding
        return generateEmbedding(text);
    }

    /**
     * Calculates cosine similarity between two embedding vectors.
     * Cosine similarity measures the angle between vectors, returning values from -1 to 1.
     * Values closer to 1 indicate higher similarity.
     * 
     * @param embedding1 First embedding vector
     * @param embedding2 Second embedding vector
     * @return Cosine similarity score between -1 and 1
     */
    public double calculateCosineSimilarity(List<Double> embedding1, List<Double> embedding2) {
        if (embedding1.size() != embedding2.size()) {
            throw new IllegalArgumentException("Embedding vectors must have the same dimensions");
        }
        
        double dotProduct = 0.0;
        double norm1 = 0.0;
        double norm2 = 0.0;

        for (int i = 0; i < embedding1.size(); i++) {
            double val1 = embedding1.get(i);
            double val2 = embedding2.get(i);
            
            dotProduct += val1 * val2;
            norm1 += val1 * val1;
            norm2 += val2 * val2;
        }

        if (norm1 == 0.0 || norm2 == 0.0) {
            return 0.0; // Handle zero vectors
        }

        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }
} 