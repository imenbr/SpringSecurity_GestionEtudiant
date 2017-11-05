package tn.enis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enis.dao.EtudiantRepository;
import tn.enis.entities.Etudiant;

//une classe controlleur
@RestController
public class EtudiantRestService {
	@Autowired
	private EtudiantRepository etudiantRepository ;
	
	@RequestMapping(value = "/saveEtudiant")
	public Etudiant saveEtudiant(Etudiant e){
		return etudiantRepository.save(e) ;
		
	}
	@RequestMapping(value = "/etudiants")
	public Page<Etudiant> listEtudiants(int page,int size){
		return etudiantRepository.findAll(new PageRequest(page, size)) ;
		
	}
}
