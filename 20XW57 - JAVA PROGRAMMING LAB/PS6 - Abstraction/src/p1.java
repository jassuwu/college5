import java.lang.*;
import java.util.*;

public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your account no. :");
        String accountName = sc.nextLine();
        System.out.println("Enter the balance your account :");
        String balance = sc.nextLine();
        System.out.println("Enter the type of transfer to be made :\1.NEFT\n" +
                "2.IMPS\n" +
                "3.RTGS");
        String type = sc.nextLine();
        System.out.println("Enter the amount to be transferred :");
        String transferAmt = sc.nextLine();

        FundTransfer ft = new IMPSTransfer();

        switch(type) {
            case "1":
                ft = new NEFTTransfer(accountName, Double.valueOf(balance));
                break;
            case "2":
                ft = new IMPSTransfer(accountName, Double.valueOf(balance));
                break;
            case "3":
                ft = new RTGSTransfer(accountName, Double.valueOf(balance));
                break;
            default:
                System.out.println("Enter a valid transfer type.");
                System.exit(1);
        }
        //Validation and transfer
        if(ft.validate(Double.valueOf(transferAmt))){
            if(ft.transfer(Double.valueOf(transferAmt))){
                System.out.println("Transfer occurred successfully.");
            } else {
                System.out.println("Transfer could not be made.");
            }
        }
        else {
            System.out.println("Account number or transfer amount seems to be wrong.");
        }
    }
}

abstract class FundTransfer {
    private String accountName;
    private double balance;

    public FundTransfer() {}

    public FundTransfer(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    boolean validate(Double transfer){
        if (this.accountName.length() == 10 && transfer > 0 && transfer < this.balance ) {
            return true;
        }
        return false;
    }
    abstract boolean transfer(Double transfer);
}

class NEFTTransfer extends FundTransfer {
    public NEFTTransfer() {
    }

    public NEFTTransfer(String accountName, double balance) {
        super(accountName, balance);
    }

    boolean transfer(Double transfer){
        if (1.05*transfer > this.getBalance()){
            this.setBalance(this.getBalance() - 1.05*transfer);
            return true;
        }
        return false;
    }
}

class IMPSTransfer extends FundTransfer {
    public IMPSTransfer() {}

    public IMPSTransfer(String accountName, double balance) {
        super(accountName, balance);
    }

    boolean transfer(Double transfer){
        if (1.02*transfer > this.getBalance()){
            this.setBalance(this.getBalance() - 1.02*transfer);
            return true;
        }
        return false;
    }
}

class RTGSTransfer extends FundTransfer {
    public RTGSTransfer() {}

    public RTGSTransfer(String accountName, double balance) {
        super(accountName, balance);
    }

    boolean transfer(Double transfer){
        if (transfer > 10000){
            this.setBalance(this.getBalance() - transfer);
            return true;
        }
        return false;
    }
}

