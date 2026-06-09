package com.udacity.jwdnd.c1.review.model;

public class ChatMessage {

    private String messageText;
    private String username;

    public ChatMessage() {
    }

    public ChatMessage(String messageText, String username) {
        this.messageText = messageText;
        this.username = username;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
