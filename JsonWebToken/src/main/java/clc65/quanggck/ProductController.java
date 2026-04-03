package clc65.quanggck;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    @PreAuthorize("hasRole('USER')") 
    public String getAllProducts() {
        return "Danh sách sản phẩm (Đã được bảo vệ bằng JWT - Chúc mừng bạn thành công!)";
        
        // Nhớ thêm @EnableGlobalMethodSecurity(prePostEnabled = true) vào SecurityConfig
    }
}