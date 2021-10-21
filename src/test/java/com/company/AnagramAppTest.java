package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AnagramAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();



    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void startAnagramApp_shouldReadStringAndOutputReverseString_whenInputStringWithLetterAndAlphabetic() {
        Anagram mockAnagram = Mockito.mock(Anagram.class);
        String input = "a1b2 c3d4";
        when(mockAnagram.process(input)).thenReturn("b1a2 d3c4");
        AnagramApp.setAnagram(mockAnagram);
        InputStream targetStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(targetStream);
        AnagramApp.main(null);
        assertEquals("b1a2 d3c4", outContent.toString());
    }

    @Test
    void startAnagramApp_shouldThrowNullPointerException_whenSubmitNull() {
        String input = "a1b2 c3d4";
        //AnagramApp.setAnagram(null);
        InputStream targetStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(targetStream);
        assertThrows(NullPointerException.class, () -> AnagramApp.main(null));
    }

}