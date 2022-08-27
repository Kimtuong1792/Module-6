package com.example.benhvien.service.IMPL;

import com.example.benhvien.model.BenhNhan;
import com.example.benhvien.repository.IBenhNhanRepository;
import com.example.benhvien.service.IBenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BenhNhanService implements IBenhNhanService {
    @Autowired
    IBenhNhanRepository benhNhanRepository;

    @Override
    public List<BenhNhan> findAll() {
        return benhNhanRepository.findAll();
    }

    @Override
    public Optional<BenhNhan> findById(String id) {
        return benhNhanRepository.findById(id);
    }

    @Override
    public void save(BenhNhan benhNhan) {
        benhNhanRepository.save(benhNhan.getName());
    }

    @Override
    public void update(BenhNhan benhNhan) {
        benhNhanRepository.update(benhNhan.getName(), benhNhan.getId());
    }
}
