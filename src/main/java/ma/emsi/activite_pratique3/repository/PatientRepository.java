package ma.emsi.activite_pratique3.repository;

import ma.emsi.activite_pratique3.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    //methode 1
    Page<Patient> findByNomContains(String Keyword, Pageable pageable);

    //methode2 hql
    @Query("select p from Patient p where p.nom like :x")
    Page<Patient> chercher (@Param("x") String Keyword, Pageable pageable);
}
