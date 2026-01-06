package com.elasri.emprunt16.web;

import com.elasri.emprunt16.modele.Livre16;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient("MS-LIVRE16")
public interface LivreOpenFeign {

    @GetMapping("/livres")
    public List<Livre16> getAllLivres();
    @GetMapping("/livres/{id}")
    public Livre16 getLivreById(@PathVariable Long id);
}
