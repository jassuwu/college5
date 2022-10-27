import java.util.*;

public class p5 {
    public static void main(String[] args) {
        // Dummy user List
        List<User> users = new ArrayList<>();
        users.add(new User("name3", "em@il3", "username3", "password3"));
        users.add(new User("name5", "em@il1", "username1", "password1"));
        users.add(new User("name4", "em@il4", "username4", "password4"));
        users.add(new User("name7", "em@il2", "username2", "password2"));

        System.out.println("\nBEFORE SORTING OF USERS: " + users);
        Collections.sort(users, new NameComparator());
        System.out.println("\n\nAFTER SORTING OF USERS BY NAME: " + users);
        Collections.sort(users, new EmailComparator());
        System.out.println("\n\nAFTER SORTING OF USERS BY EMAIL: " + users);
        System.exit(0);
    }
}

class User {
    private String name;
    private String email;
    private String username;
    private String password;

    // Constructors
    public User() {
    }

    public User(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    // toString
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}

class NameComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class EmailComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getEmail().compareTo(o2.getEmail());
    }
}