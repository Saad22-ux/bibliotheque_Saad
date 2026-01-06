package com.elasri.emprunt16.web;

import com.elasri.emprunt16.entities.Emprunt16;
import com.elasri.emprunt16.modele.Etudiant16;
import com.elasri.emprunt16.modele.Livre16;
import com.elasri.emprunt16.repositories.EmpruntRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EmpruntController {

    EmpruntRepository empruntRepository;
    EtudiantOpenFeign etudiantOpenFeign;
    LivreOpenFeign livreOpenFeign;

    public EmpruntController(EmpruntRepository empruntRepository,  EtudiantOpenFeign etudiantOpenFeign, LivreOpenFeign livreOpenFeign) {
        this.empruntRepository = empruntRepository;
        this.etudiantOpenFeign = etudiantOpenFeign;
        this.livreOpenFeign = livreOpenFeign;
    }


    @GetMapping("/emprunts")
    public List<Emprunt16> findAll() {
        List<Emprunt16> emprunts = empruntRepository.findAll();
        List<Etudiant16> etudiants = etudiantOpenFeign.getAllEtudiants();
        List<Livre16> livres = livreOpenFeign.getAllLivres();
        for(Emprunt16 emprunt : emprunts) {
            for(Etudiant16 etudiant : etudiants){
                if(emprunt.getIdEtudiant() == etudiant.getId()){
                    emprunt.setEtudiant(etudiant);
                    break;
                }
            }
            for (Livre16 livre : livres){
                if(emprunt.getIdLivre() == livre.getId()){
                    emprunt.setLivre(livre);
                }
            }
        }
        return emprunts;
    }

    @GetMapping("/emprunts/{id}")
    public Emprunt16 findById(@PathVariable Long id) {
        Emprunt16 emprunt = empruntRepository.findById(id).get();
        Etudiant16 etudiant = etudiantOpenFeign.getEtudiantById(emprunt.getIdEtudiant());
        Livre16 livre = livreOpenFeign.getLivreById(emprunt.getIdEmprunt());

        emprunt.setEtudiant(etudiant);
        emprunt.setLivre(livre);
        return emprunt;
    }

    @PostMapping("/emprunts")
    public Emprunt16 save(@RequestBody Emprunt16 emprunt) {
        return empruntRepository.save(emprunt);
    }

    @PutMapping("/emprunts/{id}")
    public Emprunt16 update(@PathVariable Long id, @RequestBody Emprunt16 emprunt) {
        Emprunt16 cmd = empruntRepository.findById(id).get();
        BeanUtils.copyProperties(emprunt, cmd);
        empruntRepository.save(cmd);
        return cmd;
    }

    @DeleteMapping("/commandes/{id}")
    public void deleteById(@PathVariable Long id) {
        empruntRepository.deleteById(id);
    }
}
