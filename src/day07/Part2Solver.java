package day07;

import java.util.Arrays;

public class Part2Solver extends Part1Solver {


    /**
     * Brute force solution -- O(n^2) -- but it's ok in this case as the input array's length is only 1000.
     *
     * It seems like it would be possible to solve this in "constant time" (after sorting the input) using the
     * average instead of the median (used in part 1). But this method was returning the wrong result, finding the
     * position 467 as the average (and hence the "optimal" alignment position), whereas the correct answer is 466.
     */
    public String getSolution() {
        Arrays.sort(positions);
//        long avg = avg(positions);

        final int min = positions[0];
        final int max = positions[positions.length-1];
        long minCost = Long.MAX_VALUE;
        for (int X = min; X <= max; X++) {
            long totCost = 0;
            for (int pos : positions) {
                totCost += cost(pos, X);
            }
            if (totCost < minCost) {
                minCost = totCost;
                System.out.println("pos = " + X);
            }
        }

        return String.valueOf(minCost);
    }

    long cost(int x1, int x2) {
        long N = Math.abs(x1 - x2);
        return N * (N + 1) / 2;
    }

    long avg(int[] arr) {
        long sum = Arrays.stream(arr).sum();
        return Math.round(sum*1.0/arr.length);
    }


}
