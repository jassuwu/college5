package p2;
import java.lang.*;
import java.util.*;


public class Account {
    private Person person;
    private String username;
    private String password;
    private ArrayList<Account> friendList;

    public Account(Person person, String username, String password) {
        this.person = person;
        this.username = username;
        this.password = password;
        this.friendList = new ArrayList<Account>();
    }

    public Account(Person person, String username, String password, Account[] friendList) {
        this.person = person;
        this.username = username;
        this.password = password;
        this.friendList = new ArrayList<Account>(Arrays.asList(friendList));
    }

    public Account(Person person, String username, String password, ArrayList<Account> friendList) {
        this.person = person;
        this.username = username;
        this.password = password;
        this.friendList = friendList;
    }

    public Account(String name, String gender, Date DOB, String phnNo, String email, String username, String password, ArrayList<Account> friendList) {
        this.person = new Person(name, gender, DOB, phnNo, email);
        this.username = username;
        this.password = password;
        this.friendList = friendList;
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

    public boolean addFriend(Account a){
        this.friendList.add(a);
        return true;
    }

    public boolean removeFriend(Account a){
        this.friendList.remove(a);
        return true;
    }

    public void displayFriendInfo() {
        for (Account a : this.getFriendList()){
            System.out.println(a.toString());
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
