package thigk2.phamminhquang.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "loaisanpham") 
public class LoaiSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loai")
    private Integer idLoai;

    @Column(name = "ten_loai", nullable = false)
    private String tenLoai;

    @OneToMany(mappedBy = "loaiSanPham")
    private List<SanPham> danhSachSanPham;

    public LoaiSanPham() {
    }

    public LoaiSanPham(Integer idLoai, String tenLoai) {
        this.idLoai = idLoai;
        this.tenLoai = tenLoai;
    }

    public Integer getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(Integer idLoai) {
        this.idLoai = idLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public List<SanPham> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void setDanhSachSanPham(List<SanPham> danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }
}