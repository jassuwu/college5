import java.util.Scanner;

public class p9 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int len = str.length();
        String[] arr = new String[len];
        String lastChar = "";
        arr = str.split("");
        if( len%2 == 1){
            lastChar = arr[arr.length-1];
            len--;
        }
        String rollNo = "";
        String maxOfTwo = "";
        for( int i = 0; i < len; i=i+2){
            if ( Integer.parseInt(arr[i]) >= Integer.parseInt(arr[i+1]) ) {
                rollNo = rollNo + arr[i];
            }
            else {
                rollNo = rollNo + arr[i+1];
            }
        }
        if ( len != str.length()) {
            rollNo = rollNo + lastChar;
        }
        System.out.println(rollNo);

    }
}