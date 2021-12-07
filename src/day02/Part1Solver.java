package day02;

import utils.Solver;

public class Part1Solver implements Solver {


    long horizontal = 0;
    long depth = 0;

    public void addInputLine(String line) {
        String[] tokens = line.split(" ");
        String cmd = tokens[0];
        int units = Integer.parseInt(tokens[1]);
        switch (cmd) {
            case "forward":
                horizontal += units;
                break;
            case "down":
                depth += units;
                break;
            case "up":
                depth -= units;
                break;
        }
    }

    @Override
    public String getSolution() {
        long res = horizontal * depth;

        System.out.println("Horiz = " + horizontal);
        System.out.println("Depth = " + depth);

        return String.valueOf(res);
    }
}
