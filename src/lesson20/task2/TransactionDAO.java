package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();


    public Transaction save(Transaction transaction) throws Exception {
        if (transaction == null){
            throw new BadRequestException("Can not save null transaction");
        }
        for (Transaction tr : transactions) {
            if (!equals(tr)) {
                throw new Exception("Duplicate " + transaction.getId() + " Can't save.");
            }
        }
        for (Transaction tr1 : transactions) {
            validate(tr1);
        }


//        if (equals(transaction)) {
//            throw new Exception("Duplicate " + transaction.getId() + " Can't save.");
//        }
//        try {
//            validate(transaction);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        int index = 0;
        for (Transaction transaction1 : transactions) {
            if (transaction1 == null) {
                transactions[index] = transaction;
                return transactions[index];
            }
            index++;
        }

        throw new LimitExceeded("Transaction: " + transaction.getId() + "can't be saved. Out of space.");
    }

    private void validate(Transaction transaction) throws Exception {
        // сумма транзакци больше указанного лимита +
        //сумма транзакции за день больше дневного лимита +
        //количество транзакций за день больше указанного лимита +
        // если город оплаты (совершения транзакции) не разрешен -
        //  не хватило места выбрасываем интернал сервер эксептион


        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount()) {
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be saved");
        }
        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }
        if (sum + transaction.getAmount() > utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can't be saved");
        }
        if (count + 1 > utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can't be saved");
        }

        for (String correctCity : utils.getCities()) {
            if (!transaction.getCity().equals(correctCity)) {
                throw new BadRequestException("Transaction city: " + transaction.getCity() + "not allowed. " + transaction.getId() + "Can't be saved");
            }
        }
        int countTransactions = 0;
        for (Transaction transaction1 : transactions) {
            if (transaction1 != null) {
                countTransactions++;
            }
        }
        if (countTransactions >= transactions.length) {
            throw new InternalServerException("Transaction: " + transaction.getId() + "can't be saved. Out of space.");
        }


    }

    public Transaction[] transactionList() {
        return transactions;
    }

    public Transaction[] transactionList(String city) {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getCity().equals(city)) {
                count++;
            }
        }
        Transaction[] res = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            for (Transaction transaction1 : res) {
                if (transaction.getCity().equals(city)) {
                    res[index] = transaction;
                    return res;
                }
                index++;
            }


        }
        return null;
    }

    public Transaction[] transactionList(int amount) {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() == amount) {
                count++;
            }
        }
        Transaction[] res = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            for (Transaction transaction1 : res) {
                if (transaction.getAmount() == amount) {
                    res[index] = transaction;
                    return res;
                }
                index++;
            }


        }
        return null;
    }


    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(calendar.MONTH);
        int day = calendar.get(calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(calendar.MONTH);
                int trDay = calendar.get(calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    count++;
                }

            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(calendar.MONTH);
                int trDay = calendar.get(calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }


        return result;

    }


}
