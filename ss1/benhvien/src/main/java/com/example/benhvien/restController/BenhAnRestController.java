package com.example.benhvien.restController;

import com.example.benhvien.dto.BenhAnDto;
import com.example.benhvien.model.BenhAn;
import com.example.benhvien.service.IMPL.BenhAnService;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/api/v1/benh_an")
public class BenhAnRestController {
    @Autowired
    BenhAnService benhAnService;

    @GetMapping("/list")
    public ResponseEntity<List<BenhAn>> findAllPagination(@RequestParam(value = "page", required = false) Integer page) {
        List<BenhAn> benhAnList = benhAnService.findAllPagination(page);
        if (benhAnList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(benhAnList, HttpStatus.OK);
    }
    @GetMapping("/list-no-page")
    public ResponseEntity<List<BenhAn>> findAll() {
        List<BenhAn> benhAnLists = benhAnService.findAll();
        if (benhAnLists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(benhAnLists, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<BenhAn>> search(@RequestParam(value = "bacSi", required = false, defaultValue = "") String bacSi, @RequestParam(value = "maBenhAn", required = false, defaultValue = "") String maBenhAn, @RequestParam(value = "li_do", required = false, defaultValue = "") String liDo, @RequestParam(value = "dieuTri", required = false, defaultValue = "") String dieuTri, @RequestParam(value = "page", required = false) Integer page) {
        List<BenhAn> benhAns = benhAnService.search(bacSi, maBenhAn, liDo, dieuTri, page);
        if (benhAns.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(benhAns, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BenhAn> findById(@PathVariable String id) {
        Optional<BenhAn> patient = benhAnService.findById(id);
        if (!patient.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patient.get(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<BenhAn> delete(@PathVariable String id) {
        Optional<BenhAn> benhAn = benhAnService.findById(id);

        if (!benhAn.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        benhAnService.delete(id);

        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity add(@Validated @RequestBody BenhAnDto benhAnDto, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_FOUND);
        }

        BenhAn benhAn = new BenhAn();

        BeanUtils.copyProperties(benhAnDto, benhAn);

        benhAn.setMaBenhNhan(benhAnDto.getBenhNhan());

        benhAn.setNgayBatDau(benhAnDto.getNgayBatDau());

        benhAn.setNgayKetThuc(benhAnDto.getNgayKetThuc());

        benhAnService.save(benhAn);

        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BenhAn> update(@PathVariable String id, @Validated @RequestBody BenhAnDto benhAnDto, BindingResult bindingResult) {
        Optional<BenhAn> benhAnOptional = benhAnService.findById(id);

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

        if (!benhAnOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        benhAnOptional.get().setMaBenhNhan(benhAnDto.getBenhNhan());

        benhAnOptional.get().setNgayBatDau(benhAnDto.getNgayBatDau());

        benhAnOptional.get().setNgayKetThuc(benhAnDto.getNgayKetThuc());

        benhAnOptional.get().setLiDo(benhAnDto.getLiDo());

        benhAnOptional.get().setDieuTri(benhAnDto.getDieuTri());

        benhAnOptional.get().setBacSi(benhAnDto.getBacSi());

        benhAnService.update(benhAnOptional.get());

        return new ResponseEntity(benhAnOptional.get(), HttpStatus.OK);
    }
}
