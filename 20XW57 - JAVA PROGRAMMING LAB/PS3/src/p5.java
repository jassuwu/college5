public class p5 {
    public static void main(String[] args) {
        // Insert asterisk between each character in the string
        String s = "hellloommggwwhhaatt";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                System.out.print("*");
            }
        }
    }
}
