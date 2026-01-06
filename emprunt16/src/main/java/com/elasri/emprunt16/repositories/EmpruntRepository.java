package com.elasri.emprunt16.repositories;

import com.elasri.emprunt16.entities.Emprunt16;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt16, Long> {
}
