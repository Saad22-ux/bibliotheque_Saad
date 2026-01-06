package com.elasri.msetudiant16.web;

import com.elasri.msetudiant16.entities.Etudiant16;
import com.elasri.msetudiant16.repositories.EtudiantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EtudiantController {
    private EtudiantRepository etudiantRepository;

    public EtudiantController(EtudiantRepository etudiantRepository)
    {
        this.etudiantRepository = etudiantRepository;
    }

    @GetMapping("/etudiants")
    public List<Etudiant16> getAllEtudiants()
    {
        return etudiantRepository.findAll();
    }

    @GetMapping("/etudiants/{id}")
    public Etudiant16 getEtudiantById(@PathVariable Long id)
    {
        return etudiantRepository.findById(id).get();
    }

    @PostMapping("/etudiants")
    public Etudiant16 addEtudiant(@RequestBody Etudiant16 e)
    {
        return etudiantRepository.save(e);
    }

    @PutMapping("/etudiants/{id}")
    public Etudiant16 updateEtudiant(@PathVariable Long id, @RequestBody Etudiant16 etudiant) {
        Etudiant16 etud = etudiantRepository.findById(id).get();
        BeanUtils.copyProperties(etudiant, etud);
        etudiantRepository.save(etud);
        return etud;
    }

    @DeleteMapping("/etudiants/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantRepository.deleteById(id);
    }
}
