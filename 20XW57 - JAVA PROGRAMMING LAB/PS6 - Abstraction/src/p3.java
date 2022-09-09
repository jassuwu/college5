import java.lang.*;
import java.util.*;
import java.text.*;


public class p3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Current Account\n2. Savings Account\n");
        String choice = sc.nextLine();
        System.out.println("Name");
        String name = sc.nextLine();
        System.out.println("Account Number");
        String acNo = sc.nextLine();
        System.out.println("Account Balance");
        String balance = sc.nextLine();
        System.out.println("Enter the start date");
        String start = sc.nextLine();
        System.out.println("Enter the end date");
        String end = sc.nextLine();

        Account a = null;
        try {
            switch(choice){
                case "1":
                    a = new CurrentAccount(name, Integer.parseInt(acNo), Integer.parseInt(balance), new SimpleDateFormat("yyyy-MM-dd").parse(start));
                    break;
                case "2":
                    a = new SavingsAccount(name, Integer.parseInt(acNo), Integer.parseInt(balance), new SimpleDateFormat("yyyy-MM-dd").parse(start));
                    break;
                default:
                    System.out.println("Enter a valid account type.");
                    System.exit(1);
            }
            System.out.println("Account interest :" + a.calculateInterest(new SimpleDateFormat("yyyy-MM-dd").parse(end)));
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }
}



abstract class Account {
    private String name;
    private int number;
    private int balance;
    private Date startDate;

    public Account(String name, int number, int balance, Date startDate) {
        this.name = name;
        this.number = number;
        this.balance = balance;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int monthsDifference(Date startDate, Date endDate){
        Calendar c1 = new GregorianCalendar();
        c1.setTime(startDate);
        Calendar c2 = new GregorianCalendar();
        c2.setTime(endDate);
        int ans = (c2.get(c2.YEAR) - c1.get(c1.YEAR))*12;
        ans += c2.get(c2.MONTH)-c1.get(c1.MONTH);
        return ans;
    }

    abstract public double calculateInterest(Date dueDate);
}

class SavingsAccount extends Account {
    private double interestPercent=0.12;

    public SavingsAccount(String name, int number, int balance, Date startDate) {
        super(name, number, balance, startDate);
    }

    public double getInterestPercent() {
        return interestPercent;
    }

    public void setInterestPercent(double interestPercent) {
        this.interestPercent = interestPercent;
    }

    @Override
    public double calculateInterest(Date dueDate) {
        return this.getBalance()*this.getInterestPercent()*monthsDifference(this.getStartDate(), dueDate);
    }
}

class CurrentAccount extends Account {
    private double interestPercent=0.05;

    public CurrentAccount(String name, int number, int balance, Date startDate) {
        super(name, number, balance, startDate);
    }

    public double getInterestPercent() {
        return interestPercent;
    }

    public void setInterestPercent(double interestPercent) {
        this.interestPercent = interestPercent;
    }

    @Override
    public double calculateInterest(Date dueDate) {
        return this.getBalance()*this.getInterestPercent()*monthsDifference(this.getStartDate(), dueDate);
    }
}