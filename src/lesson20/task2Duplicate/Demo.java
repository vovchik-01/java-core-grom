package lesson20.task2Duplicate;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {
        Transaction transaction = new Transaction(123, "Kiev", 10, "Some", TransactionType.INCOME, new Date());
        Transaction transaction1 = new Transaction(1234, "Kiev", 5, "Some", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(1235, "Kiev", 5, "Some", TransactionType.INCOME, new Date());
        Transaction transaction3 = new Transaction(1236, "Kiev", 5, "Some", TransactionType.INCOME, new Date());
        Transaction transaction4 = new Transaction(1237, "Kiev", 5, "Some", TransactionType.INCOME, new Date());
        Transaction transaction5 = new Transaction(1238, "Kiev", 5, "Some", TransactionType.INCOME, new Date());
        Transaction transaction6 = new Transaction(1239, "Kiev", 5, "Some", TransactionType.INCOME, new Date());
        Transaction transaction7 = new Transaction(1230, "Kiev", 5, "Some", TransactionType.INCOME, new Date());
        Transaction transaction8 = new Transaction(1231, "Kiev", 5, "Some", TransactionType.INCOME, new Date());
        Transaction transaction9 = new Transaction(12322, "Kiev", 5, "Some", TransactionType.INCOME, new Date());


        TransactionDAO transactionDAO = new TransactionDAO();
        Controller controller = new Controller();

        System.out.println(Controller.save(transaction8));
        System.out.println(Controller.save(transaction9));

        System.out.println(Arrays.toString(Controller.transactionList()));
        System.out.println(Arrays.toString(Controller.transactionList(10)));
        System.out.println(Arrays.toString(Controller.transactionList("Kiev")));


    }
}
