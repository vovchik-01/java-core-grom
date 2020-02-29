package lesson19.hw;

public class Demo {
    public static void main(String[] args) {

        try {
            File file1 = new File(78293874, "Vnovich", "jpg", 2333);
        }
        catch (Exception e){
            e.getMessage();
        }

    }
}
