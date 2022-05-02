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

    public Contact(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Contact id %s, name %s, phone number %s, email %s, company name %s".formatted(id,
                 getName(), getPhoneNumber(), getEmail(),getCompanyName());
    }
}
