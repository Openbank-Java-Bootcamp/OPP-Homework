package classes;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OpportunityTest {
    private Lead lead;
    private Opportunity opportunity;

    @BeforeAll
    public void SetUp(){
        Lead lead = new Lead();
        Opportunity opportunity = new Opportunity();
    }

   /* @org.junit.jupiter.api.Test
    void createOpportunity(Lead lead) {
        assertEquals(opportunity, createOpportunity(this.lead));
    }*/

}