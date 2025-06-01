package de.com.dexteritysolutions.challenges.java.codility;

import java.util.*;

public class ALNSGetYourGuideCodilityChallenge {

    public static void main(String[] args) {

        ALNSGetYourGuideCodilityChallenge alns = new ALNSGetYourGuideCodilityChallenge();

        List<String[]> inputTestCasesList = List.of(
            new String[] {"aaka", "aaka", "aaja", "aaxa", "aaba"}
            , new String[] {"bay", "zaz", "bab"}
            , new String[] {"zzz", "ccb", "zyb"}
        );

        for (String[] inputTestCasesArray : inputTestCasesList) {
            System.out.println("==> Given the Words Array '" + Arrays.toString(inputTestCasesArray) + "', the different string is : " + alns.solutionByIA(inputTestCasesArray));
        }

    }

    /**
     * Given an array of words ('words') made of N strings, each of length K, returns a string of length K that differs from every string in the array in at most one position.
     * The returned string should consist of lowercase English letters.
     * If there are multiple such strings, the function can return any. If there are no such strings, the function should return the empty string "".
     * @param words
     * @return
     */
    public String solution(String[] words) {

        String result = "";
        int lengthOfWordsArray = words.length;
        int lengthOfEachWord = words[0].length();
        LinkedHashSet<String[]> lettersPerPositionSet = new LinkedHashSet<>();

        System.out.println("===> Given words array = " + words.toString());

        for (int i = 0; i < lengthOfEachWord; i++) {

            String[] lettersPositionArray = new String[lengthOfWordsArray];

            for (int j = 0; j < lengthOfWordsArray; j++) {

                lettersPositionArray[j] = String.valueOf(words[j].charAt(i));

            }
            lettersPerPositionSet.add(lettersPositionArray);

        }

        return result;
    }

    public String solutionByIA(String[] words) {
        int n = words.length;
        int k = words[0].length();

        // Start with the first word as the base candidate
        char[] candidate = words[0].toCharArray();

        // Test modifications to each letter
        for (int i = 0; i < k; i++) {
            // Save the original character
            char originalChar = candidate[i];

            // Try replacing current character with 'a' to 'z'
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == originalChar) continue; // Skip the original character

                candidate[i] = ch; // Apply the change

                // Check if the modified candidate is valid
                if (isValidCandidate(new String(candidate), words)) {
                    return new String(candidate);
                }
            }

            // Restore the original character before moving to the next position
            candidate[i] = originalChar;
        }

        // Check if the original unmodified candidate works
        if (isValidCandidate(new String(candidate), words)) {
            return new String(candidate);
        }

        // If no valid string found, return an empty string
        return "";
    }

    /**
     * Checks if the given candidate differs from all words by at most one position.
     *
     * @param candidate Candidate string to test.
     * @param words     Original array of words.
     * @return True if valid, false otherwise.
     */
    private boolean isValidCandidate(String candidate, String[] words) {
        for (String word : words) {
            // Check how many positions differ
            if (countDifferences(candidate, word) > 1) {
                return false; // If more than one position differs, it's invalid
            }
        }
        return true;
    }

    /**
     * Counts the number of differing positions between two strings.
     *
     * @param str1 First string.
     * @param str2 Second string.
     * @return Number of differing positions.
     */
    private int countDifferences(String str1, String str2) {
        int differences = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                differences++;
                if (differences > 1) {
                    return differences; // Early exit if more than one difference
                }
            }
        }
        return differences;
    }

}

