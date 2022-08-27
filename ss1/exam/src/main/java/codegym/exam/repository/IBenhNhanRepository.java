package codegym.exam.repository;

import codegym.exam.model.BenhNhan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface IBenhNhanRepository {
//    @Query(value = "select * from benh-nhan", nativeQuery = true)
//    List<BenhNhan> findAll();
//
//    @Query(value = "select * from BenhNhan where id = :id", nativeQuery = true)
//    Optional<BenhNhan> findById(@Param("id") String id);
//
//    @Transactional
//    @Modifying
//    @Query(value = "insert into patienter(name) values (:name);", nativeQuery = true)
//    void save(@Param("name") String name);
//
//    @Transactional
//    @Modifying
//    @Query(value = "update patienter set name = :name where id = :id", nativeQuery = true)
//    void update(@Param("name") String name, @Param("id") Integer id);
}
