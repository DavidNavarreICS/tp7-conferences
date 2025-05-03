package utcapitole.miage.tp3conferences.model.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utcapitole.miage.tp3conferences.model.Thematique;

@Service
public class ThematiqueService {
	
	@Autowired
	private ThematiqueRepository thematiqueRepo;
	
	public List<Thematique> getAllThematiques() {
		return thematiqueRepo.findAll();
	}
	
	public Thematique findByCodeThematique(Integer codeThematique) {
		return thematiqueRepo.findByCodeThematique(codeThematique);
	}
}
