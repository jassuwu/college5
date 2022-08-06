import java.util.Scanner;

public class p9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nk = sc.nextLine().split(" ");
        String[] tokens = sc.nextLine().split(" ");

        String[] result = new String[] { "NO", "NO" };

        for (int i = 0; i < Integer.parseInt(nk[1]); i++) {
            String[] tokens2 = sc.nextLine().split(" ");
            for (int j = 0; j < tokens2.length; j++) {
                for (int k = 0; k < tokens.length; k++) {
                    if (tokens2[j].equals(tokens[k])) {
                        result[k] = "YES";
                    }
                }
            }
        }
        System.out.println(result[0] + " " + result[1]);
        sc.close();
    }
}
