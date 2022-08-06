public class p2 {
    public static void main(String[] args) {
        int[] countArr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        String str = "The quick brown fox jumps over the lazy dog";
        char[] ch = str.toCharArray();
        for (char i : ch) {
            if (Character.compare(i, ' ') != 0) {
                if (i >= 97) {
                    // System.out.println(i-97);
                    countArr[i - 97]++;
                } else {
                    // System.out.println(i-65);
                    countArr[i - 65]++;
                }
            }
        }
        for (int i = 0; i < countArr.length; i++) {
            System.out.println((char) (i + 65));
            System.out.println(countArr[i]);
        }
    }
}
