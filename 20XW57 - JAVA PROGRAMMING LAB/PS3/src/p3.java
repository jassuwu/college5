// import java.lang.*;
// import java.util.*;

public class p3 {
    public static void main(String[] args) {
        String word = "wow you own kayak";
        String[] words = word.split(" ");
        String longestPalindrome = "";
        String smallestPalindrome = "";
        for (String s : words) {
            if (isPalindrome(s)) {
                if (s.length() > longestPalindrome.length()) {
                    longestPalindrome = s;
                }
                if (s.length() < smallestPalindrome.length() || smallestPalindrome.length() == 0) {
                    smallestPalindrome = s;
                }
            }
        }
        System.out.println("Longest palindrome: " + longestPalindrome);
        System.out.println("Smallest palindrome: " + smallestPalindrome);
    }

    public static boolean isPalindrome(String s) {
        boolean flag = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}