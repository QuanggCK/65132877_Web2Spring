package clc65.quanggck;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private int jwtExpirationMs;

    // Hàm hỗ trợ: Chuyển đổi chuỗi Secret thành đối tượng Key của thuật toán mã hóa
    private Key key() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    // 1. HÀM TẠO TOKEN (Dành cho Controller lúc User đăng nhập thành công)
    public String generateJwtToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    // 2. HÀM LẤY USERNAME TỪ TOKEN (Giải quyết lỗi dòng 41)
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // 3. HÀM KIỂM TRA TOKEN CÓ HỢP LỆ KHÔNG (Giải quyết lỗi dòng 47)
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(authToken);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            System.out.println("Lỗi chữ ký JWT không hợp lệ: " + e.getMessage());
        } catch (ExpiredJwtException e) {
            System.out.println("JWT token đã hết hạn: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("JWT token không được hỗ trợ: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Chuỗi JWT bị rỗng: " + e.getMessage());
        }
        return false;
    }
}