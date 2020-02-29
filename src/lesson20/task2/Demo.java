package lesson20.task2;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Transaction transaction = new Transaction(1234343444, "Kiev", 1000, "Some", TransactionType.INCOME, new Date());
        Transaction transaction1 = new Transaction(123434356, "Odessa", 1000, "Some", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(1234434667, "Lviv", 1000, "Some", TransactionType.INCOME, new Date());
        TransactionDAO transactionDAO = new TransactionDAO();
       try { ;
       transactionDAO.save(transaction1);
       transactionDAO.save(transaction2);}
       catch (Exception e){
           System.out.println(e.getMessage());
       }
    }
}
