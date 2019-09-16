package lesson8.accounts;

public class CheckingAccount extends Account {
    int limitOfExpenses;

    public CheckingAccount(String bankName, String ownerName, int moneyAmount, int limitOfExpences) {
        super(bankName, ownerName, moneyAmount);
        this.limitOfExpenses = limitOfExpences;
    }


    void withDraw(int amount) {
        if(amount > limitOfExpenses)
            return;
        moneyAmount -= amount;
    }




}
