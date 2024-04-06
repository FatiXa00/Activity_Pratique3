package ma.emsi.activite_pratique3;

import ma.emsi.activite_pratique3.entities.Patient;
import ma.emsi.activite_pratique3.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ActivitePratique3Application implements CommandLineRunner {

    @Autowired
    PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(ActivitePratique3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

       /* //1ere solution
        Patient patient=new Patient;
        patient.setId(null);
        patient.setNom ("Mohamed");
        patient.setDateNaissance (new Date());
        patient.setMalade (false);
        patient.setScore (23);

        //2eme solution
        Patient patient2=new Patient (null, "yassine", new Date(),false,123);

        //3eme solution LOMBOK en utilisant builder

        Patient patient3=Patient.builder()
                .nom("Aymen")
                .dateNaissance(new Date())
                .malade(true)
                .score(56)
                .build();*/

        patientRepository.save(new Patient(null,"mohamed",new Date(),false,34));
        patientRepository.save(new Patient(null,"hanane",new Date(),false,4321));
        patientRepository.save(new Patient(null,"imane",new Date(),true ,34));

    }
}
