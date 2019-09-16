package lesson1;

import lesson9.Company;

public class FinancialCompany extends Company {
    public FinancialCompany(String name, String countryFounded) {
        super(name, countryFounded);
    }

    public static void main(String[] args) {

    }
    void demonstrateProtectModifier(){
        System.out.println(this.code);
        System.out.println(this.someField);
    }

}
