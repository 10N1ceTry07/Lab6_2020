package ua.lviv.iot;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeOrderOfWords {

    public static int numberOfWords;

    private static List<String> interrogativeSentences = new LinkedList<String>();

    public static List<String> findInterrogativeSentences(String text) {

        String regex = "\\b\\p{Upper}[^.!?]*[?]+[.!]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            interrogativeSentences.add(removeLastLetter(matcher.group()));
        }
        return interrogativeSentences;
    }

    public static String reverseWords(List<String> sentences, int expectedNumber) {
        StringBuilder interrogativeSentencesWithReversedWords = new StringBuilder();
        for (String sentence : sentences) {
            numberOfWords = 0;
            numberOfWords++;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ') {
                    numberOfWords++;
                }
            }
            if (numberOfWords > expectedNumber) {
                List<String> words = Arrays.asList(sentence.split("\\s"));
                StringBuilder sb = new StringBuilder(sentence.length());

                for (int i = words.size() - 1; i >= 0; i--) {
                    sb.append(words.get(i).toLowerCase());
                    sb.append(' ');
                }

                interrogativeSentencesWithReversedWords.append(toUpperCaseFirstLetter(sb.toString().trim())).append('?')
                        .append('\n');
            }
        }
        return interrogativeSentencesWithReversedWords.toString();
    }

    private static String removeLastLetter(String str) {
        String result = null;
        if ((str != null) && (str.length() > 0)) {
            result = str.substring(0, str.length() - 1);
        }
        return result;
    }

    private static String toUpperCaseFirstLetter(String str) {
        String result = str.substring(0, 1).toUpperCase() + str.substring(1);
        return result;
    }
}