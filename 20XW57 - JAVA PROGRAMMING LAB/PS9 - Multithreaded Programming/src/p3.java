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
        for (int i = 0; i < noOfUsers; i++) {
            users.add(sc.nextLine());
        }
        sc.close();
        for (String s : users) {
            userList.add(new User(s.split(",")[0], s.split(",")[1]));
        }
        // Adding to the messages
        try {
            addMessages(noOfUsers, noOfUsersPerThread, userList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Printing the messages
        System.out.println();
        for (String msg : UserBO.message) {
            System.out.println(msg);
        }

    }

    public synchronized static void addMessages(Integer noOfUsers, Integer noOfUsersPerThread, List<User> userList)
            throws InterruptedException {
        for (int i = 0; i < noOfUsers / noOfUsersPerThread; i++) {
            Thread t = new UserBO(userList.subList(i, i + noOfUsersPerThread));
            t.start();
            t.join();
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

class UserBO extends Thread {
    public List<User> userList;
    public static List<String> message = new ArrayList<>();

    public UserBO(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (User u : userList) {
                message.add("The message is sent to the user " + u.getUsername() + " at the mobile number "
                        + u.getMobileNumber());
            }
        }
    }
}