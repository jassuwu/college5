package p2;
import java.lang.*;
import java.util.*;

public class Person {
    private String name;
    private String gender;
    private Date DOB;
    private String phnNo;
    private String email;

    public Person(String name, String gender, Date DOB, String phnNo, String email) {
        this.name = name;
        this.gender = gender;
        this.DOB = DOB;
        this.phnNo = phnNo;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getPhnNo() {
        return phnNo;
    }

    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return " Person{" +
                "\n\t\tname='" + name + '\'' +
                ",\n\t\tgender='" + gender + '\'' +
                ",\n\t\tDOB=" + DOB +
                ",\n\t\tphnNo='" + phnNo + '\'' +
                ",\n\t\temail='" + email + '\'' +
                "\n\t}";
    }
}
