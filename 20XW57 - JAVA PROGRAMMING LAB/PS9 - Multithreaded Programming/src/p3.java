import java.lang.*;
import java.util.*;

public class p3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of users: ");
        Integer noOfUsers = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the number of users per thread: ");
        Integer noOfUsersPerThread = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the user details: ");
        List<String> users = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        for(int i = 0; i < noOfUsers; i++) {
            users.add(sc.nextLine());
        }
        for(String s : users ){
            userList.add(new User(s.split(",")[0], s.split(",")[1]));
        }

        addMessages(noOfUsers, noOfUsersPerThread, userList);

    }

    public synchronized static void addMessages(Integer noOfUsers, Integer noOfUsersPerThread, List<User> userList) {
        for(int i = 0; i < noOfUsers/noOfUsersPerThread; i++) {
            new Thread(new UserBO(userList.subList(i,i+noOfUsersPerThread))).start();
        }
    }
}

class User {
    private String username;
    private String mobileNumber;

    public User() {
    }

    public User(String username, String mobileNumber) {
        this.username = username;
        this.mobileNumber = mobileNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}

class UserBO implements Runnable {
    public List<User> userList;
    public static List<String> message;

    public UserBO(List<User> userList) {
        this.userList = userList;
        this.message = new ArrayList<>();
    }

    @Override
    public void run() {
        synchronized (this) {
            for(User u : userList) {
                message.add("The message is sent to the user " + u.getUsername() + " at the mobile number " + u.getMobileNumber());
            }
        }
    }

    public static List<String> getMessage() {
        return message;
    }
}