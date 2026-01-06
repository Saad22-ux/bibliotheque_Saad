package com.elasri.mslivre16.repositories;

import com.elasri.mslivre16.entities.Livre16;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends JpaRepository<Livre16, Long> {
}
