package utcapitole.miage.tp3conferences.model.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import utcapitole.miage.tp3conferences.model.Conference;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
	public Conference findByCodConf(Integer codeConference);
}
