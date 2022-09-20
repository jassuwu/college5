import java.lang.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of iterations: ");
        int iterations = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < iterations; i++) {
            System.out.println("Enter " + (i + 1) + "th User: ");
            System.out.println("Enter the name: ");
            String name = sc.nextLine();
            System.out.println("Enter the mobile: ");
            String mobile = sc.nextLine();
            System.out.println("Enter the username: ");
            String username = sc.nextLine();
            System.out.println("Enter the password: ");
            String password = sc.nextLine();
            User u = new User(name, mobile, username, password);
            try {
                UserBO.validate(u);
                System.out.println(u.toString());
            } catch (WeakPasswordException e) {
                System.err.println(e);
            }
        }
    }
}

class User {
    private String name;
    private String mobile;
    private String username;
    private String password;

    public User() {
    }

    public User(String name, String mobile, String username, String password) {
        this.name = name;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


class UserBO {
    static void validate(User u) throws WeakPasswordException{
        String pass = new String(u.getPassword());
        String regex = "^(?=.*[0-9])"
                + "(?=.*[A-Za-z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{10,20}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pass);
        if (!m.matches()) {
            throw new WeakPasswordException("Your password is weak.");
        }
    }
}

class WeakPasswordException extends Exception {
    public WeakPasswordException(String message) {
        super(message);
    }
}
