package classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact extends Lead {
    private String id;

    public Contact(String name, Long phoneNumber, String email, String companyName, int leadId) {
        super(name, phoneNumber, email, companyName, leadId);
        this.id = UUID.randomUUID().toString();
    }

    public Contact(Lead lead) {
        super(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return ("\n\t ID: %s,\n\t  Name: %s,\n\t  Phone Number: %s,\n\t  Email: %s," +
                "\n\t  Company Name: %s").formatted(id, getName(), getPhoneNumber(), getEmail(), getCompanyName());
    }
}
