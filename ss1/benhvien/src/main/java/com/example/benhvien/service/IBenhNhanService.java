package com.example.benhvien.service;

import com.example.benhvien.model.BenhNhan;

import java.util.List;
import java.util.Optional;

public interface IBenhNhanService {
    List<BenhNhan> findAll();
    Optional<BenhNhan> findById(String id);
    void save(BenhNhan benhNhan);

    void update(BenhNhan benhNhan);
}
