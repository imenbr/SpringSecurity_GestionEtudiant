package tn.enis;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import tn.enis.dao.EtudiantRepository;
import tn.enis.entities.Etudiant;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) throws ParseException {
		
		 ApplicationContext ctx =SpringApplication.run(SpringSecurityApplication.class, args);
	     EtudiantRepository etudiantRepository =ctx.getBean(EtudiantRepository.class) ;
	     DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
	     
	     etudiantRepository.save(new Etudiant("imen","bradai",df.parse("1994-09-11")));
	     etudiantRepository.save(new Etudiant("amal","zouari",df.parse("1994-11-11")));
	     etudiantRepository.save(new Etudiant("amira","bradai",df.parse("1980-10-11")));
	     
	     Page<Etudiant> etds=etudiantRepository.findAll(new PageRequest(0, 5)) ;
	     etds.forEach(e->System.out.println(e.getNom()));
	}
}
