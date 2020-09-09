package com.kodluyoruz.models;

import com.kodluyoruz.interfaces.Channel;

public class Email implements Channel {

    private String title;
    private String message;
    private Company sender;
    private User receiver;


    @Override
    public void send(String message){
        System.out.println("Send Email from "+sender.getName()+" to "+receiver.getEmail()+": "+message);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Company getSender() {
        return sender;
    }

    public void setSender(Company sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
}
