package com.mahesh.spring.ai.demo.controller;

import com.mahesh.spring.ai.demo.model.ChatMessage;
import com.mahesh.spring.ai.demo.model.TemplateRequest;
import com.mahesh.spring.ai.demo.service.AiService;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final AiService aiService;

    @Autowired
    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody ChatMessage message) {
        ChatResponse response = aiService.chat(message.getContent());
        return ResponseEntity.ok(response.getResult().getOutput().getContent());
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateFromTemplate(@RequestBody TemplateRequest request) {
        ChatResponse response = aiService.generateWithTemplate(
            request.getTopic(),
            request.getComplexity()
        );
        return ResponseEntity.ok(response.getResult().getOutput().getContent());
    }

    @PostMapping("/embed")
    public ResponseEntity<List<Double>> embed(@RequestBody String text) {
        return ResponseEntity.ok(aiService.generateEmbedding(text));
    }

    @PostMapping("/similar")
    public ResponseEntity<List<Double>> findSimilar(@RequestBody String text) {
        return ResponseEntity.ok(aiService.findSimilarTexts(text));
    }
} 