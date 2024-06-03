package org.java.demo.medical_record.repository;

import org.java.demo.medical_record.entities.Utlisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository  extends JpaRepository<Utlisateur, Long> {
    boolean existsByUsername(String username);
    Utlisateur findByUsername(String username);
}
