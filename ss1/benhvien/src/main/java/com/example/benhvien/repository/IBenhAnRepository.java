package com.example.benhvien.repository;

import com.example.benhvien.model.BenhAn;
import com.example.benhvien.model.BenhNhan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface IBenhAnRepository {
    @Query(value = "select * from benh_an limit :page, 5", nativeQuery = true)
    List<BenhAn> findAllPagination(@Param("page") Integer page);

    @Query(value = "select * from benh_an", nativeQuery = true)
    List<BenhAn> findAll();

    @Query(value = "select benh_an.* from benh_an join benh_nhan on benh_an.ma_benh_nhan = benh_nhan.id where benh_an.bac_si like %:bac_si% and benh_nhan.name like %:name% and benh_an.li_do like %:li_do% and benh_an.dieu_tri like %:dieu_tri% limit :page, 5", nativeQuery = true)
    List<BenhAn> search(@Param("bac_si") String bac_si, @Param("name") String name, @Param("li_do") String li_do, @Param("dieu_tri") String dieu_tri, @Param("page") Integer page);

    @Query(value = "select * from benh_an where id = :id", nativeQuery = true)
    Optional<BenhAn> findById(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "insert into benh_an(ma_benh_nhan, ngay_bat_dau, ngay_ket_thuc, li_do, dieu_tri, bac_si) values (:ma_benh_nhan, :ngay_bat_dau, :ngay_ket_thuc, :li_do, :dieu_tri, :bac_si );", nativeQuery = true)
    void save(@Param("ma_benh_nhan") BenhNhan ma_benh_nhan, @Param("dayIn") String ngay_bat_dau, @Param("dayOut") String ngay_ket_thuc, @Param("li_do") String li_do, @Param("dieu_tri") String dieu_tri, @Param("bac_si") String bac_si);

    @Transactional
    @Modifying
    @Query(value = "update benh_an set ngay_bat_dau = :ngay_bat_dau, ngay_ket_thuc = :ngay_ket_thuc, li_do = :li_do, dieu_tri = :dieu_tri, bac_si = :bac_si where id = :id", nativeQuery = true)
    void update(@Param("ngay_bat_dau") String ngay_bat_dau, @Param("ngay_ket_thuc") String ngay_ket_thuc, @Param("li_do") String li_do, @Param("dieu_tri") String dieu_tri, @Param("bac_si") String bac_si, @Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "delete from benh_an where id = :id", nativeQuery = true)
    void delete(@Param("id") String id);
}
