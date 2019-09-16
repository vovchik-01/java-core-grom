package lesson5;

import java.util.Arrays;

public class BanksDraw {
    public static void main(String[] args) {
        String[] clients = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina"};
        int[] balances = {100, 500, 8432, -99, 12000, -54};
        withdraw(clients, balances, "Nikolay", 50);
        System.out.println(Arrays.toString(balances));

    }


    static int withdraw(String[] clients, int[] balances, String client, int amount){
        int clientIndex = 0;
        for (String cl : clients){
            if (cl == client){
                break;
            }
            clientIndex++;
        }
        if (balances[clientIndex] < amount){
            return -1;
        }
        else
            balances[clientIndex] -= amount;
        return balances[clientIndex];
    }
}
