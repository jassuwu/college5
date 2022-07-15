import java.util.Scanner;
public class p2 {
    public static void main(String[] args){
        Scanner intScan = new Scanner(System.in);
        System.out.println("Enter the Amount of Mass: ");
        double mass = intScan.nextDouble();
        System.out.println("Enter the Age in Years: ");
        int age = intScan.nextInt();
        System.out.printf("You entered a mass of %f and an age of %d years.\n\n\n", mass, age);

        for(int i = age; i < age+10; i++)
        {
            System.out.printf("At age %d years, the approximate height of the tree is %f meters.\n",i, Math.pow(i*mass, 1.0/4.0));
        }
        System.out.print("\n");
    }
}
