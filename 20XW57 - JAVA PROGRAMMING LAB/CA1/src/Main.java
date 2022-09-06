import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Assignment a1 = new Assignment("a1", 1,1,1,1);
        a1.setScore(100);
        a1.setTotalPoints(100);
        a1.setTotalWeight(3);

        Assignment a2 = new Assignment("a2", 2,2,2,2);
        a2.setScore(90);
        a2.setTotalPoints(100);
        a2.setTotalWeight(3);

        Lab l = new Lab("l",3,3,3,3,"labSpec");
        l.setScore(70);
        l.setTotalPoints(100);
        l.setTotalWeight(2);


        Project p = new Project("p",4,4,4,4,"projSpec", "projectDataFile");
        p.setScore(100);
        p.setTotalPoints(100);
        p.setTotalWeight(2);


        AssignmentList aList = new AssignmentList();
        aList.addItem(a1);
        aList.addItem(a2);

        aList.addItem(l);
        aList.addItem(p);

        //1
        aList.displayAll();
        //2
        aList.lnpDetails();
        //3
        aList.assignmentsInDayMonth(1,1);
        //4
        aList.assignmentsAboveTotal(70);

        //CourseGrade
        System.out.println("The course grade = " + aList.computeCourseGrade());
    }
}

class Assignment {
    private String name;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private double score;
    private double totalPoints;
    private double totalWeight;

    public Assignment(String name, int month, int day, int hour, int minute) {
        this.name = name;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "name='" + name + '\'' +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", score=" + score +
                ", totalPoints=" + totalPoints +
                ", totalWeight=" + totalWeight +
                '}';
    }
}

class Lab extends Assignment {
    private String specification;

    public Lab(String name, int month, int day, int hour, int minute, String specification) {
        super(name, month, day, hour, minute);
        this.specification = specification;
    }

    @Override
    public String toString() {
        return "LabAssignment{" +
                "name='" + getName() + '\'' +
                ", month=" + getMonth() +
                ", day=" + getDay() +
                ", hour=" + getHour() +
                ", minute=" + getMinute() +
                ", score=" + getScore() +
                ", totalPoints=" + getTotalPoints() +
                ", totalWeight=" + getTotalWeight() +
                "specification='" + specification + '\'' +
                '}';
    }
}

class Project extends Assignment {
    private String specification;
    private String dataFile;

    public Project(String name, int month, int day, int hour, int minute, String specification, String dataFile) {
        super(name, month, day, hour, minute);
        this.specification = specification;
        this.dataFile = dataFile;
    }

    @Override
    public String toString() {
        return "ProjectAssignment{" +
                "name='" + getName() + '\'' +
                ", month=" + getMonth() +
                ", day=" + getDay() +
                ", hour=" + getHour() +
                ", minute=" + getMinute() +
                ", score=" + getScore() +
                ", totalPoints=" + getTotalPoints() +
                ", totalWeight=" + getTotalWeight() +
                "specification='" + specification + '\'' +
                ", dataFile='" + dataFile + '\'' +
                '}';
    }
}

class AssignmentList {
    private ArrayList<Assignment> itemList;

    public AssignmentList() {
        this.itemList = new ArrayList<>();
    }

    public AssignmentList(ArrayList<Assignment> itemList) {
        this.itemList = itemList;
    }


    public void addItem(Assignment a) {
        this.itemList.add(a);
    }

    public double computeCourseGrade() {
        double numerator = 0.00;
        double denominator = 0.00;
        for (int i = 0; i < this.itemList.size(); i++) {
            numerator += this.itemList.get(i).getTotalWeight()*this.itemList.get(i).getScore()/this.itemList.get(i).getTotalPoints();
            denominator += this.itemList.get(i).getTotalWeight();
        }
        return numerator/denominator;
    }

    public void lnpDetails() {
        System.out.println("Lab and project assignment details => {");
        for ( int i = 0; i < this.itemList.size(); i++) {
            if (this.itemList.get(i) instanceof Lab || this.itemList.get(i) instanceof Project) {
                System.out.println("\t" + this.itemList.get(i).toString());
            }
        }
        System.out.println("}");
    }

    public void assignmentsAboveTotal(double total){
        System.out.println("Assignments above a totalPoints of => " + total + " {");
        for ( int i = 0; i < this.itemList.size(); i++) {
            if (this.itemList.get(i).getTotalPoints() > total) {
                System.out.println("\t" + this.itemList.get(i).toString());
            }
        }
        System.out.println("}");
    }

    public void assignmentsInDayMonth(int d, int m) {
        System.out.println("Assignments in Day " + d + " and month " + m + " => {");
        for (int i = 0; i < this.itemList.size(); i++) {
            if(this.itemList.get(i).getDay() == d && this.itemList.get(i).getMonth() == m) {
                System.out.println("\t" + this.itemList.get(i).toString());
            }
        }
        System.out.println("}");
    }

    public void displayAll() {
        System.out.println("All assignment details => {");
        for ( int i = 0; i < this.itemList.size(); i++) {
                System.out.println("\t" + this.itemList.get(i).toString());
        }
        System.out.println("}");
    }
    @Override
    public String toString() {
        return "AssignmentList{" +
                "itemList=" + itemList +
                '}';
    }
}