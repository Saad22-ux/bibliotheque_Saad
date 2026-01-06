package com.elasri.emprunt16.entities;


import com.elasri.emprunt16.modele.Etudiant16;
import com.elasri.emprunt16.modele.Livre16;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Emprunt16 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprunt;
    private Long idEtudiant;
    @Transient
    private Etudiant16 etudiant;

    private Long idLivre;
    @Transient
    private Livre16 livre;

    private LocalDate dateDebut;
    private LocalDate dateFin;

}
