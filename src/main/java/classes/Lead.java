package classes;

public class Lead {
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    private int counterID;

    //All Fields must be supplied to create the New Lead:
    public Lead(String name, String phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        setCounterID(counterID);
    }

    public Lead() {

    }


    public Lead getName() {
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

    public int getCounterID() {
        return counterID;
    }

    //TODO: system should automatically create an Id for the Lead (counter)
    public void setCounterID(int counterID) {
        counterID = 0;
        this.counterID = counterID;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", counterID=" + counterID +
                '}';
    }
}
