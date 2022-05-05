package classes;

import enums.Industry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static utils.Utils.*;

//Annotation that adds getters and setters without showing them in file
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    Industry industry;
    int employeeCount;
    String city;
    String country;
    List<Contact> contactList = new ArrayList<>();
    List<Opportunity> opportunityList = new ArrayList<>();
    private String id;

    public Account(Industry industry, int employeeCount, String city, String country) {
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.id = shortUUID();
    }

    public Account(Industry industry, int employeeCount, String city, String country, List<Contact> contactList,
                   List<Opportunity> opportunityList) {
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.contactList = contactList;
        this.opportunityList = opportunityList;
        this.id = shortUUID();
    }


    @Override
    public String toString() {
        return "Account ID %s, industry %s, number of employees %s, country %s, city %s \n %s \n %s".formatted(id,
                industry.toString().toLowerCase(), employeeCount, country, city, contactList.get(0).toString(), opportunityList.get(0).toString());
    }
}
