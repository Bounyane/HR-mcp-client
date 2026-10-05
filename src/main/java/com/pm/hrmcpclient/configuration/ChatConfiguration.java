package com.pm.hrmcpclient.configuration;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfiguration {

    @Bean
    public ChatClient chatClient(
            ChatClient.Builder chatClientBuilder,
            SyncMcpToolCallbackProvider mcpTools
    ) {
        return chatClientBuilder
                .defaultSystem(
                        """ 
                                You are an HR leave management assistant.
                                Use the available MCP tools whenever the user asks for current employee leave information or wants to perform a leave-related action.
                                Never invent or assume employee information, leave balances, leave request details, or tool results.
                                If a required value is missing, ask the user for it before calling a tool.
                                Only perform actions when the user explicitly requests them.
                                After receiving a tool result, explain the result clearly, accurately, and concisely.
                                If a tool returns an error or the requested operation cannot be completed, clearly explain the issue to the user instead of making up a result.
                                """)
                .defaultTools(mcpTools)
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }
}
