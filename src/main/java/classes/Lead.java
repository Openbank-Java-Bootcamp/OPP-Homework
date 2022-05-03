package classes;

public class Lead {
    private String name;
    private Long phoneNumber;
    private String email;
    private String companyName;
    private int leadId;


    //All Fields must be supplied to create the New Lead:
    public Lead(String name, Long phoneNumber, String email, String companyName, int leadId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.leadId = leadId;
    }


    public Lead() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
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


    @Override
    public String toString() {
        return "Lead Id %s, Name %s, Phone Number %s, Email %s, Company name %s".formatted(leadId, name, phoneNumber, email, companyName);

    }




}
