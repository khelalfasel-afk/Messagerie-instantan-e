package com.example.de.copy;


import java.sql.Timestamp;

public class MessageRequest {

    private String message;
    private String senderId;
    private String receiverId;
    private String  timestamp;
    public String getMessage() {
		return message;
	}
    
    public  String  getReceiverId() {
		return receiverId;
	}
    public  String  getSenderId() {
		return senderId;
	}
    public String getTimestamp() {
		return timestamp;
	}

}