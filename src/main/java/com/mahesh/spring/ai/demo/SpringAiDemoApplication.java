package com.mahesh.spring.ai.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring AI Demo Application
 * 
 * This application demonstrates the integration of Spring Boot with Spring AI framework
 * to build AI-powered applications. It showcases various AI capabilities including:
 * 
 * - Interactive chat conversations with OpenAI GPT models
 * - Template-based content generation
 * - Text embedding generation for similarity analysis
 * - RESTful API endpoints for AI functionality
 * 
 * The application uses OpenAI's GPT models for chat and text-embedding-ada-002 for embeddings.
 * 
 * To run this application, you need:
 * 1. An OpenAI API key set as environment variable OPENAI_API_KEY
 * 2. Java 17 or higher
 * 3. Maven for building and running
 * 
 * @author Mahesh
 * @version 1.0
 */
@SpringBootApplication
public class SpringAiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiDemoApplication.class, args);
	}

}
