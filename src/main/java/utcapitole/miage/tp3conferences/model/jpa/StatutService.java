package utcapitole.miage.tp3conferences.model.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utcapitole.miage.tp3conferences.model.Statut;

@Service
public class StatutService {
	@Autowired
	private StatutRepository statutRepo;
	
	public List<Statut> getAllStatuts() {
		return statutRepo.findAll();
	}
	
	public Statut findByCodeStatut(Integer codeStatut) {
		return statutRepo.findByCodeStatut(codeStatut);
	}
}
