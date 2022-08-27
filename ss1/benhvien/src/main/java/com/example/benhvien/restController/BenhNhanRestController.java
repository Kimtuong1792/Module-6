package com.example.benhvien.restController;

import com.example.benhvien.dto.BenhNhanDto;
import com.example.benhvien.model.BenhNhan;
import com.example.benhvien.service.IBenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/benh_nhan")
public class BenhNhanRestController {
    @Autowired
    IBenhNhanService benhNhanService;

    @GetMapping()
    public ResponseEntity<List<BenhNhan>> getList() {
        List<BenhNhan> benhNhanList = benhNhanService.findAll();
        if (benhNhanList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(benhNhanList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BenhNhan> findById(@PathVariable String id) {
        Optional<BenhNhan> benhNhan = benhNhanService.findById(id);
        if (!benhNhan.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(benhNhan.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody BenhNhan benhNhan) {
        benhNhanService.save(benhNhan);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BenhNhan> update(@PathVariable String id, @Validated @RequestBody BenhNhanDto benhNhanDto, BindingResult bindingResult) {
        Optional<BenhNhan> benhNhanOptional = benhNhanService.findById(id);

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

        if (!benhNhanOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        benhNhanOptional.get().setName(benhNhanDto.getName());

        benhNhanService.update(benhNhanOptional.get());

        return new ResponseEntity(benhNhanOptional.get(), HttpStatus.OK);
    }
}
