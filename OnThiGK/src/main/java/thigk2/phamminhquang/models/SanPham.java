package thigk2.phamminhquang.models;
import jakarta.persistence.*;

@Entity
@Table(name = "sanpham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loaisp") 
    private Integer idLoaiSp;

    @Column(name = "tenloaisp", nullable = false) 
    private String tenLoaiSp;

    @Column(name = "description", length = 1000) 
    private String description;

    @Column(name = "img") 
    private String img;

    @ManyToOne
    @JoinColumn(name = "id_loai") 
    private LoaiSanPham loaiSanPham;

    public SanPham() {
    }

    public Integer getIdLoaiSp() {
        return idLoaiSp;
    }

    public void setIdLoaiSp(Integer idLoaiSp) {
        this.idLoaiSp = idLoaiSp;
    }

    public String getTenLoaiSp() {
        return tenLoaiSp;
    }

    public void setTenLoaiSp(String tenLoaiSp) {
        this.tenLoaiSp = tenLoaiSp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }
}