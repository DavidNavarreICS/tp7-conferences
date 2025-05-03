package utcapitole.miage.tp3conferences.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "thematiques")
public class Thematique {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	Integer codeThematique;
	
	String nomThematique;
	
	public Integer getCodeThematique() {
		return codeThematique;
	}
	public void setCodeThematique(Integer codeThematique) {
		this.codeThematique = codeThematique;
	}
	public String getNomThematique() {
		return nomThematique;
	}
	public void setNomThematique(String nomThematique) {
		this.nomThematique = nomThematique;
	}
}
