# HR MCP Client

A Spring Boot application that uses **Spring AI** and the **Model Context Protocol (MCP)** to connect an LLM with HR leave management tools.

The client connects to the **HR MCP Server**, discovers its available tools, and allows the AI model to use them when handling employee leave requests.

## Architecture

```text
User
 ↓
HR MCP Client
 ↓
LLM + Spring AI
 ↓
MCP
 ↓
HR MCP Server
 ↓
Leave Service
```

## Features

* Spring Boot
* Spring AI
* MCP Client
* LLM tool calling
* Employee leave management
* JSON responses

## Related Repository

👉 [HR MCP Server](https://github.com/Bounyane/HR-mcp-server)

## Tech Stack

* Java
* Spring Boot
* Spring AI
* Model Context Protocol (MCP)
* OpenRouter / OpenAI-compatible LLM
