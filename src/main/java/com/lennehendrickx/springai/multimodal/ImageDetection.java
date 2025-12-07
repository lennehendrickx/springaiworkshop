package com.lennehendrickx.springai.multimodal;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.content.Media;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.ai.content.Media.Format.IMAGE_JPEG;

@RestController
public class ImageDetection {

    private final ChatClient chatClient;

    @Value("classpath:image/pexels-pixabay-326055.jpg")
    Resource resource;

    public ImageDetection(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("image-to-text")
    public String imageToText() {
        return chatClient
                .prompt()
                .user(u -> u
                        .text("Describe the content of the image.")
                        .media(IMAGE_JPEG, resource))
                .call()
                .content();
    }
}
