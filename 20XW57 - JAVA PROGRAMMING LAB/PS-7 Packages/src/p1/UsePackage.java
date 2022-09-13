package p1;
import java.lang.*;
import java.util.*;


public class UsePackage {
    public static void main(String[] args)
    {
        Package p1 = new Package(10.00, "A");
        Package p2 = new Package(20.00, "T");
        Package p3 = new Package(30.00, "M");

        InsuredPackage ip1 = new InsuredPackage(10.00, "A");
        InsuredPackage ip2 = new InsuredPackage(20.00, "T");
        InsuredPackage ip3 = new InsuredPackage(30.00, "M");

        p1.display();
        p2.display();
        p3.display();

        ip1.display();
        ip2.display();
        ip3.display();

        System.exit(0);
    }
}
