package com.example.de.copy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController

public class MessageController {
	
    private final MessageService messageService;
    private final  UtilisateurService utilisateurService;
    @Autowired
    public MessageController(MessageService messageService,   UtilisateurService utilisateurServi) {
        this.messageService = messageService;
         this.utilisateurService=utilisateurServi;
    }
    @PostMapping("/messages")
    public void saveMessage(@RequestBody MessageRequest  messagejava) {
    
    	System.out.println(messagejava.getMessage());
    	System.out.println(messagejava.getReceiverId());
    	System.out.println(messagejava.getSenderId());
    	System.out.println(messagejava.getTimestamp());
    	
    	Message message = new  Message ();
        
        Utilisateur sender = utilisateurService.findUserByEmail(messagejava.getSenderId());
        Utilisateur receiver = utilisateurService.findUserByEmail(messagejava.getReceiverId());
        message.setExpediteur(sender);
        message.setDestinataire(receiver);
        message.setContenu(messagejava.getMessage());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date parsedDate = dateFormat.parse(messagejava.getTimestamp());
            Timestamp timestamp = new Timestamp(parsedDate.getTime());
     
        message.setCreatedAt(timestamp);
        messageService.saveMessage(message);
        messageService.saveMessage(message);
    } catch (Exception e) {
        e.printStackTrace();
    }
        
    }

    
    @GetMapping("/messages/{user1}/{user2}")
    public List<Message> getMessagesBetweenUsers(@PathVariable String user1, @PathVariable String user2) {
    	List<Message> messages = messageService.getMessagesBetweenUsers(user1, user2);
        return messages;
    }
	
  
    
    
}
