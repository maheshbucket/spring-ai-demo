package com.mahesh.spring.ai.demo.service;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class AiService {

    private final ChatClient chatClient;
    private final EmbeddingClient embeddingClient;

    @Autowired
    public AiService(ChatClient chatClient, EmbeddingClient embeddingClient) {
        this.chatClient = chatClient;
        this.embeddingClient = embeddingClient;
    }

    public ChatResponse chat(String message) {
        Message systemMessage = new SystemMessage("""
            You are a helpful AI assistant with expertise in programming and technology.
            Provide clear, concise, and accurate responses.
            Include code examples when relevant.
            """);
        
        Message userMessage = new UserMessage(message);
        Prompt prompt = new Prompt(Arrays.asList(systemMessage, userMessage));
        return chatClient.call(prompt);
    }

    public ChatResponse generateWithTemplate(String topic, String complexity) {
        String templateString = """
            Create a {complexity} explanation about {topic}.
            Include key points and examples where relevant.
            """;
        
        PromptTemplate template = new PromptTemplate(templateString);
        Prompt prompt = template.create(Map.of(
            "topic", topic,
            "complexity", complexity
        ));
        
        return chatClient.call(prompt);
    }

    public List<Double> generateEmbedding(String text) {
        return embeddingClient.embed(text);
    }

    public List<Double> findSimilarTexts(String text) {
        return embeddingClient.embed(text);
    }

    public double calculateCosineSimilarity(List<Double> embedding1, List<Double> embedding2) {
        double dotProduct = 0.0;
        double norm1 = 0.0;
        double norm2 = 0.0;

        for (int i = 0; i < embedding1.size(); i++) {
            dotProduct += embedding1.get(i) * embedding2.get(i);
            norm1 += embedding1.get(i) * embedding1.get(i);
            norm2 += embedding2.get(i) * embedding2.get(i);
        }

        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }
} 