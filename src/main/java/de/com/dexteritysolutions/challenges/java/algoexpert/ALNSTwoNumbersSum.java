package de.com.dexteritysolutions.challenges.java.algoexpert;

import java.util.*;

public class ALNSTwoNumbersSum {

    public static void main(String[] args) {

        List<InputTestParamsDTO> inputTestCasesList = List.of(
           new InputTestParamsDTO(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10)
           , new InputTestParamsDTO(new int[]{8, -13, 25, -12, 9, 5, 1, 7}, 12)
           , new InputTestParamsDTO(new int[]{-12, -5, 8, 6, -3, 10, -2, 4}, -2)
        );

        for (InputTestParamsDTO inputTestCasesArray : inputTestCasesList) {
            System.out.println(
                    "==> Given the Array of Numbers '" + Arrays.toString(inputTestCasesArray.array()) +
                    "', the 2 numbers sum for " + inputTestCasesArray.targetSum() +
                    " are : " + Arrays.toString(ALNSTwoNumbersSum.twoNumberSum(inputTestCasesArray.array, inputTestCasesArray.targetSum()))
            );
        }

    }

    private record InputTestParamsDTO(int[] array, int targetSum) {
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        int[] resultArray = new int[2];
        List<Integer> foundNumbersList = new ArrayList<>();
        Map<Integer, Integer> complimentsOfSumMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int compliment = targetSum - array[i];
            if (complimentsOfSumMap.containsKey(compliment)) {
                foundNumbersList.add(compliment);
                foundNumbersList.add(array[i]);
                break;
            } else {
                complimentsOfSumMap.put(array[i], i);
            }
        }

        resultArray = foundNumbersList.stream().mapToInt(Integer::intValue).toArray();

        return resultArray;
    }
}

