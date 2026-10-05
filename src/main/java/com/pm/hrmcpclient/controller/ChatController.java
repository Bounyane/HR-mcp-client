package com.pm.hrmcpclient.controller;

import com.pm.hrmcpclient.dto.ChatRequest;
import com.pm.hrmcpclient.dto.ChatResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/chat")
public class ChatController {
    private final ChatClient chatClient;

    public ChatController(ChatClient _chatClient){
        this.chatClient = _chatClient;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request){

        String answer =chatClient.prompt().user(request.message()).call().content();
        return new ChatResponse(answer);
    }

}
