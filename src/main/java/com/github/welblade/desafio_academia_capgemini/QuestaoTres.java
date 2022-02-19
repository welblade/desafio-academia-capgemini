package com.github.welblade.desafio_academia_capgemini;

import java.util.*;

public class QuestaoTres {

    public static void main(final String... args) {
        int result = 0;
        if (args.length > 0) {
            result = countAnagrams(args[0]);
        }
        System.out.println(result);
    }

    public static int countAnagrams(final String text) {
        return findAnagrams(text).size();
    }

    public static List<List<String>> findAnagrams(final String text) {
        final List<List<String>> result = new ArrayList<>();

        if (text.length() == 0) {
            result.add(new ArrayList<>());
        }
        for (int length = 1; length <= (text.length() / 2) + (text.length() % 2); length++) {
            for (int firstWordIndex = 0; firstWordIndex < text.length() - length; firstWordIndex++) {
                for (int secondWordIndex = firstWordIndex + 1; secondWordIndex <= text.length() - length; secondWordIndex++) {
                    final String firstWord = text.substring(firstWordIndex, firstWordIndex + length);
                    final String secondWord = text.substring(secondWordIndex, secondWordIndex + length);

                    if (isAnagram(firstWord, secondWord)) {
                        final List<String> element = new ArrayList<>();
                        element.add(firstWord);
                        element.add(secondWord);
                        result.add(element);
                    }
                }
            }
        }
        return result;
    }

    private static Boolean isAnagram(final String source, final String other) {
        final List<String> firstWordArray = Arrays.asList(source.split(""));
        final List<String> secondWordArray = Arrays.asList(other.split(""));
        final Set<String> secondWordSet = new HashSet<>(secondWordArray);
        for (String letter : secondWordSet) {
            if (countCharOccurrences(firstWordArray, letter)
                    != countCharOccurrences(secondWordArray, letter)
            ) {
                return false;
            }
        }
        return true;
    }

    private static int countCharOccurrences(final List<String> firstWordArray, final String letter) {
        return firstWordArray.stream()
                .filter((s) -> s.contentEquals(letter))
                .toArray()
                .length;
    }
}
