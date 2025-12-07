package com.lennehendrickx.springai.output;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacationPlan {

    private final ChatClient chatClient;

    public VacationPlan(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @RequestMapping("/vacation/unstructured")
    public String unstructured() {
        return chatClient
                .prompt()
                .user("Plan a vacation to Japan for 10 days. Make a list of things to visit.")
                .call()
                .content();
    }

    @RequestMapping("/vacation/structured")
    public Itinerary structured() {
        return chatClient
                .prompt()
                .user("Plan a vacation to Japan for 10 days. Make a list of things to visit.")
                .call()
                .entity(Itinerary.class);
    }

}
