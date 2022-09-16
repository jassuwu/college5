package Inbox;

import java.lang.*;
import java.util.*;

public class Message {
    private String sender;
    private String receiver;
    private String message;
    private Date dateOfReceival;

    public Message(String sender, String receiver, String message, Date dateOfReceival) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.dateOfReceival = dateOfReceival;
    }

    // Getters and Setters
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateOfReceival() {
        return dateOfReceival;
    }

    public void setDateOfReceival(Date dateOfReceival) {
        this.dateOfReceival = dateOfReceival;
    }

    public String toString() {
        return "Message {\nDateOfReceival=" + dateOfReceival + ", message=" + message + ", receiver=" + receiver
                + ", sender=" + sender + "\n}";
    }
}
