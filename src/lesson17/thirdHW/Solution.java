package lesson17.thirdHW;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String test = "ghj ghj ghj ghj  f f f f f 78 78 78 78 78 7859 ^&* 098";
        System.out.println(mostCountedWord(test));

    }

    public static String mostCountedWord(String input) {

        if (input == null) {
            return null;
        }
        String[] words = input.split(" ");
        Arrays.sort(words);
        if (words.length == 0) {
            return null;
        }
        String mostCountedWord = null;
        int maxCount = 0;
        for (String word : words) {
            int count = 0;
            for (String item : words) {
                if (word.equals(item) && word.length() > 0 && isLetter(item)) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostCountedWord = word;
            }
        }

        return mostCountedWord;
    }


    private static boolean isLetter(String sentence) {
        char[] chars = sentence.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }

}
