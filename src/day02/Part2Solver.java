package day02;

import utils.Solver;

public class Part2Solver implements Solver {

    long horizontal = 0;
    long depth = 0;
    long aim = 0;

    public void addInputLine(String line) {
        String[] tokens = line.split(" ");
        String cmd = tokens[0];
        int X = Integer.parseInt(tokens[1]);
        switch (cmd) {
            case "forward":
                horizontal += X;
                depth += aim * X;
                break;
            case "down":
                aim += X;
                break;
            case "up":
                aim -= X;
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
