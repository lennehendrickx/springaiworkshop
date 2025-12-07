package com.lennehendrickx.springai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class SpringAiApplication {

	static void main(String[] args) {
		SpringApplication.run(SpringAiApplication.class, args);
	}

    @Bean
    public ChatClient openAiChatClient(OpenAiChatModel openAiChatModel) {
        return ChatClient.create(openAiChatModel);
    }

    @Bean
    @Primary
    public ChatClient ollamaChatClient(OllamaChatModel ollamaChatModel) {
        return ChatClient.create(ollamaChatModel);
    }

}
