package utcapitole.miage.tp3conferences.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import utcapitole.miage.tp3conferences.model.Activite;
import utcapitole.miage.tp3conferences.model.Conference;
import utcapitole.miage.tp3conferences.model.Participant;
import utcapitole.miage.tp3conferences.model.Thematique;
import utcapitole.miage.tp3conferences.model.jpa.ActiviteService;
import utcapitole.miage.tp3conferences.model.jpa.ConferenceService;
import utcapitole.miage.tp3conferences.model.jpa.ParticipantService;
import utcapitole.miage.tp3conferences.model.jpa.ThematiqueService;

@Controller
@RequestMapping("/conferences")
public class ConferenceController {

	@Autowired
	private ConferenceService confService;

	@Autowired
	private ParticipantService partService;
	
	@Autowired
	private ActiviteService activiteService;

	@Autowired
	private ThematiqueService thematiqueService;	
	
	@PostMapping("/inscrire/choixConf")
	public String choixConf(
		@RequestParam("rd_statut") Integer idConf, HttpSession session, Model model) {
		//session.setAttribute("idConf", idConf);
		
		Conference conference = confService.findByCodConf(idConf);
		session.setAttribute("conference", conference);

		return "formInscrChoixThemActivites";
	}
	
	@PostMapping("/inscrire/choixThemAct")
	public String choixThemAct(
			@RequestParam(name = "cb_thematiques", required = false) List<Integer> thematiquesId,
			@RequestParam(name = "cb_activites", required = false) List<Integer> activitesId, 
			HttpSession session) {

		List<Activite> activites = new ArrayList<>();
		if (activitesId != null) {
			for (Integer id : activitesId) {
				Activite a = activiteService.findByCodeActivite(id);
				activites.add(a);
			}
		}

		List<Thematique> thematiques = new ArrayList<>();
		if (thematiquesId != null) {
			for (Integer id : thematiquesId) {
				Thematique t = thematiqueService.findByCodeThematique(id);
				thematiques.add(t);
			}
		}

		session.setAttribute("thematiques", thematiques);
		session.setAttribute("activites", activites);

		return "formInscrRecapitulatif";
	}
	
	@PostMapping("/inscrire/confirm")
	public String inscrire(HttpSession session, Model model) {

		Conference conference = (Conference) session.getAttribute("conference");
		List<Thematique> thematiques = (List<Thematique>) session.getAttribute("thematiques");
		List<Activite> activites = (List<Activite>) session.getAttribute("activites");

		Participant p = (Participant) session.getAttribute("part");
		
		conference.addInscrit(p);
		confService.updateConference(conference);
		
//		confService.inscrireParticipant(nom, prenom, email, conference, thematiques, activites);

		return "index";
	}
	
	@GetMapping("/formCreation")
	public String formNumber(Model model) {
		model.addAttribute("activites", activiteService.getAllActivites());
		model.addAttribute("thematiques", thematiqueService.getAllThematiques());
		
		return "formCreationConferences";
	}	
	
	
	@GetMapping("/insert")
	public String insertParticipant(
			@RequestParam("txt_titre") String titre,
			@RequestParam("txt_numedition") Integer numedition,
			@RequestParam(value="txt_debut", defaultValue = "") String debut, 
			@RequestParam(value="txt_fin", defaultValue = "") String fin,
			@RequestParam(value="txt_url", defaultValue = "") String url,	
			@RequestParam(name = "cb_thematiques", required = false) List<Integer> thematiquesId,
			@RequestParam(name = "cb_activites", required = false) List<Integer> activitesId,
			Model model) {
		
		Conference c = new Conference();
		c.setTitreConf(titre);
		c.setNumEditionConf(numedition);
		c.setDtDebutConf(debut);
		c.setDtFinConf(fin);
		c.setUrlSiteWebConf(url);
		
		List<Activite> activites = new ArrayList<>();
		if (activitesId != null) {
			for (Integer id : activitesId) {
				Activite a = activiteService.findByCodeActivite(id);
				activites.add(a);
			}
		}
		c.addAllActivites(activites);
		
		List<Thematique> thematiques = new ArrayList<>();
		if (thematiquesId != null) {
			for (Integer id : thematiquesId) {
				Thematique t = thematiqueService.findByCodeThematique(id);
				thematiques.add(t);
			}
		}
		c.addAllThematiques(thematiques);
		
		confService.createConference(c);
		model.addAttribute("conf", c);
		
		return "confirmCreationConference";
	}

	@GetMapping("/list")
	public String listConferences(Model model) {
		model.addAttribute("conferences", confService.getAllConferences());
		return "listConferences";
	}


}
