package com.mahesh.spring.ai.demo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Model class representing a chat message from the user.
 * 
 * Contains the message content that will be sent to the AI model.
 * The 'role' field can be used to distinguish between different types of messages
 * (e.g., "user", "assistant", "system") though currently only user messages are handled.
 */
@Getter
@Setter
public class ChatMessage {
    /**
     * The role of the message sender (e.g., "user", "assistant")
     */
    private String role;
    
    /**
     * The actual content/text of the message
     */
    private String content;
} 