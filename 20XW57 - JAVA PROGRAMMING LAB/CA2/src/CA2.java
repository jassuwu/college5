import java.lang.*;
import java.util.*;

public class CA2 {
    public static void main(String[] args) {
        // Make a new bank
        Bank b = new Bank("JAVA");
        System.out.println("Made new bank.");

        // Make an account
        Account a = new Account("A", "01");
        System.out.println("Made new account.");

        //Account details before deposit
        System.out.println("Account details before deposit: ");
        System.out.println(a);

        //Withdrawing from 0 balance to check the exception handling
        //Works as intended. Uncomment to check.
//        try {
//            Thread wt = new Thread(new Withdrawer(a, 1.0), "Withdrawer");
//            wt.start();
//            wt.join();
//        } catch (InterruptedException e) {
//            System.err.println("INTERRUPTED EXCEPTION IN THE CHECKING WITHDRAW => " + e);
//        }

        //Randomly adding amounts to check the deposits
        double thisDeposit=0.0;
        double totalAmountDeposited = 0.0;
        for(int i = 0; i < 1000; i++) {
            thisDeposit = Math.floor(Math.random() * 1000 + 1);
            totalAmountDeposited += thisDeposit;
            try {
                Thread dt = new Thread(new Depositor(a, thisDeposit), "Depositor");
                dt.start();
                dt.join();
            } catch (InterruptedException e) {
                System.err.println(e.getStackTrace());
            }
        }

        //Account details after deposit
        System.out.println("Account details after deposit: ");
        System.out.println(a);
        System.out.println(totalAmountDeposited);
        if(a.getBalance().equals(totalAmountDeposited)) {
            System.out.println("The balances add up. All the deposits were made separately. The balance is consistent.");
        }
        else {
            System.out.println("Where did everything go wrong? :(");
        }
    }
}

class Depositor implements Runnable {
    private Account Acc;
    private Double amountToBeDeposited;

    public Depositor(Account Acc, Double amountToBeDeposited) {
        this.Acc = Acc;
        this.amountToBeDeposited = amountToBeDeposited;
    }

    @Override
    public void run() {
        try {
            deposit();
        } catch (Exception e) {
            System.err.println("ERROR IN DEPOSIT => " + e);
        }
    }

    private void deposit() {
        synchronized (Acc) {
            System.out.println("Depositing " + this.amountToBeDeposited + " to " + this.Acc.getName() + "'s account.");
            this.Acc.setBalance(this.Acc.getBalance() + this.amountToBeDeposited);
            System.out.println("Deposit successful");
        }
    }

}

class Withdrawer implements Runnable {
    private Account Acc;
    private Double amountToBeWithdrawn;

    public Withdrawer(Account Acc, Double amountToBeWithdrawn) {
        this.Acc = Acc;
        this.amountToBeWithdrawn = amountToBeWithdrawn;
    }

    @Override
    public void run() {
        try {
            if(withdraw()) {
                System.out.println("Withdrew " + this.amountToBeWithdrawn + " from " + this.Acc.getName() + ". Current Balance: " + this.Acc.getBalance() + ".");
            }
        } catch (NotEnoughFundsException e) {
            System.err.println("you broke ig => " + e);
        } catch (Exception e) {
            System.err.println("ERROR IN WITHDRAWAL => "+ e);
        }
    }

    private boolean withdraw() throws NotEnoughFundsException {
        synchronized (Acc) {
            System.out.println("Withdrawing " + this.amountToBeWithdrawn + " from " + this.Acc.getName() + "'s account.");
            if (this.Acc.getBalance() >= this.amountToBeWithdrawn) {
                this.Acc.setBalance(this.Acc.getBalance() - this.amountToBeWithdrawn);
                return true;
            } else {
                throw new NotEnoughFundsException("BRO, NO FUNDS!");
            }
        }
    }
}

class Bank {
    private String name;
    private List<Account> accountsList;

    public Bank() {
    }

    public Bank(String name) {
        this.name = name;
        this.accountsList = new ArrayList<Account>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(List<Account> accountsList) {
        this.accountsList = accountsList;
    }
}

class Account {
    private String name;
    private String accNo;
    private Double balance;

    public Account() {
    }

    public Account(String name, String accNo) {
        this.name = name;
        this.accNo = accNo;
        this.balance = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", accNo='" + accNo + '\'' +
                ", balance=" + balance +
                '}';
    }
}


class NotEnoughFundsException extends Exception {
    public NotEnoughFundsException (String message) {
        super(message);
    }
}