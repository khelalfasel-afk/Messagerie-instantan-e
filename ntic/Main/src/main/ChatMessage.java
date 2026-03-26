package com.example.de.copy;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {

   
    private String content;
    private String sender;
    public String getSender() {
		return sender;
	}

}
