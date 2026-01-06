package com.elasri.msetudiant16.repositories;

import com.elasri.msetudiant16.entities.Etudiant16;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant16,Long>
{
}
