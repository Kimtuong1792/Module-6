package com.example.benhvien.repository;

import com.example.benhvien.model.BenhNhan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBenhNhanRepository {
    @Query(value = "select * from benh_nhan", nativeQuery = true)
    List<BenhNhan> findAll();

    @Query(value = "select * from benh_nhan where id = :id", nativeQuery = true)
    Optional<BenhNhan> findById(String id);

    @Transactional
    @Modifying
    @Query(value = "insert into benh_nhan(name) values (:name);", nativeQuery = true)
    void save(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "update benh_nhan set name = :name where id = :id", nativeQuery = true)
    void update(@Param("name") String name, @Param("id") String id);
}
