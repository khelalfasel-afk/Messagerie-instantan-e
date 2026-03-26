package com.example.de.copy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;






@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> { 
	  Optional<Utilisateur> findByEmail(String email);
	  
	  
	  @Query("SELECT DISTINCT m.destinataire FROM Message m WHERE (m.expediteur.email = :currentUserEmail OR m.destinataire.email = :currentUserEmail) AND m.destinataire.email!= :currentUserEmail")
	    List<Utilisateur> findConversationUsersForCurrentUser(@Param("currentUserEmail") String currentUserEmail);
	
}
