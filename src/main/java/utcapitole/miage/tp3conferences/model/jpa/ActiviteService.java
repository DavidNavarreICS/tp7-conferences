package utcapitole.miage.tp3conferences.model.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utcapitole.miage.tp3conferences.model.Activite;

@Service
public class ActiviteService {
	@Autowired
	private ActiviteRepository activiteRepo;
	
	public List<Activite> getAllActivites() {
		return activiteRepo.findAll();
	}
	
	public Activite findByCodeActivite(Integer codeActivite) {
		return activiteRepo.findByCodeActivite(codeActivite);
	}
}
