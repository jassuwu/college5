
//Hangman by 20PW14
import java.util.Scanner;

public class p10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = { "apple", "banana", "orange", "pear", "grape", "strawberry", "watermelon", "pineapple",
                "mango", "cherry", "lemon", "lime", "coconut", "avocado", "tomato", "eggplant", "pepper", "onion",
                "garlic", "potato", "carrot", "broccoli", "cucumber", "mushroom", "corn", "artichoke", "asparagus",
                "broccoli", "cauliflower", "celery", "corn", "cucumber", "eggplant", "green bean", "leek", "onion",
                "pea", "pepper", "potato", "radish", "squash", "tomato", "zucchini" };
        String word = words[(int) (Math.random() * words.length)];
        // String word = words[0];
        String unique = "";
        for (int i = 0; i < word.length(); i++) {
            if (!unique.contains(word.substring(i, i + 1))) {
                unique += word.substring(i, i + 1);
            }
        }
        // char[] wordArray = word.toCharArray();
        String correct = "";
        int wrongCount = 0;
        while (!isGameOver(unique, correct)) {
            for (int i = 0; i < word.length(); i++) {
                if (correct.indexOf(word.charAt(i)) >= 0) {
                    System.out.print(word.charAt(i));
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
            System.out.print("Enter you guess : ");
            String guess = sc.nextLine();
            if (unique.contains(guess)) {
                System.out.println("That was a correct guess.");
                correct += guess;
            } else {
                System.out.println("That was a wrong guess.");
                wrongCount++;
            }
        }
        System.out.println("You have missed " + wrongCount + " times.");
        System.out.println("GGS.");
        sc.close();
    }

    public static boolean isGameOver(String uniq, String correct) {
        for (int i = 0; i < uniq.length(); i++) {
            if (correct.indexOf(uniq.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
        // return false;
    }
}
