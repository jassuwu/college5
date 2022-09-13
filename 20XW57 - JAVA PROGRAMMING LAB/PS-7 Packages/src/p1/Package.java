package p1;
import java.lang.*;
import java.util.*;

public class Package {
    private double weightInOunces;
    private String shippingMethod;
    private double shippingCost;

    public Package(double weightInOunces, String shippingMethod) {
        this.weightInOunces = weightInOunces;
        this.shippingMethod = shippingMethod;
        this.shippingCost = calculateCost(weightInOunces, shippingMethod);
    }

    private double calculateCost(double weightInOunces, String shippingMethod){
        switch (shippingMethod) {
            case "A":
                if (weightInOunces >= 1 && weightInOunces <= 8) {
                    return 2.00;
                } else if (weightInOunces >= 9 && weightInOunces <= 16) {
                    return 3.00;
                } else if (weightInOunces >= 17) {
                    return 4.50;
                }
                break;
            case "T":
                if (weightInOunces >= 1 && weightInOunces <= 8) {
                    return 1.50;
                } else if (weightInOunces >= 9 && weightInOunces <= 16) {
                    return 2.35;
                } else if (weightInOunces >= 17) {
                    return 3.25;
                }
                break;
            case "M":
                if (weightInOunces >= 1 && weightInOunces <= 8) {
                    return 0.50;
                } else if (weightInOunces >= 9 && weightInOunces <= 16) {
                    return 1.50;
                } else if (weightInOunces >= 17) {
                    return 2.15;
                }
                break;
            default:
                System.err.println("Err : Invalid shipping method. Exiting the program.");
                System.exit(1);
        }
        return 0.0;
    }

    public double getWeightInOunces() {
        return weightInOunces;
    }

    public void setWeightInOunces(double weightInOunces) {
        this.weightInOunces = weightInOunces;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void display() {
        System.out.println("Package{" +
                "weightInOunces=" + weightInOunces +
                ", shippingMethod='" + shippingMethod + '\'' +
                ", shippingCost=" + shippingCost +
                '}');
    }
}

