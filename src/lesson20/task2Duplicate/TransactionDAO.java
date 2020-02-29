package lesson20.task2Duplicate;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {

    private  Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();


    public Transaction save(Transaction transaction) throws Exception {
        if (transaction == null) {
            throw new BadRequestException("Can not save null transaction");
        }


        for (Transaction tr : transactions) {
            if (tr != null && tr.equals(transaction)) {
                throw new BadRequestException("Transaction " + transaction.getId() + "is already exist");
            }
        }
        int index = 0;
        if (validate(transaction)) {
            for (Transaction transaction1 : transactions) {
                if (transaction1 == null) {
                    transactions[index] = transaction;
                    return transactions[index];
                }
                index++;
            }
        }
        throw new InternalServerException("Can not saved transaction " + transaction.getId());
    }


    private  boolean validate(Transaction transaction) throws Exception {
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed. " + transaction.getId() + " can't be saved.");

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }
        if (sum + transaction.getAmount() > utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Transaction limit per day amount exceed. " + transaction.getId() + " can't be saved.");
        }

        if (count + 1 > utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Transaction limit per day count exceed. " + transaction.getId() + " can't be saved.");
        }

        int checkCity = 0;
        for (String correctCity : utils.getCities()) {
            if (transaction.getCity().equals(correctCity)) {
                checkCity++;
            }
        }
        if (checkCity != 1) {
            throw new BadRequestException("Transaction city: " + transaction.getCity() + "not allowed. " + transaction.getId() + "Can't be saved");
        }

        for (Transaction transaction1 : transactions) {
            if (transaction1 == null) {
                return true;
            }
        }

        throw new InternalServerException("Transaction: " + transaction.getId() + "can't be saved. Out of space.");

    }


    public Transaction[] transactionList() {
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                result[index] = transaction;
                index++;
            }

        }
        return result;
    }


    public Transaction[] transactionList(String city) throws BadRequestException {
        if (city == null) {
            throw new BadRequestException("City can't be null");
        }
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(city)) {
                count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getCity().equals(city)) {
                result[index] = transaction;
                index++;
            }

        }
        return result;
    }

    Transaction[] transactionList(int amount) {
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
                count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getAmount() == amount) {
                result[index] = transaction;
                index++;
            }

        }
        return result;
    }


    private Transaction[] getTransactionPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }
        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }


        }
        return result;
    }
}
