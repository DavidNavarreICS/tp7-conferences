package utcapitole.miage.tp3conferences.model.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utcapitole.miage.tp3conferences.model.Participant;

@Service
public class ParticipantService {

	@Autowired
	private ParticipantRepository partRepo;
	
	public Participant createParticipant(Participant p) {
		return partRepo.save(p);
	}	
	
	public boolean emailPresent(String email) {
		return !partRepo.findByEmailPart(email).isEmpty();
	}
	
	public List<Participant> getAllParticipants() {
		return partRepo.findAll();
	}
	
	public Participant findByEmail(String email) {
		List<Participant> participants = partRepo.findByEmailPart(email);
		if (participants.isEmpty()) {
			return null;
		} else {
			return participants.get(0);
		}
	}
}
