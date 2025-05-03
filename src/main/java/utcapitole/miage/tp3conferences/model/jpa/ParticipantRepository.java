package utcapitole.miage.tp3conferences.model.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import utcapitole.miage.tp3conferences.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
	List<Participant> findByEmailPart(String emailPart);
}
