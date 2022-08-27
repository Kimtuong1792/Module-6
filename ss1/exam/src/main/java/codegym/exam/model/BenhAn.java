package codegym.exam.model;

import javax.persistence.*;
@Entity
public class BenhAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private BenhNhan benhNhan;
    private String ngayBatDau;
    private String ngayKetThuc;
    private String liDo;
    private String dieuTri;
    private String bacSi;

    public BenhAn() {
    }

    public BenhAn(String id, BenhNhan benhNhan,
                  String ngayBatDau, String ngayKetThuc,
                  String liDo, String dieuTri, String bacSi) {
        this.id = id;
        this.benhNhan = benhNhan;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.liDo = liDo;
        this.dieuTri = dieuTri;
        this.bacSi = bacSi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BenhNhan getBenhNhan() {
        return benhNhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhNhan = benhNhan;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getLiDo() {
        return liDo;
    }

    public void setLiDo(String liDo) {
        this.liDo = liDo;
    }

    public String getDieuTri() {
        return dieuTri;
    }

    public void setDieuTri(String dieuTri) {
        this.dieuTri = dieuTri;
    }

    public String getBacSi() {
        return bacSi;
    }

    public void setBacSi(String bacSi) {
        this.bacSi = bacSi;
    }
}
