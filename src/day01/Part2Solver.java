package day01;

import utils.Solver;

import java.util.Arrays;

public class Part2Solver implements Solver {

    int count = 0;

    int prevWindowDepths = Integer.MAX_VALUE / 4 * 3;
    int[] windowMeasures = {Integer.MAX_VALUE / 4, Integer.MAX_VALUE / 4, Integer.MAX_VALUE / 4}; // divide by (4) to avoid overflow


    public void addInputLine(String line) {
        int depth = Integer.parseInt(line);
        // slide window
        windowMeasures[0] = windowMeasures[1];
        windowMeasures[1] = windowMeasures[2];
        windowMeasures[2] = depth;
        int currWindowDepth = Arrays.stream(windowMeasures).sum();
        if (currWindowDepth > prevWindowDepths) {
            count++;
        }
        prevWindowDepths = currWindowDepth;

    }

    public String getSolution() {
        return String.valueOf(count);
    }
}
