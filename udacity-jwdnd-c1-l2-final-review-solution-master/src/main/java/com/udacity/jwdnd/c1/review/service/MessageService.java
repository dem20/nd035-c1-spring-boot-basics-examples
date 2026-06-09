package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class MessageService {

    // private String message;
    private List<ChatMessage> chatMessages;

    // public MessageService(String message) {
    //     this.message = message;
    // }

    // public String uppercase() {
    //     return this.message.toUpperCase();
    // }

    // public String lowercase() {
    //     return this.message.toLowerCase();
    // }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(chatForm.getUsername());

        switch (chatForm.getMessageType()) {
            case "Shout":
                chatMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                chatMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
            case "Say":
                chatMessage.setMessageText(chatForm.getMessageText());
                break;
        }
        this.chatMessages.add(chatMessage);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
        this.chatMessages = new ArrayList<>();
    }
}
