package thigk2.phamminhquang.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "loaitintuc")
public class LoaiTinTuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loai") 
    private Integer idLoaiTinTuc;

    @Column(name = "ten_loai", nullable = false)
    private String tenLoai;

    @JsonIgnore 
    @OneToMany(mappedBy = "loaiTinTuc", cascade = CascadeType.ALL)
    private List<TinTuc> danhSachTinTuc;

    // --- Constructors ---
    public LoaiTinTuc() {}

    // --- Getter and Setter ---
    public Integer getIdLoaiTinTuc() { 
        return idLoaiTinTuc; 
    }
    
    public void setIdLoaiTinTuc(Integer idLoaiTinTuc) { 
        this.idLoaiTinTuc = idLoaiTinTuc; 
    }

    public String getTenLoai() { 
        return tenLoai; 
    }
    
    public void setTenLoai(String tenLoai) { 
        this.tenLoai = tenLoai; 
    }

    public List<TinTuc> getDanhSachTinTuc() { 
        return danhSachTinTuc; 
    }
    
    public void setDanhSachTinTuc(List<TinTuc> danhSachTinTuc) { 
        this.danhSachTinTuc = danhSachTinTuc; 
    }
}