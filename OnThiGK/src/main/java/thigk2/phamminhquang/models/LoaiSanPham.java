package thigk2.phamminhquang.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "loaisanpham") 
public class LoaiSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loai") 
    private Integer id_loai;

    @Column(name = "ten_loai", nullable = false) 
    private String ten_loai;

    @OneToMany(mappedBy = "loaiSanPham", cascade = CascadeType.ALL)
    private List<SanPham> danhSachSanPham;

    // --- CONSTRUCTORS ---
    public LoaiSanPham() {
    }

    public LoaiSanPham(Integer id_loai, String ten_loai) {
        this.id_loai = id_loai;
        this.ten_loai = ten_loai;
    }

    // --- GETTERS AND SETTERS ---

    public Integer getId_loai() {
        return id_loai;
    }

    public void setId_loai(Integer id_loai) {
        this.id_loai = id_loai;
    }

    public String getTen_loai() {
        return ten_loai;
    }

    public void setTen_loai(String ten_loai) {
        this.ten_loai = ten_loai;
    }

    public List<SanPham> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void setDanhSachSanPham(List<SanPham> danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }
}