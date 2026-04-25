package com.r2g.springai.openai.controllers;

import com.r2g.springai.openai.services.AiService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AiController {

    private final AiService aiService;
    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(defaultValue = "Ronald") String name) {
        return aiService.greeting(name);
    }
    @GetMapping("/chat")
    public String chat(@RequestParam String prompt) {
        return aiService.chat(prompt);
    }
    @PostMapping("chat-expert")
    public String chatExpeert(@RequestBody String prompt) {
        return aiService.chatExpetSpring(prompt);
    }
}
