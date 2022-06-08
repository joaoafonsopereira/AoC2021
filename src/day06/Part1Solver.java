package day06;

import utils.Solver;

import java.util.Arrays;

public class Part1Solver implements Solver {

    // parsed input
    int[] ageList;

    // totalChildren[i][j] memoizes the total nr of lanterfish created by a fish with internal timer = i, over j days
    long[][] totalChildren;

    final static int TOTAL_DAYS = 256;


    @Override
    public void addInputLine(String line) {

    }

    @Override
    public String getSolution() {
        totalChildren = new long[9][TOTAL_DAYS + 1];
        long totalFish = 0;
        for (int timer : ageList) {
            totalFish += 1 + totalChildrenMemo(timer, TOTAL_DAYS);
        }
        return String.valueOf(totalFish);
    }

    int directChildren(int t0, int d) {
        if (d < (t0 + 1)) {
            return 0;
        } else {
            return 1 + (d - (t0 + 1)) / 7;
        }
    }

    long totalChildrenMemo(int t0, int d) {
        if (totalChildren[t0][d] != 0) { // if already memoized
            return totalChildren[t0][d];
        }

        final int dChildren = directChildren(t0, d);
        long sum = 0;
        for (int i = 0; i < dChildren; i++) {
            final int remainingDays = d - (t0 + 1 + 7*i);
            sum += 1 + totalChildrenMemo(8, remainingDays);
        }
        totalChildren[t0][d] = sum; // memoize
        return sum;
    }

//    void precomputeTotalChildren(int maxInternalTimer, int days) {
//        for (int d = 1; d <= days; d++) {
//            for (int t0 = 0; t0 <= maxInternalTimer; t0++) {
//                totalChildren[t0][d] = totalChildren(t0, d);
//            }
//        }
//
//    }

//    int totalChildren(int t0, int d) {
//        final int dChildren = directChildren(t0, d);
//        int sum = 0;
//        for (int i = 0; i < dChildren; i++) {
//            final int remainingDays = d - (t0 + 1 + 7*i);
//
//
//            sum += totalChildren[8][remainingDays];
//        }
//        return sum;
//    }



}
