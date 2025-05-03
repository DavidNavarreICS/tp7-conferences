package utcapitole.miage.tp3conferences.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "activites")
public class Activite {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	Integer codeActivite; 
	
	String nomActivite;
	Integer prixActivite;
	
	public Integer getCodeActivite() {
		return codeActivite;
	}
	public void setCodeActivite(Integer codeActivite) {
		this.codeActivite = codeActivite;
	}
	public String getNomActivite() {
		return nomActivite;
	}
	public void setNomActivite(String nomActivite) {
		this.nomActivite = nomActivite;
	}
	public Integer getPrixActivite() {
		return prixActivite;
	}
	public void setPrixActivite(Integer prixActivite) {
		this.prixActivite = prixActivite;
	}
	
	
	
}
