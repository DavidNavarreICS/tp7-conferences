package utcapitole.miage.tp3conferences.model;

import jakarta.persistence.*;

@Entity
@Table(name = "participants")
public class Participant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codParticipant; 
	
	private String nomPart; 
	private String prenomPart; 
	private String organismePart; 
	private Integer cpPart; 
	private String adrPart; 
	private String villePart ; 
	private String paysPart ; 
	private String emailPart ; 
	private String dtInscription ;
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "codeStatut")
	private Statut statut ;
	
	public static Long CODE_NEXT_PART = 1L;
	
	public Long getCodParticipant() {
		return codParticipant;
	}
	public void setCodParticipant(Long codParticipant) {
		this.codParticipant = codParticipant;
	}
	public String getNomPart() {
		return nomPart;
	}
	public void setNomPart(String nomPart) {
		this.nomPart = nomPart;
	}
	public String getPrenomPart() {
		return prenomPart;
	}
	public void setPrenomPart(String prenomPart) {
		this.prenomPart = prenomPart;
	}
	public String getOrganismePart() {
		return organismePart;
	}
	public void setOrganismePart(String organismePart) {
		this.organismePart = organismePart;
	}
	public Integer getCpPart() {
		return cpPart;
	}
	public void setCpPart(Integer cpPart) {
		this.cpPart = cpPart;
	}
	public String getAdrPart() {
		return adrPart;
	}
	public void setAdrPart(String adrPart) {
		this.adrPart = adrPart;
	}
	public String getVillePart() {
		return villePart;
	}
	public void setVillePart(String villePart) {
		this.villePart = villePart;
	}
	public String getPaysPart() {
		return paysPart;
	}
	public void setPaysPart(String paysPart) {
		this.paysPart = paysPart;
	}
	public String getEmailPart() {
		return emailPart;
	}
	public void setEmailPart(String emailPart) {
		this.emailPart = emailPart;
	}
	public String getDtInscription() {
		return dtInscription;
	}
	public void setDtInscription(String dtInscription) {
		this.dtInscription = dtInscription;
	}
	public Statut getStatut() {
		return statut;
	}
	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
