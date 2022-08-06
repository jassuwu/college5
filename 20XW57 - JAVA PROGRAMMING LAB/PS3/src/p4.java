public class p4 {
    public static void main(String[] args) {
        String s = "parliament";
        String s2 = "partial men";
        System.out.print(isAnagram(s, s2));
    }

    public static boolean isAnagram(String s, String s2) {
        for (char i : s.toCharArray()) {
            boolean flag = false;
            if (Character.isLetter(i)) {
                for (char j : s2.toCharArray()) {
                    if (i == j) {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
