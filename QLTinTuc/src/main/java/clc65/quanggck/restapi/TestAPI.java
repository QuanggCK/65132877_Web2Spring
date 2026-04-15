package clc65.quanggck.restapi;

import clc65.quanggck.models.tintuc;
import clc65.quanggck.service.TinTucService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tintuc") // Đường dẫn gốc cho API này
@CrossOrigin(origins = "*") // Mở CORS nếu bạn dùng frontend riêng (React/Vue) gọi vào
public class TestAPI {

    private final TinTucService tinTucService;

    public  TestAPI(TinTucService tinTucService) {
        this.tinTucService = tinTucService;
    }

    // 1. Lấy danh sách tất cả tin tức (GET /api/tintuc)
    @GetMapping
    public ResponseEntity<List<tintuc>> getAll() {
        List<tintuc> list = tinTucService.getAllTinTuc();
        return ResponseEntity.ok(list);
    }

    // 2. Lấy chi tiết 1 bài tin theo ID (GET /api/tintuc/{id})
    @GetMapping("/{id}")
    public ResponseEntity<tintuc> getById(@PathVariable Integer id) {
        tintuc tin = tinTucService.getTinTucById(id);
        if (tin == null) {
            return ResponseEntity.notFound().build(); // Trả về lỗi 404 nếu không thấy
        }
        return ResponseEntity.ok(tin);
    }

    // 3. Thêm mới tin tức (POST /api/tintuc)
    // Client (Postman/React) sẽ gửi dữ liệu dạng JSON lên thông qua @RequestBody
    @PostMapping
    public ResponseEntity<tintuc> createTinTuc(@RequestBody tintuc tin) {
        tintuc savedTin = tinTucService.saveTinTuc(tin);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTin); 
    }

    // 4. Cập nhật tin tức (PUT /api/tintuc/{id})
    @PutMapping("/{id}")
    public ResponseEntity<tintuc> updateTinTuc(@PathVariable Integer id, @RequestBody tintuc tinDetails) {
        tintuc existingTin = tinTucService.getTinTucById(id);
        if (existingTin == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Cập nhật các trường dữ liệu
        existingTin.setTitle(tinDetails.getTitle());
        existingTin.setContent(tinDetails.getContent());
        existingTin.setImage(tinDetails.getImage());
        existingTin.setLoaiTinTuc(tinDetails.getLoaiTinTuc());
        // Giữ nguyên ngày đăng cũ hoặc cập nhật tùy logic của bạn
        
        tintuc updatedTin = tinTucService.saveTinTuc(existingTin);
        return ResponseEntity.ok(updatedTin);
    }

    // 5. Xóa tin tức (DELETE /api/tintuc/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTinTuc(@PathVariable Integer id) {
        tintuc existingTin = tinTucService.getTinTucById(id);
        if (existingTin == null) {
            return ResponseEntity.notFound().build();
        }
        tinTucService.deleteTinTuc(id);
        return ResponseEntity.noContent().build(); 
    }
}