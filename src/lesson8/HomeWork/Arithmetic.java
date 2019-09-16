package lesson8.HomeWork;

import java.util.Arrays;


public class Arithmetic {


    public static boolean check(int[] array){
        Arrays.sort(array);
        if(array[0] + array[array.length-1] > 100)
            return true;
        else
            return false;
    }

}
