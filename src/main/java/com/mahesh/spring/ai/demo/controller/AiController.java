package com.mahesh.spring.ai.demo.controller;

import com.mahesh.spring.ai.demo.model.ChatMessage;
import com.mahesh.spring.ai.demo.model.TemplateRequest;
import com.mahesh.spring.ai.demo.service.AiService;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller that exposes AI functionality through HTTP endpoints.
 * 
 * This controller provides the following endpoints:
 * - POST /api/ai/chat - Interactive chat with AI
 * - POST /api/ai/generate - Template-based content generation
 * - POST /api/ai/embed - Generate text embeddings
 * - POST /api/ai/similar - Find similar texts (demo implementation)
 * 
 * All endpoints accept JSON payloads and return JSON responses.
 */
@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final AiService aiService;

    @Autowired
    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    /**
     * Interactive chat endpoint that sends user messages to the AI.
     * 
     * @param message ChatMessage containing the user's input
     * @return The AI's response as plain text
     */
    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody ChatMessage message) {
        ChatResponse response = aiService.chat(message.getContent());
        return ResponseEntity.ok(response.getResult().getOutput().getText());
    }

    /**
     * Template-based content generation endpoint.
     * Generates explanations about topics with specified complexity levels.
     * 
     * @param request TemplateRequest containing topic and complexity
     * @return Generated content as plain text
     */
    @PostMapping("/generate")
    public ResponseEntity<String> generateFromTemplate(@RequestBody TemplateRequest request) {
        ChatResponse response = aiService.generateWithTemplate(
            request.getTopic(),
            request.getComplexity()
        );
        return ResponseEntity.ok(response.getResult().getOutput().getText());
    }

    /**
     * Text embedding generation endpoint.
     * Converts text into numerical vector representations for similarity analysis.
     * 
     * @param text The text to generate embeddings for
     * @return List of Double values representing the text embedding
     */
    @PostMapping("/embed")
    public ResponseEntity<List<Double>> embed(@RequestBody String text) {
        return ResponseEntity.ok(aiService.generateEmbedding(text));
    }

    /**
     * Similarity search endpoint (simplified demo implementation).
     * In a production system, this would search through stored embeddings.
     * 
     * @param text The text to find similar content for
     * @return List of Double values representing the embedding (demo)
     */
    @PostMapping("/similar")
    public ResponseEntity<List<Double>> findSimilar(@RequestBody String text) {
        return ResponseEntity.ok(aiService.findSimilarTexts(text));
    }
} 