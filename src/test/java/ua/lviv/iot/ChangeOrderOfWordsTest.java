package ua.lviv.iot;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ChangeOrderOfWordsTest {

    private static final String TEXT_TO_CHECK = "Where was he going to cinema? He didn’t know. What was he going to do there? He didn’t know.";

    public static final int expectedNumber = 6;

    List<String> interrogetiveSentences = new LinkedList<String>();

    String finalText;

    public int numberOfWords;

    @Test
    public void changeOrderOfWordsTest() {
        interrogetiveSentences = ChangeOrderOfWords.findInterrogativeSentences(TEXT_TO_CHECK);
        finalText = ChangeOrderOfWords.reverseWords(interrogetiveSentences, expectedNumber);
        System.out.println(finalText);
    }
}