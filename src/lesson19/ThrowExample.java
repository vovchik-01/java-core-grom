package lesson19;

public class ThrowExample {
    private static String[] array = {"test", "test1", null, "test2", "test3", "test4"};


    public static void main(String[] args) {
        // test();
        useOfTestMethod();
    }


    private static void test() throws Exception {
        for (String element : array) {
            if (element == null) {
                throw new Exception("null is detected");
            }
        }
        System.out.println("Done");
    }

    private static void useOfTestMethod() {
        try {
            test();
        } catch (Exception e) {
            System.out.println("Error" + " - " + e.getMessage());
        }
    }
}
