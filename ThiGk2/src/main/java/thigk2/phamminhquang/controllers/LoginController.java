package thigk2.phamminhquang.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thigk2.phamminhquang.models.NguoiDung;
import thigk2.phamminhquang.services.NguoiDungService;

@Controller
public class LoginController {

    @Autowired
    private NguoiDungService nguoiDungService;

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Trả về file login.html
    }

    @PostMapping("/handle-login")
    public String handleLogin(@RequestParam("user") String user, 
                              @RequestParam("pass") String pass, 
                              HttpSession session, 
                              Model model) {
        
        NguoiDung nDuoiDung = nguoiDungService.checkLogin(user, pass);
        
        if (nDuoiDung != null) {
            // Đăng nhập đúng: Lưu thông tin vào Session và vào Admin
            session.setAttribute("admin", nDuoiDung);
            return "redirect:/admin/tintuc";
        } else {
            // Đăng nhập sai: Hiện thông báo lỗi
            model.addAttribute("msg", "Tài khoản hoặc mật khẩu không chính xác!");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Xóa sạch session
        return "redirect:/login";
    }
}