package com.elasri.msetudiant16;

import com.elasri.msetudiant16.entities.Etudiant16;
import com.elasri.msetudiant16.repositories.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsEtudiant16Application {

    public static void main(String[] args) {
        SpringApplication.run(MsEtudiant16Application.class, args);
    }

    @Bean
    CommandLineRunner run(EtudiantRepository etudiantRepository) {
        return args -> {
            Etudiant16 etd1 = Etudiant16.builder()
                    .prenom("John")
                    .nom("Doe")
                    .appogee(20004007)
                    .build();
            etudiantRepository.save(etd1);

            Etudiant16 etd2 = Etudiant16.builder()
                    .prenom("saad")
                    .nom("elasri")
                    .appogee(20004008)
                    .build();
            etudiantRepository.save(etd2);

            Etudiant16 etd3 = Etudiant16.builder()
                    .prenom("Ilyas")
                    .nom("Namrani")
                    .appogee(20004009)
                    .build();
            etudiantRepository.save(etd3);
        };
    }

}
