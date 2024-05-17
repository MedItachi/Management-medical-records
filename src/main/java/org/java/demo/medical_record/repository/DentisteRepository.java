package org.java.demo.medical_record.repository;

import org.java.demo.medical_record.entities.Dentiste;
import org.java.demo.medical_record.enums.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DentisteRepository extends JpaRepository<Dentiste, Long>{
    public List<Dentiste> findBySpecialite(Specialite specialite);
}
