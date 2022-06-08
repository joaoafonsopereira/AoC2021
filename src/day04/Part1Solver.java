package day04;

import utils.Solver;
import java.util.Arrays;

public class Part1Solver implements Solver {

    int[] numbers = null;
    BoardsInfo binfo = new BoardsInfo();

    @Override
    public void addInputLine(String line) {
        if (numbers == null) { // if line is the first line
            String[] split = line.split(",");
            numbers = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            return;
        }

        if (line.length() == 0) {
            binfo.newBoard();
        } else {
            String[] split = line.trim().split("\\s+");
            int[] lineNrs = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            binfo.addLineToCurrBoard(lineNrs);
        }
    }

    @Override
    public String getSolution() {
        BingoBoard winner = null;
        for(int number : numbers) {
            binfo.drawNumber(number);
            if (binfo.hasWinner()) {
                winner = binfo.getWinner();
                break;
            }
        }
        assert winner != null;
        int score = winner.computeScore();
        return String.valueOf(score);
    }
}
