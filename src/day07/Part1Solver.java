package day07;

import utils.Solver;

import java.util.Arrays;
import java.util.function.DoubleConsumer;

public class Part1Solver implements Solver {

    int[] positions;


    @Override
    public void addInputLine(String line) {
        String[] split = line.split(",");
        positions = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
    }

    @Override
    public String getSolution() {
        Arrays.sort(positions);
        int median = median(positions);
        long totalFuel = 0;
        for (int pos : positions) {
            totalFuel += Math.abs(pos - median);
        }
        return String.valueOf(totalFuel);
    }


    int median(int[] arr) {
        final int middle = arr.length/2;
        if (arr.length % 2 == 0) {
            return (arr[middle - 1] + arr[middle])/2; // could just return either "median" https://math.stackexchange.com/questions/113270/the-median-minimizes-the-sum-of-absolute-deviations-the-ell-1-norm
        } else {
            return arr[middle];
        }
    }

}
