package clc65.quanggck.SpringAIDemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class OpenAiService {
 
    private final ChatClient client;
 
    public OpenAiService(ChatClient.Builder chatClientBuilder) {
        client = chatClientBuilder.defaultSystem("You are a helpful HR assistant.")
                .build();
    }
     
    public String jobReasons(int count, String domain, String location) {
        final String promptText = """
                Write {count} reasons why people in {location} should consider a {job} job.
                These reasons need to be short, so they fit on a poster.
                For instance, "{job} jobs are rewarding."
                """;
 
        final PromptTemplate promptTemplate = new PromptTemplate(promptText);
        promptTemplate.add("count", count);
        promptTemplate.add("job", domain);
        promptTemplate.add("location", location);
 
        return client.prompt(promptTemplate.create())
                .advisors(new SimpleLoggerAdvisor())
                .call()
                .content();
    }
}