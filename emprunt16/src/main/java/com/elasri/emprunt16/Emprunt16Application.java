package com.elasri.emprunt16;

import com.elasri.emprunt16.entities.Emprunt16;
import com.elasri.emprunt16.repositories.EmpruntRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class Emprunt16Application {

    public static void main(String[] args) {
        SpringApplication.run(Emprunt16Application.class, args);
    }


    @Bean
    CommandLineRunner run(EmpruntRepository empruntRepository) {
        return args -> {
            Emprunt16 emp1 = Emprunt16
                    .builder()
                    .idEtudiant(1L)
                    .idLivre(1L)
                    .dateDebut(LocalDate.of(2026,1,4))
                    .dateFin(LocalDate.of(2026,1,12))
                    .build();
            empruntRepository.save(emp1);

            Emprunt16 emp2 = Emprunt16
                    .builder()
                    .idEtudiant(2L)
                    .idLivre(2L)
                    .dateDebut(LocalDate.of(2026,1,2))
                    .dateFin(LocalDate.of(2026,1,10))
                    .build();
            empruntRepository.save(emp2);
        };
    }
}
