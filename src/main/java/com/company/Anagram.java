package com.company;

import com.google.common.annotations.VisibleForTesting;

import java.util.StringJoiner;

public class Anagram {

    public String process(String text) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        String[] words = text.split(" ");
        for (String word : words) {
            stringJoiner.add(reverseWordWithoutNotLetters(word));
        }
        return stringJoiner.toString();
    }

    @VisibleForTesting
    String reverseWordWithoutNotLetters(String word) {
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

