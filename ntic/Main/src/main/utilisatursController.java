package com.example.de.copy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class utilisatursController {
	  private UtilisateurService utilisateurService;
	   

	    @Autowired
	    public utilisatursController(UtilisateurService utilisateur) {
	        this.utilisateurService = utilisateur;
	    }
	    
	    
	    @GetMapping("/find/{userId1}")
	    public Utilisateur  findUser(@PathVariable String userId1) {
	    	Utilisateur u=utilisateurService.findUserByEmail(userId1);
	        return u;
	    }
	    
	    
  
	    
	    @GetMapping("/Conversation/{user1}")
	    public List<Utilisateur> findConversation(@PathVariable String user1) {
	    	List<Utilisateur> u=utilisateurService.GetConversationsForUser(user1);
	        return u;
	    }
}
