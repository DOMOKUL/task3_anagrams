package com.company;

public class Anagram {

    public String process(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = text.split(" ");
        for (String word : words) {
            stringBuilder.append(reverseWordWithoutNotLetters(word));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public String reverseWordWithoutNotLetters(String word) {
        char[] chars = word.toCharArray();
        int leftSide = 0;
        int rightSide = chars.length - 1;

        while (leftSide < rightSide) {
            if (!Character.isAlphabetic(chars[leftSide])) {
                leftSide++;
            } else if (!Character.isAlphabetic(chars[rightSide])) {
                rightSide--;
            } else {
                char exchange = chars[leftSide];
                chars[leftSide] = chars[rightSide];
                chars[rightSide] = exchange;
                leftSide++;
                rightSide--;
            }
        }
        return String.valueOf(chars);
    }
}

