package de.com.dexteritysolutions.challenges.java.codility;

import java.util.HashSet;

public class ALNSPermMissingElem {

    public static void main(String[] args) {

        ALNSPermMissingElem alns = new ALNSPermMissingElem();

        System.out.println("==> Given the array [2, 4, 7, 5, 2, 3], the first missing Integer number is: " + alns.solution(new int[] {2, 4, 7, 5, 2, 3}));
        System.out.println("==> Given the array [4,-3, 3, -2, 1, 0, -4, 2, -5, 6], the first missing Integer number is: " + alns.solution(new int[] {4,-3, 3, -2, 1, 0, -4, 2, -5, 6}));

    }

    // you can write to stdout for debugging purposes, e.g.
    // System.out.println("this is a debug message");

    public int solution(int[] A) {

        int result = 1;
        HashSet<Integer> whosLeavingSet = new HashSet<>();

        for (int i = 1; i <= A.length + 1; i++) {
            whosLeavingSet.add(i);
        }

        // System.out.println("===> Current filled whosLeavingSet = " + whosLeavingSet);

        for (int i = 0; i < A.length; i++) {
            // System.out.println("===> whosLeavingSet before remove() = " + whosLeavingSet);
            whosLeavingSet.remove((Integer) A[i]);
            // System.out.println("===> whosLeavingSet after remove() = " + whosLeavingSet);
        }

        result = whosLeavingSet.iterator().next();

        return result;
    }
}

