package thigk2.phamminhquang.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tintuc")
public class TinTuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tin") 
    private Integer id_tin;

    @Column(name = "ten_tin", nullable = false)
    private String ten_tin;

    @Column(name = "thong_tin") 
    private String thong_tin;

    @ManyToOne
    @JoinColumn(name = "id_loai") 
    private LoaiTinTuc loaiTinTuc;


    public TinTuc() {}

    public Integer getId_tin() {
        return id_tin;
    }

    public void setId_tin(Integer id_tin) {
        this.id_tin = id_tin;
    }

    public String getTen_tin() {
        return ten_tin;
    }

    public void setTen_tin(String ten_tin) {
        this.ten_tin = ten_tin;
    }

    public String getThong_tin() {
        return thong_tin;
    }

    public void setThong_tin(String thong_tin) {
        this.thong_tin = thong_tin;
    }

    public LoaiTinTuc getLoaiTinTuc() {
        return loaiTinTuc;
    }

    public void setLoaiTinTuc(LoaiTinTuc loaiTinTuc) {
        this.loaiTinTuc = loaiTinTuc;
    }
}