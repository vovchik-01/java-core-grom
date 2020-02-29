package lesson20.task2Duplicate;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;

public class Controller {
    private static TransactionDAO transactionDAO = new TransactionDAO();

    public static Transaction save(Transaction transaction) throws Exception {
        return transactionDAO.save(transaction);
    }

    public static Transaction[] transactionList() throws InternalServerException {
        return transactionDAO.transactionList();
    }

    public static Transaction[] transactionList(String city) throws BadRequestException {
        return transactionDAO.transactionList(city);
    }

    public static Transaction[] transactionList(int amount) throws BadRequestException {
        return transactionDAO.transactionList(amount);
    }
}
