package clc65.quanggck;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(ModelMap m) {
        // Obtain the SecurityContext
        SecurityContext context = SecurityContextHolder.getContext();
        // Obtain the Authentication object from the context
        Authentication authentication = context.getAuthentication();
//      Principal u = authentication;
        m.addAttribute("au", authentication.getName() );
        return "home";
    }

    @GetMapping("/chao")
    public String chao(Authentication authentication, ModelMap m) {
        m.addAttribute("au", authentication.getName() );
        return "home";
    }

    @GetMapping("/home")
    public String home1(Authentication authentication, ModelMap m) {
        if (authentication != null) {
            m.addAttribute("au", authentication.getName());
        }
        return "home";
    }
}