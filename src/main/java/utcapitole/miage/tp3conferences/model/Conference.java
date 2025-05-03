package utcapitole.miage.tp3conferences.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "conferences")
public class Conference {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codConf;
	
	private String titreConf;
	private Integer numEditionConf;
	private String dtDebutConf;
	private String dtFinConf; 
	private String urlSiteWebConf;
	
	@ManyToMany
	@JoinTable(
		name = "traiter",
		joinColumns = @JoinColumn(name = "codConf"),
		inverseJoinColumns = @JoinColumn(name = "codeThematique")
	)
	private List<Thematique> thematiques = new ArrayList<>();

	@ManyToMany
	@JoinTable(
		name = "proposer",
		joinColumns = @JoinColumn(name = "codConf"),
		inverseJoinColumns = @JoinColumn(name = "codeActivite")
	)
	private List<Activite> activites = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(
		name = "inscrire", 
		joinColumns = @JoinColumn(name = "codConf"), 
		inverseJoinColumns = @JoinColumn(name = "codParticipant")
	)
	private List<Participant> inscrits = new ArrayList<>();
	
	
	public void addThematique(Thematique t) {
		thematiques.add(t);
	}
	public void addAllThematiques(List<Thematique> ts) {
		thematiques.addAll(ts);
	}

	public void addActivite(Activite a) {
		activites.add(a);
	}	
	public void addAllActivites(List<Activite> as) {
		activites.addAll(as);
	}		
	public Long getCodConf() {
		return codConf;
	}
	public void setCodConf(Long codConf) {
		this.codConf = codConf;
	}
	public String getTitreConf() {
		return titreConf;
	}
	public void setTitreConf(String titreConf) {
		this.titreConf = titreConf;
	}
	public Integer getNumEditionConf() {
		return numEditionConf;
	}
	public void setNumEditionConf(Integer numEditionConf) {
		this.numEditionConf = numEditionConf;
	}
	public String getDtDebutConf() {
		return dtDebutConf;
	}
	public void setDtDebutConf(String dtDebutConf) {
		this.dtDebutConf = dtDebutConf;
	}
	public String getDtFinConf() {
		return dtFinConf;
	}
	public void setDtFinConf(String dtFinConf) {
		this.dtFinConf = dtFinConf;
	}
	public String getUrlSiteWebConf() {
		return urlSiteWebConf;
	}
	public void setUrlSiteWebConf(String urlSiteWebConf) {
		this.urlSiteWebConf = urlSiteWebConf;
	}
	public List<Thematique> getThematiques() {
		return thematiques;
	}
	public void setThematiques(List<Thematique> thematiques) {
		this.thematiques = thematiques;
	}
	public List<Activite> getActivites() {
		return activites;
	}
	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}
	public List<Participant> getInscrits() {
		return inscrits;
	}
	public void setInscrits(List<Participant> inscrits) {
		this.inscrits = inscrits;
	}
	public Participant addInscrit(Participant inscrit) {
		return inscrit;
	}
}
