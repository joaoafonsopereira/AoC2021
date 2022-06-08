package day04;

import utils.Solver;

public class Part2Solver extends Part1Solver {


    @Override
    public String getSolution() {
        BingoBoard winner = null;
        for(int number : numbers) {
            binfo.drawNumber(number);
            if (binfo.hasLastWinner()) {
                winner = binfo.getWinner();
                break;
            }
        }
        assert winner != null;
        int score = winner.computeScore();
        return String.valueOf(score);
    }
}
