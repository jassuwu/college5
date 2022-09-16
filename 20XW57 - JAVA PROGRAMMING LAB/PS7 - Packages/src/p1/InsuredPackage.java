package p1;

import java.lang.*;
import java.util.*;

public class InsuredPackage extends Package {
    private double insuranceCost = 0.0;

    public InsuredPackage(double weightInOunces, String shippingMethod) {
        super(weightInOunces, shippingMethod);
        this.insuranceCost = this.calculateInsCost(this.getShippingCost());
    }

    private double calculateInsCost(double shippingCost) {
        if (shippingCost >= 0 && shippingCost <= 1.00) {
            return 2.45;
        } else if (shippingCost >= 1.01 && shippingCost <= 3.00) {
            return 3.95;
        } else if (shippingCost >= 3.00) {
            return 5.55;
        } else {
            return 0.00;
        }
    }

    @Override
    public void display() {
        System.out.println("Package{" +
                "weightInOunces=" + this.getWeightInOunces() +
                ", shippingMethod='" + this.getShippingMethod() + '\'' +
                ", shippingCost=" + this.getShippingCost() +
                ", insuranceCost=" + insuranceCost +
                '}');
    }
}