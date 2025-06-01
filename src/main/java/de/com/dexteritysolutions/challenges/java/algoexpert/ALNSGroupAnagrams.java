package de.com.dexteritysolutions.challenges.java.algoexpert;

import java.util.*;

public class ALNSGroupAnagrams {

    private record InputTestParamsDTO(
            List<String> words
    ) { }

    public static void main(String[] args) {

        List<InputTestParamsDTO> inputTestCasesList = List.of(
                (new InputTestParamsDTO(List.of("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp")))
        );

        for (InputTestParamsDTO inputTestCasesArray : inputTestCasesList) {
            System.out.println(
                    "==> Given the Main Array of Words '" + inputTestCasesArray.words() +
                    "', the found Group of Anagrams are: " + ALNSGroupAnagrams.groupAnagrams(inputTestCasesArray.words())
            );
        }

    }

    public static List<List<String>> groupAnagrams(List<String> words) {
        List<List<String>> resultList = new ArrayList<>();
        Map<String, List<String>> anagramsMap = new LinkedHashMap<>();

        for (String oneOriginalWord : words) {

            char[] charArray = oneOriginalWord.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            if (anagramsMap.containsKey(sortedWord)) {
                anagramsMap.get(sortedWord).add(oneOriginalWord);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(oneOriginalWord);
                anagramsMap.put(sortedWord, newList);
            }

        }

        if (!anagramsMap.isEmpty()) {
            resultList.addAll(anagramsMap.values());
        }

        return resultList;
    }
}

