package com.r2g.springai.openai.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiServiceImpl implements AiService {

    private final ChatClient chatClient;
    public AiServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }
    @Override
    public String greeting(String name) {
        String directix="Responde siempre en ingles, en una sola LiNEA";
        String stringPromt="Dime hola mundo CON mi nombre: %s ".formatted(name);
        return this.chatClient.prompt()
                .system(directix)
                .user(stringPromt)
                .call()
                .content();
    }

    @Override
    public String chat(String promt) {
        return chatClient.prompt()
                .user(promt)
                .call()
                .content();
    }

    @Override
    public String chatExpetSpring(String prompt) {
        String directivaxExp="Ere un experto en Java y Spring boot, Responde de forma clara y simple.";
        String stringPromtExp=" : %s ".formatted(prompt);
        return this.chatClient.prompt()
                .system(directivaxExp)
                .user(stringPromtExp)
                .call()
                .content();
    }
}
