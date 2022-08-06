import java.util.*;

public class p7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String correct = sc.nextLine();
        String input = sc.nextLine();
        sc.close();
        int wrongCount = 0;
        for (int i = 0; i < correct.length(); i++) {
            if (correct.charAt(i) != input.charAt(i)) {
                wrongCount++;
            }
        }

        if (wrongCount >= 3) {
            System.out.println("WRONG.");
        } else if (wrongCount >= 1) {
            System.out.println("ALMOST CORRECT.");
        } else {
            System.out.println("CORRECT.");
        }
    }
}
