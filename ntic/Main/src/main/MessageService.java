package com.example.de.copy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

 

	public List<Message> getMessagesBetweenUsers(String userId1, String userId2) {
		// TODO Auto-generated method stub
		 return messageRepository.findByExpediteurEmailAndDestinataireEmailOrExpediteurEmailAndDestinataireEmailOrderByCreatedAtAsc( userId1,  userId2, userId2,  userId1);
	}
	 public void saveMessage(Message message) {
	    	try {
	    		Message savedMessage = messageRepository.save(message);
	            System.out.println("Message time: brqvo");
	        } catch (Exception e) {
	            e.printStackTrace();
	          
	       
	    }}
	 }

  




    
