package utcapitole.miage.tp3conferences.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import utcapitole.miage.tp3conferences.model.Participant;
import utcapitole.miage.tp3conferences.model.Statut;
import utcapitole.miage.tp3conferences.model.jpa.ParticipantService;
import utcapitole.miage.tp3conferences.model.jpa.StatutService;

@Controller
@RequestMapping("/participants")
public class ParticipantController {

	@Autowired
	private StatutService statService;
	
	@Autowired
	private ParticipantService partService;
		
	
	@GetMapping("/formCreation")
	public String formNumber(Model model) {
		List<Statut> statuts = statService.getAllStatuts();
				
		model.addAttribute("status", statuts);		
		
		return "formCreationParticipants";
	}	
	
	@GetMapping("/insert")
	public String insertParticipant(
			@RequestParam("txt_nom") String nomPart,
			@RequestParam("txt_prenom") String prenomPart,
			@RequestParam(value="txt_organisme", defaultValue = "") String organismePart, 
			@RequestParam(value="txt_cp", defaultValue = "00000") Integer cpPart,
			@RequestParam(value="txt_adresse", defaultValue = "") String adrPart, 
			@RequestParam(value="txt_ville", defaultValue = "") String villePart, 
			@RequestParam(value="txt_pays", defaultValue = "") String paysPart, 
			@RequestParam("txt_email") String emailPart, 
			@RequestParam("rd_statut") Integer statut,
			@RequestParam("txt_password") String password,		
			Model model) {
		boolean ajoutSucces = false;
		
		Participant n = null;
		
		if (!partService.emailPresent(emailPart)) {
			n = new Participant();
			n.setNomPart(nomPart);
			n.setPrenomPart(prenomPart);
			n.setOrganismePart(organismePart);
			n.setCpPart(cpPart);
			n.setAdrPart(adrPart);
			n.setVillePart(villePart);
			n.setPaysPart(paysPart);
			n.setEmailPart(emailPart);	
			n.setStatut(statService.findByCodeStatut(statut));
			n.setPassword(password);
						
	        LocalDate currentDate = LocalDate.now();
			n.setDtInscription(currentDate.toString());					
			
			partService.createParticipant(n);
			ajoutSucces = true;		
		}

		model.addAttribute("part", n);
		model.addAttribute("ajoutSucces",ajoutSucces);
		
		return "confirmCreationParticipant";
	}
	

	@GetMapping("/list")
	public String listParticipants(Model model) {
		model.addAttribute("parts", partService.getAllParticipants());
		return "listParticipants";
	}

	@PostMapping("/connect")
	public String connection(			
			@RequestParam("txt_email") String email,
			@RequestParam("txt_pass") String pass,
			HttpSession session) {

		List<Participant> participants = partService.getAllParticipants();
		Participant part = participants.stream()
        	.filter(p -> p.getEmailPart().equals(email))
        	.findFirst()
        	.orElse(null);
		
		if((part != null) && (part.getPassword().equals(pass)) ){
			session.setAttribute("part", part);
			session.setAttribute("estConnecte", true);
		} else {
			session.setAttribute("part", null);
			session.setAttribute("estConnecte", false);
		}
		
		return "redirect:/index";
	}

	
	@GetMapping("/deconnect")
	public String connection(			
			HttpSession session) {
		
		session.setAttribute("part", null);
		session.setAttribute("estConnecte", false);

		return "redirect:/index";
	}
}
