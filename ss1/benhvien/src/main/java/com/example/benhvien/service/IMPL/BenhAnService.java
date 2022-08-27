package com.example.benhvien.service.IMPL;

import com.example.benhvien.model.BenhAn;
import com.example.benhvien.repository.IBenhAnRepository;
import com.example.benhvien.service.IBenhAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BenhAnService implements IBenhAnService {
    @Autowired
    IBenhAnRepository benhAnRepository;

    @Override
    public List<BenhAn> findAllPagination(Integer page) {
        return benhAnRepository.findAllPagination(page);
    }

    @Override
    public List<BenhAn> findAll() {
        return benhAnRepository.findAll();
    }

    @Override
    public List<BenhAn> search(String bacSi, String maBenhAn, String liDo, String dieuTri, Integer page) {
        return benhAnRepository.search(bacSi, maBenhAn, liDo, dieuTri, page);
    }

    @Override
    public Optional<BenhAn> findById(String id) {
        return benhAnRepository.findById(id);
    }

    @Override
    public void save(BenhAn benhAn) {
        benhAnRepository.save(benhAn.getMaBenhNhan(), benhAn.getNgayBatDau(),
                benhAn.getNgayKetThuc(), benhAn.getLiDo(), benhAn.getDieuTri(), benhAn.getBacSi());
    }

    @Override
    public void update(BenhAn benhAn) {
        benhAnRepository.update(benhAn.getNgayBatDau(), benhAn.getNgayKetThuc(),
                benhAn.getLiDo(), benhAn.getDieuTri(), benhAn.getBacSi(), benhAn.getId());
    }

    @Override
    public void delete(String id) {
        benhAnRepository.delete(id);
    }
}
