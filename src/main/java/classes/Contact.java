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
        return "Contact id %s, name %s, phone number %s, email %s, company name %s".formatted(id,
                getName(), getPhoneNumber(), getEmail(), getCompanyName());
    }
}
