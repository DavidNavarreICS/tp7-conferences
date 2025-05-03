package utcapitole.miage.tp3conferences.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import utcapitole.miage.tp3conferences.model.Conference;
import utcapitole.miage.tp3conferences.model.jpa.ConferenceService;

@Controller
public class PagesController {

	@Autowired
	private ConferenceService confService;

	@GetMapping("/index")
	public String formNumber(HttpSession session) {
		if((session.getAttribute("estConnecte") == null) || (session.getAttribute("part") == null)){
			session.setAttribute("estConnecte", false);
		}

		return "index";
	}			
	
	@GetMapping("/formChoixConf")
	public String formChoixCongres(HttpSession session, Model model) {
		List<Conference> conferences = confService.getAllConferences();
		
		if ((session.getAttribute("estConnecte") == null) || (session.getAttribute("part") == null)) {
			session.setAttribute("estConnecte", false);
		} 
		
		model.addAttribute("conferences", conferences);

		return "formInscrChoixConference";
	}
	
}
