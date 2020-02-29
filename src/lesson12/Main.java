package lesson12;

public class Main {
    public static void main(String[] args) {
        Bank euBank = new USBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);
        User user = new User(1001, "Denis", 12200, 40, "GMD", 1500, euBank);
        User user1 = new User(1002, "Ivan", 15000, 30, "IBM", 1300, euBank);
        BankSystem bankSystem = new UkrainianBankSystem();
        bankSystem.withdraw(user, 150);
        System.out.println(user.getBalance());
        bankSystem.paySalary(user);
        System.out.println(user.getBalance());
        bankSystem.fund(user, 100);
        System.out.println(user.getBalance());
        bankSystem.transferMoney(user, user1, 500);
        System.out.println(user.getBalance());
        System.out.println(user1.getBalance());
    }
}
