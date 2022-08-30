import java.lang.*;
import java.util.*;

public class p1 {
    public static void main(String[] args) {
        Visit v = new Visit("name", new Date(2000, 1, 1));
        DiscountRate dr = new DiscountRate();
        System.out.println(v.toString());
        System.out.println(dr.getProductDiscountRate("Premium"));
        System.out.println(dr.getProductDiscountRate("Gold"));
        System.out.println(dr.getProductDiscountRate("Silver"));
        System.out.println(dr.getServiceDiscountRate("Premium"));
        System.out.println(dr.getServiceDiscountRate("Gold"));
        System.out.println(dr.getServiceDiscountRate("Silver"));
    }
}

class Customer {
    private String name;
    private boolean member=false;
    private String memberType;
    public Customer(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public boolean isMember(){
        return this.member;
    }
    public void setMember(boolean member){
        this.member = member;
    }
    public String getMemberType() {
        return this.memberType;
    }
    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
    public String toString(){
        return this.name + " is a member= " + this.member + " of the type= " + this.memberType;
    }
}

class Visit {
    private Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    public Visit(String name, Date date) {
        customer = new Customer(name);
        this.date = date;
    }

    public String getName() {
        return customer.getName();
    }

    public double getServiceExpense() {
        return this.serviceExpense;
    }

    public double getProductExpense() {
        return this.productExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        return this.getProductExpense() + this.getServiceExpense();
    }
    public String toString() {
        return this.customer.toString() + " had a total expense of " + this.getTotalExpense() + " on " + this.date + ". ";
    }
}

class DiscountRate {
    private double serviceDiscountPremium=0.2;
    private double serviceDiscountGold=0.15;
    private double serviceDiscountSilver=0.1;
    private double productDiscountPremium=0.1;
    private double productDiscountGold=0.1;
    private double productDiscountSilver=0.1;

    public double getServiceDiscountRate(String type) {
        switch(type) {
            case "Premium":
                return serviceDiscountPremium;
            case "Gold":
                return serviceDiscountGold;
            case "Silver":
                return serviceDiscountSilver;
            default:
                return 0;
        }
    }

    public double getProductDiscountRate(String type) {
        switch(type) {
            case "Premium":
                return productDiscountPremium;
            case "Gold":
                return productDiscountGold;
            case "Silver":
                return productDiscountSilver;
            default:
                return 0;
        }
    }
}

