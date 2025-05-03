package utcapitole.miage.tp3conferences.model.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utcapitole.miage.tp3conferences.model.Conference;

@Service
public class ConferenceService {

	@Autowired
	private ConferenceRepository confRepo;
	
	public Conference createConference(Conference c) {
		return confRepo.save(c);
	}	
	
	public Conference findByCodConf(Integer codeConference) {
		return confRepo.findByCodConf(codeConference);
	}
		
	public List<Conference> getAllConferences() {
		return confRepo.findAll();
	}
	
	public Conference updateConference(Conference c) {
		return confRepo.save(c);
	}	
	
	
}
