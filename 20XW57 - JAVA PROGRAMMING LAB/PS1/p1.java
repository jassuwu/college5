import java.util.Scanner;
public class p1 {
    public static void main(String[] args){
        Scanner intScan = new Scanner(System.in);
        System.out.println("Enter the Average Wind Speed (in m/s): ");
        double windSpeed = intScan.nextDouble();
        System.out.println("Enter the Operating Efficiency [0...1]:");
        double opEff = intScan.nextDouble();
        System.out.println("Enter the Blade Radius (in meters): ");
        double bladeRad = intScan.nextDouble();
        System.out.printf("You entered an Average Wind Speed of %f m/s.\nYou entered an Operating Efficiency of %f (%f%%).\nYou entered a Blade Radius of %f meters.",windSpeed, opEff, opEff*100, bladeRad);
        double maxPower = 0.5* 1.2 * Math.PI*bladeRad*bladeRad * windSpeed*windSpeed*windSpeed;
        System.out.printf("\nThe Maximum Power is %f W and the Actual Power is %f W.", maxPower, maxPower*opEff);
        System.out.print("\n");
    }
}
