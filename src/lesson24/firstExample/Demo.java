package lesson24.firstExample;

public class Demo <T>{


    private static void calculatePrise(AbstractOrder abstractOrder){
        System.out.println(abstractOrder.getPrice());
    }

//    private static void calculatePrise(SecondOrder secondOrder){
//        System.out.println(secondOrder.getPrice());
//    }


    public void print (T t){
        System.out.println(t);
    }



    public static void main(String[] args) {
        calculatePrise(new FirstOrder());
        calculatePrise(new SecondOrder());
    }
}
