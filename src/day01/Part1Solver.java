package day01;

import utils.Solver;

public class Part1Solver implements Solver {

    int depth = Integer.MAX_VALUE;
    int count = 0;

    public void addInputLine(String line) {
        int newDepth = Integer.parseInt(line);
        if (newDepth > depth) {
            count++;
        }
        depth = newDepth;
    }

    public String getSolution() {
        return String.valueOf(count);
    }

}
