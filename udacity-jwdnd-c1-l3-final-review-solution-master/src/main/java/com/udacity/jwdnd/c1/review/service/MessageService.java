package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.MessageMapper;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Service
public class MessageService {
    // private List<ChatMessage> chatMessages;
    private MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

//    no longer needed
//
//    private String message;
//
//    public MessageService(String message) {
//        this.message = message;
//    }
//
//    public String uppercase() {
//        return this.message.toUpperCase();
//    }
//
//    public String lowercase() {
//        return this.message.toLowerCase();
//    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
        // this.chatMessages = new ArrayList<>();
    }

    public void addMessage(ChatForm chatForm, String username) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(username);
        switch (chatForm.getMessageType()) {
            case "Say":
                newMessage.setMessagetext(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessagetext(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessagetext(chatForm.getMessageText().toLowerCase());
                break;
        }
        this.messageMapper.insert(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return this.messageMapper.getAllMessages();
    }
}
