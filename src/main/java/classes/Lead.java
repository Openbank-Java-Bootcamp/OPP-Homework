package classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lead {
    private String name;
    private Long phoneNumber;
    private String email;
    private String companyName;
    private int leadId;

    public Lead(String name, Long phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return ("Lead ID %s, \n Name: %s, \n Phone Number: %s, " +
                "\n Email: %s, \n Company name: %s \n").formatted(leadId, name, phoneNumber, email, companyName);

    }




}
