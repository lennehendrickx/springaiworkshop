package com.lennehendrickx.springai.prompt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    private final ChatClient chatClient;

    public ArticleController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/posts/new")
    public String newPost(@RequestParam(value = "topic", defaultValue = "JDK Virtual Threads") String topic) {
        return chatClient.
                prompt()
                .system("Create a blog post about the given topic.")
                .user(u -> u.text("Write a detailed blog post about {topic}.").param("topic", topic))
                .call()
                .content();
    }

}
