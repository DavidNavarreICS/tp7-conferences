package utcapitole.miage.tp3conferences.model.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import utcapitole.miage.tp3conferences.model.Statut;

public interface StatutRepository extends JpaRepository<Statut, Long> {
	Statut findByCodeStatut(Integer codeStatut);
}
