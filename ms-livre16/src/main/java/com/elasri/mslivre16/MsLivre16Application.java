package com.elasri.mslivre16;

import com.elasri.mslivre16.entities.Livre16;
import com.elasri.mslivre16.repositories.LivreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsLivre16Application {

    public static void main(String[] args) {
        SpringApplication.run(MsLivre16Application.class, args);
    }

    @Bean
    CommandLineRunner run(LivreRepository livreRepository) {
        return args -> {
            Livre16 liv1 = Livre16.builder()
                    .nomLivre("John")
                    .auteur("Doe")
                    .build();
            livreRepository.save(liv1);

            Livre16 liv2 = Livre16.builder()
                    .nomLivre("boite a merveilles")
                    .auteur("ahmed")
                    .build();
            livreRepository.save(liv2);

            Livre16 liv3 = Livre16.builder()
                    .nomLivre("antigone")
                    .auteur("saad")
                    .build();
            livreRepository.save(liv3);
        };
    }
    
}
