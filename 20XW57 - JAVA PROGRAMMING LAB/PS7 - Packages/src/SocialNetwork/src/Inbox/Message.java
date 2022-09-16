package Inbox;

import java.lang.*;
import java.util.*;

public class Message {
    private String sender;
    private String receiver;
    private String message;

    public Message(String message) {
        this.sender = "NoSender";
        this.receiver = "NoReceiver";
        this.message = message;
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

    public String toString() {
        return "Message {\nmessage=" + message + ", receiver=" + receiver
                + ", sender=" + sender + "\n}";
    }
}
