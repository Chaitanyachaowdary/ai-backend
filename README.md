# AI Backend – Spring Boot Application

This project is a Spring Boot backend application that demonstrates **text summarization** using clean architecture and Spring Boot best practices.

The application exposes REST APIs and implements **extractive text summarization** using a mock AI approach.  
The AI logic is designed to be **pluggable**, allowing real AI services (such as OpenAI) to be integrated later without changing core business logic.

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Jakarta Bean Validation
- Maven
- Embedded Tomcat

---

## Architecture Overview

The application follows a layered architecture:

controller -> REST API endpoints
service -> Business logic
ai -> AI / summarization logic
dto -> Request & Response objects
exception -> Global exception handling


### Design Highlights
- Controllers handle only HTTP-related logic
- Services orchestrate business logic
- AI logic is abstracted behind an interface
- DTOs define clean API contracts
- Exception handling is centralized

---

## Text Summarization

The application provides **extractive text summarization**.

### How Summarization Works
- Input text is split into **sentences**
- Common stop words are ignored
- Keywords are counted to determine sentence importance
- Sentences are scored based on keyword frequency
- The most relevant sentences are selected based on a **percentage value**

This approach summarizes text by **preserving meaning**, not by truncating characters or words.

---

## Percentage-Based Logic

- The `percentage` value controls how much of the content is summarized
- Percentage is applied to the **number of sentences**

### Examples
- 4 sentences with `40%` → 1 most relevant sentence
- 4 sentences with `50%` → 2 most relevant sentences
- A minimum of **1 sentence** is always returned

Sentence selection is deterministic and explainable.

---

## API Endpoints

### 1. Health Check

**GET** `/health`

Response:

Backend is running


---

### 2. Text Summarization API

**POST** `/api/v1/ai/summarize`

#### Request Body
```json
{
  "text": "Spring Boot simplifies backend development. It provides auto configuration. Developers can build applications faster. It is widely used in microservices.",
  "percentage": 50
}

Response
{
  "summary": "Spring Boot simplifies backend development. Developers can build applications faster.",
  "originalLength": 153,
  "summaryLength": 10
}


Validation & Exception Handling

Input validation is implemented using Jakarta Bean Validation:

@NotBlank

@NotNull

@Min, @Max

Global exception handling is implemented using @RestControllerAdvice

Invalid requests return consistent 400 Bad Request responses

Example Error Response

{
  "timestamp": "2026-01-05T16:32:08.5560846",
  "status": 400,
  "error": "Validation Failed",
  "message": "percentage is required"
}


AI Service Used

A Mock AI implementation is used for summarization

The mock performs extractive summarization using rule-based logic

AI logic is abstracted behind an interface (AiClient)

Real AI services (such as OpenAI) can be integrated easily without changing controllers or services

Why Mock AI

A mock AI implementation is used to ensure:

Reliable and deterministic behavior during evaluation

No dependency on external APIs or network availability

Easy testing and explainability

This design allows seamless replacement with real AI providers in the future.

Running the Application
Prerequisites

Java 21 or above

Maven (Maven Wrapper included)

Run Command

mvnw.cmd spring-boot:run


The application runs on:
http://localhost:8080
