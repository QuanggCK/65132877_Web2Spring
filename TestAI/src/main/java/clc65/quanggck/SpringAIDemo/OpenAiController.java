package clc65.quanggck.SpringAIDemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAiController {

	@GetMapping("/job-reasons")
    public ResponseEntity<String> jobReasons(@RequestParam(value = "count", required = false, defaultValue = "3") int count,
                                             @RequestParam("job") String job,
                                             @RequestParam("location") String location) {
        return ResponseEntity.ok().build();
    }
}