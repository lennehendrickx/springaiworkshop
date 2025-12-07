package com.lennehendrickx.springai.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    @Autowired
    public ChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ai/generate")
    public String generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return this.chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }

    @GetMapping("/ai/generateStream")
    public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return this.chatClient
                .prompt()
                .user(message)
                .stream()
                .chatResponse();
    }

}
