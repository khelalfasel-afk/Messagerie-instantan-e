package com.example.de.copy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UtilisateurService {
  private final UtilisateurRepository  utilisaturRepository;

	    @Autowired
	    public UtilisateurService(UtilisateurRepository  utilisaturRepository) {
	        this.utilisaturRepository =utilisaturRepository;
	    }


	   


	    public  Utilisateur findUserByEmail(String email) {
	        return utilisaturRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
	    }

	    public   List<Utilisateur> GetConversationsForUser(String email) {
	        return utilisaturRepository.findConversationUsersForCurrentUser(email);
	    }
}
