import java.lang.*;
import java.util.*;

public class p7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount for withdrawal: ");
        double amount = sc.nextDouble();
        try {
            if (validate(amount)) {
                System.out.println("Amount withdrawn successfully.");
            }
        } catch (MinimumAccountBalance e) {
            System.err.println("Caught " + e);
        }
    }

    public static boolean validate (double amt) throws MinimumAccountBalance{
        if (amt > -1 && amt < 25001) {
            return true;
        }
        else {
            throw new MinimumAccountBalance("Minimum Account Balance Exception");
        }
    }
}

class MinimumAccountBalance extends Exception {
    public MinimumAccountBalance(String message) {
        super(message);
    }
}