package lesson9;

import lesson9.utils.Checker;

public class Demo {
    public static void main(String[] args) {
        Company company = new Company("someCompany", "Ukraine");
        //System.out.println(company.countryFounded);
        System.out.println(company.getName());
        System.out.println(company.getCountryFounded());

        //company.name = "newValue";

        //company.name = "IBM";
        Checker checker = new Checker();
        //System.out.println(checker.checkCompanyName(company.name));

        //System.out.println(checker.companyNamesValidatedCount);






    }
}
