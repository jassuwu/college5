import java.lang.*;
import java.util.*;

public class p3 {
    public static void main(String[] args) {

        // No exceptions thrown in this case
        try {
            ContactDetail cd1 = new ContactDetail("123123","123124","ll1","mail1", "a1");
            ContactDetailBO.validate(cd1.getMobile(), cd1.getAlternateMobile());
        } catch (DuplicateMobileNumberException e) {
            System.err.println(e);
        }

        // Exception thrown in this case
        try {
            ContactDetail cd2 = new ContactDetail("123124","123124","ll2","mail2", "a2");
            ContactDetailBO.validate(cd2.getMobile(), cd2.getAlternateMobile());
        } catch (DuplicateMobileNumberException e) {
            System.err.println(e);
        }
    }
}

class ContactDetail {
    private String mobile;
    private String alternateMobile;
    private String landline;
    private String email;
    private String address;

    public ContactDetail() {
    }

    public ContactDetail(String mobile, String alternateMobile, String landline, String email, String address) {
        this.mobile = mobile;
        this.alternateMobile = alternateMobile;
        this.landline = landline;
        this.email = email;
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAlternateMobile() {
        return alternateMobile;
    }

    public void setAlternateMobile(String alternateMobile) {
        this.alternateMobile = alternateMobile;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\nContactDetail{" +
                "\n\tmobile='" + mobile + '\'' +
                ",\n\talternateMobile='" + alternateMobile + '\'' +
                ",\n\tlandline='" + landline + '\'' +
                ",\n\temail='" + email + '\'' +
                ",\n\taddress='" + address + '\'' +
                "\n}";
    }
}


class ContactDetailBO{
    static void validate(String mobile, String alternateMobile) throws DuplicateMobileNumberException {
        if(mobile == alternateMobile){
            throw new DuplicateMobileNumberException("The mobile number and the alternate mobile number are the same => " + mobile + ".");
        }
        else return;
    }
}

class DuplicateMobileNumberException extends Exception {
    public DuplicateMobileNumberException(String message) {
        super(message);
    }
}
