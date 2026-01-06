package com.elasri.emprunt16.web;

import com.elasri.emprunt16.modele.Etudiant16;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient("MS-ETUDIANT16")
public interface EtudiantOpenFeign {
    @GetMapping("/etudiants")
    public List<Etudiant16> getAllEtudiants();
    @GetMapping("/etudiants/{id}")
    public Etudiant16 getEtudiantById(@PathVariable Long id);
}
