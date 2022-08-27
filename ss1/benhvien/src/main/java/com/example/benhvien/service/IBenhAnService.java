package com.example.benhvien.service;

import com.example.benhvien.model.BenhAn;

import java.util.List;
import java.util.Optional;

public interface IBenhAnService {
    List<BenhAn> findAllPagination(Integer page);
    List<BenhAn> findAll();
    List<BenhAn> search(String bacSi, String maBenhAn, String liDo, String dieuTri, Integer page);
    Optional<BenhAn> findById(String id);
    void save(BenhAn benhAn);
    void update(BenhAn benhAn);
    void delete(String id);
}
