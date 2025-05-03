package utcapitole.miage.tp3conferences.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "statuts")
public class Statut {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	Integer codeStatut;
		
	String nomStatut;
	
	public Integer getCodeStatut() {
		return codeStatut;
	}
	public void setCodeStatut(Integer codeStatut) {
		this.codeStatut = codeStatut;
	}
	public String getNomStatut() {
		return nomStatut;
	}
	public void setNomStatut(String nomStatut) {
		this.nomStatut = nomStatut;
	}
}
