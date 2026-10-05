package com.pm.hrmcpclient.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToolLoggingConfiguration {
    private static final Logger log = LoggerFactory.getLogger(ToolLoggingConfiguration.class);

    @Bean
    public ApplicationRunner logDiscoveredTools (
            SyncMcpToolCallbackProvider toolCallbackProvider
    ) {

        return args -> {
            log.info("Discovered MCP tools:");

            for (var toolCallback : toolCallbackProvider.getToolCallbacks() ) {
                var definition = toolCallback.getToolDefinition();

                log.info("- {}: {}", definition.name(), definition.description());
            }
        };
    }
}
