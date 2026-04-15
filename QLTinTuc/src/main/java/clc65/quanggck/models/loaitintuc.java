package clc65.quanggck.models;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "loaitintuc")
public class loaitintuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loai")
    private Integer idLoai;

    @Column(name = "ten_loai", length = 255)
    private String tenLoai;

    // Tham chiếu đến class tintuc (viết thường)
    @JsonIgnore // DÒNG NÀY CỰC KỲ QUAN TRỌNG CHO API
    @OneToMany(mappedBy = "loaiTinTuc", cascade = CascadeType.ALL)
    private List<tintuc> danhSachTinTuc;
    
    public Integer getIdLoai() { return idLoai; }
    public void setIdLoai(Integer idLoai) { this.idLoai = idLoai; }

    public String getTenLoai() { return tenLoai; }
    public void setTenLoai(String tenLoai) { this.tenLoai = tenLoai; }

    public List<tintuc> getDanhSachTinTuc() { return danhSachTinTuc; }
    public void setDanhSachTinTuc(List<tintuc> danhSachTinTuc) { this.danhSachTinTuc = danhSachTinTuc; }
}