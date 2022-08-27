package com.example.benhvien.dto;

import com.example.benhvien.model.BenhNhan;

import javax.validation.constraints.NotBlank;

public class BenhAnDto {

    private String id;
    @NotBlank(message = "Không được để trống")
    private String ngayBatDau;
    @NotBlank(message = "Không được để trống")
    private String ngayKetThuc;
    @NotBlank(message = "Không được để trống")
    private String liDo;
    @NotBlank(message = "Không được để trống")
    private String dieuTri;
    @NotBlank(message = "Không được để trống")
    private String bacSi;
    @NotBlank(message = "Không được để trống")
    private BenhNhan benhNhan;

    public BenhAnDto() {
    }

    public BenhAnDto(String id, String ngayBatDau,
                     String ngayKetThuc, String liDo,
                     String dieuTri, String bacSi, BenhNhan benhNhan) {
        this.id = id;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.liDo = liDo;
        this.dieuTri = dieuTri;
        this.bacSi = bacSi;
        this.benhNhan = benhNhan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public BenhNhan getBenhNhan() {
        return benhNhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhNhan = benhNhan;
    }
}
