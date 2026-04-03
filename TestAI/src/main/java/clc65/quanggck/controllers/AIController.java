package clc65.quanggck.controllers;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Dùng @Controller để trả về giao diện HTML
public class AIController {

    private final ChatModel chatModel;

    public AIController(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/")
    public String showIndexPage() {
        return "index"; 
    }

    @PostMapping("/chat")
    public String chatWithGroq(
    		@RequestParam(name = "prompt", defaultValue = "1 + 1 = mấy") String prompt,
            Model model) {
        
        long startTime = System.currentTimeMillis();
        
        String aiResponse = chatModel.call(prompt);
        
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        // Đẩy dữ liệu sang file index.html
        model.addAttribute("userPrompt", prompt);
        model.addAttribute("aiResponse", aiResponse);
        model.addAttribute("timeTaken", timeTaken);

        return "index";
    }
}