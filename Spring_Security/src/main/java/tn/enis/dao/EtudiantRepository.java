package tn.enis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enis.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{

}
