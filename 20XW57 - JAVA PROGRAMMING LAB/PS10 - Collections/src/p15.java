import java.util.*;

public class p15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<User> userList = new ArrayList<>();
        System.out.println("Enter the number of users: ");
        Integer n = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the details of the users in CSV format: ");
        for (int i = 0; i < n; i++) {
            String[] user = sc.nextLine().split(",");
            userList.add(new User(user[0], user[1], user[2], user[3]));
        }
        System.out.println("PRINTING THE USER LIST BEFORE SORT: ");
        System.out.println(userList);
        System.out.println("PRINTING THE USER LIST AFTER SORT: ");
        Collections.sort(userList);
        System.out.println(userList);
        System.out.println("PRINTING THE USER LIST AFTER REVERSE SORT: ");
        Collections.reverse(userList);
        System.out.println(userList);

        sc.close();
        System.exit(0);
    }
}

class User implements Comparable<User> {
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

    // compareTo
    @Override
    public int compareTo(User o) {
        return this.getName().compareTo(o.getName());
    }
}