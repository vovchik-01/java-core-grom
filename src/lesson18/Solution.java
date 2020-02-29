package lesson18;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String text = "asdgh h4jk5l hl2lk hhh 554 242";
        System.out.println(Arrays.toString(findNumbers(text)));
    }

    public static int[] findNumbers(String text) {

        String[] words = text.split(" ");
        int[] result = new int[words.length];
        int index = 0;
        for (String wrd : words) {
            try {
                int res = Integer.parseInt(wrd);
                result[index] = res;
                index++;
            } catch (Exception e) {
                System.err.println(wrd + " not a number");
            }
        }
        return result;
    }


}

