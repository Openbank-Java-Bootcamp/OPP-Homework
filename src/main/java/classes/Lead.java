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
        return "Lead Id %s, Name %s, Phone Number %s, Email %s, Company name %s".formatted(leadId, name, phoneNumber, email, companyName);

    }




}
