package de.com.dexteritysolutions.challenges.java.algoexpert;

import java.util.List;
import java.util.Objects;

public class ALNSValidateSubsequence {

    private record InputTestParamsDTO(
            List<Integer> mainList,
            List<Integer> subSequence
    ) { }

    public static void main(String[] args) {

        List<InputTestParamsDTO> inputTestCasesList = List.of(
                (new InputTestParamsDTO(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(1, 6, -1, 10)))
                , (new InputTestParamsDTO(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(6, 1, -1, 10)))
                , (new InputTestParamsDTO(List.of(22, 25, 6, -8, 25, -75, 15, 102, -148, 3, 7), List.of(-8, 6, -148)))
        );

        for (InputTestParamsDTO inputTestCasesArray : inputTestCasesList) {
            System.out.println(
                    "==> Given the Main Array of Numbers '" + inputTestCasesArray.mainList() +
                    "', and subsequence '" + inputTestCasesArray.subSequence() +
                    " - Result = " + ALNSValidateSubsequence.isValidSubsequence(inputTestCasesArray.mainList(), inputTestCasesArray.subSequence())
            );
        }

    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        boolean bolResult = false;
        int idxPointerInSubsequence = 0;

        for (Integer oneMainNumber : array) {

            if (idxPointerInSubsequence < sequence.size() && Objects.equals(sequence.get(idxPointerInSubsequence), oneMainNumber)) {
                idxPointerInSubsequence++;
            }

            if (idxPointerInSubsequence == sequence.size()) {
                bolResult = true;
                break;
            }

        }

        return bolResult;
    }
}

