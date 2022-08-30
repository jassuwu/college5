import java.lang.*;
import java.util.*;

public class p2 {
    public static void main(String[] args) {
        Teacher t = new Teacher("T1", "tName", "tSubj", "tPubl");
        System.out.println(t.toString());
        Regular r = new Regular("R1", "rName", 69.69);
        System.out.println(r.toString());
        Casual c = new Casual("C1", "cName", 69.69, 69.69);
        System.out.println(c.toString());
        Officer o = new Officer("O1", "oName", "A");
        System.out.println(o.toString());
    }
}

class Staff{
    private String code;
    private String name;

    public Staff(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

class Teacher extends Staff {

    private String subject;
    private String publication;

    public Teacher(String code, String name, String subject, String publication) {
        super(code, name);
        this.subject = subject;
        this.publication = publication;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                ", publication='" + publication + '\'' +
                '}';
    }
}

class Typist extends Staff {
    private double speed;


    public Typist(String code, String name, double speed) {
        super(code, name);
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Typist{" +
                "speed=" + speed +
                '}';
    }
}

class Regular extends Typist {

    public Regular(String code, String name, double speed) {
        super(code, name, speed);
    }

    @Override
    public String toString() {
        return "Regular{}";
    }
}

class Casual extends Typist {
    private double dailyWages;

    public Casual(String code, String name, double speed, double dailyWages) {
        super(code, name, speed);
        this.dailyWages = dailyWages;
    }

    public double getDailyWages() {
        return dailyWages;
    }

    public void setDailyWages(double dailyWages) {
        this.dailyWages = dailyWages;
    }

    @Override
    public String toString() {
        return "Casual{" +
                "dailyWages=" + dailyWages +
                '}';
    }
}

class Officer extends Staff {
    private String grade;

    public Officer(String code, String name, String grade) {
        super(code, name);
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Officer{" +
                "grade='" + grade + '\'' +
                '}';
    }
}
