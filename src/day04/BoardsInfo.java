package day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardsInfo {

    static final int GRID_WIDTH = 5;
    static final int GRID_HEIGHT = 5;

    BingoBoard currBoard;
    List<BingoBoard> boards = new ArrayList<>();

    Map<Integer, List<BingoBoard>> numberToBoards = new HashMap<>();

    BingoBoard winner = null;

    void newBoard() {
        currBoard = new BingoBoard(GRID_WIDTH, GRID_HEIGHT);
        boards.add(currBoard);
    }

    void addLineToCurrBoard(int[] line) {
        currBoard.addLine(line);
        for(int nr : line) {
            // insert mapping: nr -> currBoard
            numberToBoards.computeIfAbsent(nr, n -> new ArrayList<>()).add(currBoard);
        }
    }

    void drawNumber(int number) {
        for (BingoBoard board : numberToBoards.get(number)) {
            board.markNumber(number);
            if (board.wins()) {
                if (boards.remove(board)) {
                    winner = board;
                }
                //break;
            }
        }
    }

    boolean hasWinner() {
        return winner != null;
    }

    boolean hasLastWinner() {
        return boards.size() == 0;
    }

    BingoBoard getWinner() {
        return winner;
    }
}
