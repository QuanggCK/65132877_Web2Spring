package thigk2.phamminhquang.models;

import jakarta.persistence.*;

@Entity
@Table(name = "sanpham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sanpham")
    private Integer idSanPham;

    @Column(name = "ten_spham", nullable = false)
    private String tenSpham;

    @Column(name = "gia", columnDefinition = "TEXT")
    private String gia;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_loai", referencedColumnName = "id_loai")
    private LoaiSanPham loaiSanPham;

    // --- CONSTRUCTORS ---
    public SanPham() {
    }

    public SanPham(Integer idSanPham, String tenSpham, String gia, String description, LoaiSanPham loaiSanPham) {
        this.idSanPham = idSanPham;
        this.tenSpham = tenSpham;
        this.gia = gia;
        this.description = description;
        this.loaiSanPham = loaiSanPham;
    }

    // --- GETTERS AND SETTERS ---

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSpham() {
        return tenSpham;
    }

    public void setTenSpham(String tenSpham) {
        this.tenSpham = tenSpham;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }
}