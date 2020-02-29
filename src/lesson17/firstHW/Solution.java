package lesson17.firstHW;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String example = "It is good to help people! hjg lkg 123 fhgj ^&*";
        System.out.println(countWords(example));

    }


    public static int countWords(String example) {
        char[] sentence = example.toCharArray();
        boolean inWord = false;
        int wordCount = 0;
        for (char c : sentence) {
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                if (!inWord) {
                    wordCount++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }
        return wordCount;
    }
}