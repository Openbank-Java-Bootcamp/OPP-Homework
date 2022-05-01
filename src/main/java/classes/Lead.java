package classes;

import java.util.ArrayList;
import java.util.List;

public class Lead {
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    private int leadId;
    private int counterId = 0;

    List<Lead> leadList = new ArrayList<>();

    //All Fields must be supplied to create the New Lead:
    public Lead(String name, String phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        setLeadId(++counterId);
    }
    public Lead(String name, String phoneNumber, String email, String companyName, int leadId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        setLeadId(++counterId);
        this.leadList= leadList;
    }

    public Lead() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getLeadId() {
        return leadId;
    }

    public void setLeadId(int leadId) {
        this.leadId = leadId;
    }

    public List getLeadList(){
        return leadList;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", counterId=" + counterId +
                '}';
    }
}
