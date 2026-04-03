package clc65.quanggck.controllers;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIController {

    private final ChatModel chatModel;

    // Tiêm ChatModel vào (Spring Boot sẽ tự động cấu hình dựa trên file properties)
    public AIController(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/chat")
    public String chatWithGroq(@RequestParam(defaultValue = "Hãy kể 3 video trên kênh QuanggCK") String prompt) {
        
        long startTime = System.currentTimeMillis(); 
        

        String response = chatModel.call(prompt);
        
        long endTime = System.currentTimeMillis(); 
        
        return "<h3> Groq trả lời (Mất " + (endTime - startTime) + " ms):</h3>" +
               "<p>" + response + "</p>";
    }
}