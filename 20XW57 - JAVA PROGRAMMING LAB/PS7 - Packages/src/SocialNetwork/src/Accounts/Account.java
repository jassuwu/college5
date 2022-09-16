package Accounts;

import java.lang.*;
import java.util.*;
import Inbox.*;


public class Account {
    private Person person;
    private String username;
    private String password;
    private ArrayList<Account> friendList;
    private ArrayList<Message> inbox;

    public Account(Person person, String username, String password) {
        this.person = person;
        this.username = username;
        this.password = password;
        this.friendList = new ArrayList<Account>();
        this.inbox = new ArrayList<Message>();
    }

    public Account(Person person, String username, String password, Account[] friendList, Message[] inbox) {
        this.person = person;
        this.username = username;
        this.password = password;
        this.friendList = new ArrayList<Account>(Arrays.asList(friendList));
        this.inbox = new ArrayList<Message>(Arrays.asList(inbox));
    }

    public Account(Person person, String username, String password, ArrayList<Account> friendList, ArrayList<Message> inbox) {
        this.person = person;
        this.username = username;
        this.password = password;
        this.friendList = friendList;
        this.inbox = inbox;
    }

    public Account(String name, String gender, Date DOB, String phnNo, String email, String username, String password,
            ArrayList<Account> friendList) {
        this.person = new Person(name, gender, DOB, phnNo, email);
        this.username = username;
        this.password = password;
        this.friendList = friendList;
        this.inbox = new ArrayList<Message>();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Account> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<Account> friendList) {
        this.friendList = friendList;
    }

    public ArrayList<Message> getInbox() {
        return inbox;
    }

    public void setInbox(ArrayList<Message> inbox) {
        this.inbox = inbox;
    }

    public boolean addFriend(Account a) {
        this.friendList.add(a);
        return true;
    }

    public boolean removeFriend(Account a) {
        this.friendList.remove(a);
        return true;
    }

    public boolean addMessage(Message m) {
        this.getInbox().add(m);
        return true;
    }

    public boolean deleteMessage(Message m) {
        this.getInbox().remove(m);
        return true;
    }

    public boolean sendMessage(Message m, Account receiver) {
        Message temp = new Message(m.getMessage());
        temp.setSender(this.getUsername());
        temp.setReceiver(receiver.getUsername());
        receiver.addMessage(temp);
        return true;
    }

    public void displayFriendInfo() {
        for (Account a : this.getFriendList()) {
            System.out.println(a.toString());
        }
    }

    public void displayInbox() {
        for (Message m : this.getInbox()) {
            System.out.println(m.toString());
        }
    }

    @Override
    public String toString() {
        return "\nAccount{" +
                "\n\t" + person.toString() +
                ",\n\tusername='" + username + '\'' +
                ",\n\tpassword='" + password + '\'' +
                ",\n\tfriendList=" + friendList.toString() +
                "\n}";
    }
}
