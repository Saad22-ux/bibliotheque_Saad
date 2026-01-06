package com.elasri.mslivre16.web;


import com.elasri.mslivre16.entities.Livre16;
import com.elasri.mslivre16.repositories.LivreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivreController {

    private LivreRepository livreRepository;

    public LivreController(LivreRepository livreRepository)
    {
        this.livreRepository = livreRepository;
    }

    @GetMapping("/livres")
    public List<Livre16> getAllEtudiants()
    {
        return livreRepository.findAll();
    }

    @GetMapping("/livres/{id}")
    public Livre16 getEtudiantById(@PathVariable Long id)
    {
        return livreRepository.findById(id).get();
    }

    @PostMapping("/livres")
    public Livre16 addEtudiant(@RequestBody Livre16 e)
    {
        return livreRepository.save(e);
    }

    @PutMapping("/livres/{id}")
    public Livre16 updateEtudiant(@PathVariable Long id, @RequestBody Livre16 etudiant) {
        Livre16 etud = livreRepository.findById(id).get();
        BeanUtils.copyProperties(etudiant, etud);
        livreRepository.save(etud);
        return etud;
    }

    @DeleteMapping("/livres/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        livreRepository.deleteById(id);
    }
}
