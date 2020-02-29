package lesson17.secondHW;


public class Solution {
    public static void main(String[] args) {
        String test = " про пропроп прпо 68768 ро7 (;.";
        System.out.println(minWord(test));
        System.out.println((maxWord(test)));

    }


    public static String minWord(String input) {
        input = input.trim();
        String[] words = input.split(" ");
        if (words.length == 0) {
            return null;
        }
        String minWord = null;
        for (String word : words) {
            if (word.length() > 0 && isLetter(word)) {
                minWord = word;
                break;
            }
        }
        if (minWord == null) {
            return null;
        }

        for (String word : words) {
            if (word.length() > 0 && word.length() < minWord.length() && isLetter(word)) {
                minWord = word;
            }
        }

        return minWord;

    }


    public static String maxWord(String input) {

        String[] words = input.split(" ");
        if (words.length == 0) {
            return null;
        }
        String maxWord = null;

        for (String word : words) {
            if (word.length() > 0 && isLetter(word)) {
                maxWord = word;
                break;
            }
        }
        if (maxWord == null) {
            return null;
        }
        for (String word : words) {
            if (word.length() > maxWord.length() && isLetter(word)) {
                maxWord = word;
            }
        }
        return maxWord;
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