import java.lang.*;
//import java.util.Scanner;
//name of the class should be FooCorporation ( mentioned in the question ).
public class p6 {
    //Declaration of class-wide constants
    static final double minimumWage = 8.0;
    static final int maxHours = 60;

    //main function to call the calculations
    public static void main(String[] args) {
        salaryCalculation(7.50, 35);
        salaryCalculation(8.20, 47);
        salaryCalculation(10.00, 73);
    }
    
    //method for salaryCalculation
    public static void salaryCalculation(double basePay, int hoursWorked){
        double totalSalary = 0;
        if ((basePay < minimumWage) || (hoursWorked > maxHours)){
            System.out.println("ERROR BRO.");
        }
        else {
            if (hoursWorked > 40){
                totalSalary = basePay * 40 + 1.5*basePay*(hoursWorked - 40);
            }
            else {
                totalSalary = basePay * hoursWorked;
            }
            System.out.println("TOTAL SALARY = " + totalSalary + ".");
        }
    }
}
