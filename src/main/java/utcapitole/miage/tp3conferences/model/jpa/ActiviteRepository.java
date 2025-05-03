package utcapitole.miage.tp3conferences.model.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import utcapitole.miage.tp3conferences.model.Activite;

public interface ActiviteRepository extends JpaRepository<Activite, Long> {
	Activite findByCodeActivite(Integer codeActivite);
}
