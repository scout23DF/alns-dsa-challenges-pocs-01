package de.com.dexteritysolutions.challenges.java.algoexpert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ALNSSortedSquaredArray {

    private record InputTestParamsDTO(
            int[] array
    ) { }

    public static void main(String[] args) {

        List<InputTestParamsDTO> inputTestCasesList = List.of(
                (new InputTestParamsDTO(new int[]{1, 2, 3, 5, 6, 8, 9})),
                (new InputTestParamsDTO(new int[]{1})),
                (new InputTestParamsDTO(new int[]{1, 2})),
                (new InputTestParamsDTO(new int[]{1, 2, 3, 4, 5})),
                (new InputTestParamsDTO(new int[]{0})),
                (new InputTestParamsDTO(new int[]{10})),
                (new InputTestParamsDTO(new int[]{-1})),
                (new InputTestParamsDTO(new int[]{-2, -1})),
                (new InputTestParamsDTO(new int[]{-5, -4, -3, -2, -1})),
                (new InputTestParamsDTO(new int[]{-10})),
                (new InputTestParamsDTO(new int[]{-10, -5, 0, 5, 10})),
                (new InputTestParamsDTO(new int[]{-7, -3, 1, 9, 22, 30})),
                (new InputTestParamsDTO(new int[]{-50, -13, -2, -1, 0, 0, 1, 1, 2, 3, 19, 20})),
                (new InputTestParamsDTO(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0})),
                (new InputTestParamsDTO(new int[]{-1, -1, 2, 3, 3, 3, 4})),
                (new InputTestParamsDTO(new int[]{-3, -2, -1}))
        );

        for (InputTestParamsDTO inputTestCasesArray : inputTestCasesList) {
            System.out.println(
                    "==> Given the Main Array of Numbers '" + Arrays.toString(inputTestCasesArray.array()) +
                    "', the sorted Squared Array i: " + Arrays.toString(ALNSSortedSquaredArray.sortedSquaredArray(inputTestCasesArray.array()))
            );
        }

    }

    public static int[] sortedSquaredArray(int[] array) {
        int[] resultArray = new int[array.length];
        int idxStart = 0;
        int idxEnd = array.length - 1;
        int idxResult = resultArray.length - 1;

        while (idxStart <= idxEnd) {

            if (Math.abs(array[idxStart]) > Math.abs(array[idxEnd])) {
                resultArray[idxResult] = array[idxStart] * array[idxStart];
                idxStart++;
            } else {
                resultArray[idxResult] = array[idxEnd] * array[idxEnd];
                idxEnd--;
            }
            idxResult--;
        }

        return resultArray;
    }

    public static int[] sortedSquaredArrayFirstAttempt(int[] array) {
        int[] resultArray = new int[array.length];
        List<Integer> sortedSquaredList = new LinkedList<>();

        for (int oneNumber : array) {
            sortedSquaredList.add(oneNumber * oneNumber);
        }

        resultArray = sortedSquaredList.stream().sorted().mapToInt(Integer::intValue).toArray();

        return resultArray;
    }
}

