package utcapitole.miage.tp3conferences.model.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import utcapitole.miage.tp3conferences.model.Thematique;

public interface ThematiqueRepository extends JpaRepository<Thematique, Long> {
	Thematique findByCodeThematique(Integer codeThematique);
}
