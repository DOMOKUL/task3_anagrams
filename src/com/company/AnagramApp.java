package com.company;

import java.util.Scanner;


public class AnagramApp {

    private static Anagram anagram;

    public static void setAnagram(Anagram anagram) {
        AnagramApp.anagram = anagram;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String text = scanner.nextLine();
            String result = anagram.process(text);
            System.out.print(result);
        }
    }
}
