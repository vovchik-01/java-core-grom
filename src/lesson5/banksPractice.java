package lesson5;

import java.util.Arrays;

public class banksPractice {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nilolay", "Irina"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};

        System.out.println(Arrays.toString(findClientsByBalance(names, balances, 100)));
        System.out.println(Arrays.toString(findClientsWithNegativeBalance(names, balances)));
        depositMoney(names, balances, "Ann", 1000);
        System.out.println(Arrays.toString(balances));
    }

    public static String[] findClientsByBalance(String[] clients, int[] balances, int n) {
        // String[] results = new String[clients.length];
        //находим кол-во результатов
        //создаем массив с длинной результатов
        //записываем результаты

        int count = 0;
        for (int balance : balances) {
            if (balance >= n)
                count++;
        }
        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance >= n) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;

    }



    public static String[] findClientsWithNegativeBalance(String[] clients, int[] balances) {
        int count = 0;
        for (int balance : balances) {
            if (balance < 0)
                count++;
        }
        String[] results = new String[count];

        int index = 0;
        int resIndex = 0;
        for (int balance : balances) {
            if (balance < 0) {
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;

    }


    static void depositMoney(String [] clients, int[] balances, String client, int money){
        // найти клиента в массиве
        // считаем сумму пополнения с учетом комиссии
        //обновляем баланс (пополняем)

        int clientIndex = 0;
        for (String cl : clients){
            if(cl == client){
                break;
            }
            clientIndex++;
        }

        int moneyToDeposit = money <= 100 ? (int) (money - money * 0.02) : (int) (money - money * 0.01);

        balances[clientIndex] += moneyToDeposit;





    }

}
