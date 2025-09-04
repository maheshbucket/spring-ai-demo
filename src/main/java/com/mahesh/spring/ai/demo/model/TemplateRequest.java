package com.mahesh.spring.ai.demo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Model class for template-based content generation requests.
 * 
 * This class contains parameters for generating structured content:
 * - topic: What subject to explain or discuss
 * - complexity: The level of detail (e.g., "simple", "detailed", "technical")
 */
@Getter
@Setter
public class TemplateRequest {
    /**
     * The topic or subject to generate content about
     */
    private String topic;
    
    /**
     * The complexity level for the generated content
     * Examples: "simple", "detailed", "technical", "beginner-friendly"
     */
    private String complexity;
} 