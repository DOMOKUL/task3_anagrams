package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnagramTest {
    Anagram anagram;

    @BeforeEach
    public void setUp() {
        anagram = new Anagram();
    }

    @Test
    void reverseString_shouldReverseEachWordWithoutSpecificSymbols_whenInputOnlyLetters() {
        assertEquals("dcba hgfe", anagram.process("abcd efgh"));
    }

    @Test
    void reverseString_shouldStaySpacesInFrontString_whenPutSpacesInFrontString() {
        assertEquals ("  d1cba e2hgfe", anagram.process("  a1bcd e2fghe"));
    }

    @Test
    void reverseString_shouldDoNotReverseEachWordWithNumbers_whenStringContainOnlyNumbers() {
        assertEquals("123 456", anagram.process("123 456"));
    }

    @Test
    void reverseString_shouldOutputEmptyString_whenInputEmptyString() {
        assertEquals("", anagram.process(""));
    }

    @Test
    void reverseString_shouldDoNotReverseEachWord_whenInputOnlyAlphabetic() {
        assertEquals("!#@$ ^!*(", anagram.process("!#@$ ^!*("));
    }

    @Test
    void reverseString_shouldReverseEachWord_whenInputLettersAndNumbers() {
        assertEquals("b1a2 d3c4", anagram.process("a1b2 c3d4"));
    }

    @Test
    void reverseString_shouldReverseEachWord_whenInputLettersAndAlphabetic() {
        assertEquals("d1cba hgf!e", anagram.process("a1bcd efg!h"));
    }

    @Test
    void reverseString_shouldDoNotReverseEachWord_whenInputNumbersAndAlphabetic() {
        assertEquals("1@2# 3$4%", anagram.process("1@2# 3$4%"));
    }

    @Test
    void reverseString_shouldReverseEachWord_whenInputLettersAndNumbersAndAlphabetic() {
        assertEquals("r6k%t*0a 6m7k&2t^", anagram.process("a6t%k*0r 6t7k&2m^"));
    }

    @Test
    void reverseString_shouldThrowNullPointerException_whenInputNull(){
        assertThrows(NullPointerException.class, () -> anagram.process(null));
    }

    @Test
    void reverseWord_shouldReverseOneWord_whenInputNull(){
        assertEquals("hgf!e", anagram.reverseWordWithoutNotLetters("efg!h"));
    }
    @Test
    void reverseWord_shouldThrowNullPointerException_whenInputNull(){
        assertThrows(NullPointerException.class, () -> anagram.reverseWordWithoutNotLetters(null));
    }

    @Test
    void reverseWord_shouldDoNotReverseWordWithNumbers_whenWordContainOnlyNumbers() {
        assertEquals("123456", anagram.reverseWordWithoutNotLetters("123456"));
    }

}
