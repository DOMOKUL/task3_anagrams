package com.company;

import java.util.Scanner;

public class AnagramApp {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String text = scanner.nextLine();
            Anagram anagram = new Anagram();
            String result = anagram.process(text);
            System.out.println(result);
        }
    }
}
