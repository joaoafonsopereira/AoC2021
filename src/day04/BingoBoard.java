package day04;

import utils.Pair;

import java.util.HashMap;
import java.util.Map;

public class BingoBoard {

    final int WIDTH;
    final int HEIGHT;

    int[][] numbers;
    int currLine = 0;

    boolean wins = false;
    int unmarkedSum = 0;
    int lastMarkedNumber;

    Map<Integer, Pair<Integer, Integer>> numberToCoords = new HashMap<>();
    // track how many numbers are still unmarked in each row/column
    int[] unmarkedPerRow;
    int[] unmarkedPerCol;

    public BingoBoard(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.numbers = new int[width][height];
        this.unmarkedPerRow = new int[height];
        for (int r = 0; r < height; r++) {
            unmarkedPerRow[r] = width;
        }
        this.unmarkedPerCol = new int[width];
        for (int c = 0; c < width; c++) {
            unmarkedPerCol[c] = height;
        }
    }

    void addLine(int[] line) {
        for (int i = 0; i < WIDTH; i++) {
            int number = line[i];
            numbers[currLine][i] = number;
            unmarkedSum += number;
            numberToCoords.put(number, new Pair<>(currLine, i));
        }
        currLine++;
    }


    void markNumber(int number) {
        unmarkedSum -= number;
        lastMarkedNumber = number;

        var coords = numberToCoords.get(number);
        var row = coords._1;
        var col = coords._2;
        unmarkedPerRow[row]--;
        unmarkedPerCol[col]--;
        if(unmarkedPerRow[row] == 0 || unmarkedPerCol[col] == 0) {
            wins = true;
        }
    }

    boolean wins() {
        return wins;
    }

    int computeScore() {
        return unmarkedSum * lastMarkedNumber;
    }



}
