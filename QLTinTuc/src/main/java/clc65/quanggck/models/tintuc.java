package clc65.quanggck.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tintuc")
public class tintuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tin")
    private Integer idTin;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "content", columnDefinition = "LONGTEXT")
    private String content;

    @Column(name = "image", length = 255)
    private String image;

    @Column(name = "ngay_dang")
    private LocalDate ngayDang;

    // Tham chiếu đến class loaitintuc (viết thường)
    @ManyToOne
    @JoinColumn(name = "id_loai") 
    private loaitintuc loaiTinTuc;
    
    public Integer getIdTin() { return idTin; }
    public void setIdTin(Integer idTin) { this.idTin = idTin; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public LocalDate getNgayDang() { return ngayDang; }
    public void setNgayDang(LocalDate ngayDang) { this.ngayDang = ngayDang; }

    public loaitintuc getLoaiTinTuc() { return loaiTinTuc; }
    public void setLoaiTinTuc(loaitintuc loaiTinTuc) { this.loaiTinTuc = loaiTinTuc; }
}