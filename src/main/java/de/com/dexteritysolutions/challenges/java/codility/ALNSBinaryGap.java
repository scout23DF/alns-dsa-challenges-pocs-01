package de.com.dexteritysolutions.challenges.java.codility;

public class ALNSBinaryGap {

    public static void main(String[] args) {

        ALNSBinaryGap alns = new ALNSBinaryGap();

        int[] inputTestCasesArray = new int[] {
                9,
                2_147_483_647,
                15,
                32,
                33,
                1041,
                331,
                10241,
                529
        };

        for (int i = 0; i < inputTestCasesArray.length; i++) {
            System.out.println("==> Given the Number '" + inputTestCasesArray[i] + "', the longest binary gap is : " + alns.solution(inputTestCasesArray[i]));
        }

    }

    // you can write to stdout for debugging purposes, e.g.
    // System.out.println("this is a debug message");

    public int solution(int N) {

        int result = 0;
        int maxGap = 0;
        int currentGap = 0;
        boolean sequenceStarted = false;
        String strNumberAsBinary = Integer.toBinaryString(N);

        System.out.println("===> strNumberAsBinary = " + strNumberAsBinary);

        for (int i = 0; i < strNumberAsBinary.length(); i++) {
            if (strNumberAsBinary.charAt(i) == '1') {
                if (sequenceStarted) {
                    if (currentGap > maxGap) {
                        maxGap = currentGap;
                    }
                }
                currentGap = 0;
                sequenceStarted = true;
            } else {
                currentGap++;
            }

        }

        result = maxGap;

        return result;
    }
}

