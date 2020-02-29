package lesson21;

public class Demo {
    public static void main(String[] args) throws Exception {
        Company company = new Company(100, "Nokia");
        Company.setLicence("GTP999");

        System.out.println(company.getLicence());

        Company company1 = new Company(99, "Test");

        System.out.println(company1.getLicence());

        company.setLicence("TTT111");
        System.out.println(company.getLicence());
        System.out.println(company1.getLicence());


        // utils

        ArrayUtils.minElement(new int[]{1,3,5});


    }
}
