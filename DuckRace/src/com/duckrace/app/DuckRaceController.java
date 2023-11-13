package com.duckrace.app;
import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Locale;
import java.util.Scanner;

public class DuckRaceController {
    private final Board board = Board.getInstance();
    //private final BoardView boardView = new BoardView(board);
    private final Scanner scanner = new Scanner(System.in);
    private final int maxID = board.maxID();

    public void execute() {
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promtForReward();
        updateBoard(id, reward);
        showBoard();
    }

    private int promptForId() {
        int id = 0;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter the ID of the winner [1-19]: "); //TODO: don't hardcode the 19
            String input = scanner.nextLine().trim();
            if (input.matches("\\d{1,2}")) {
                id = Integer.parseInt(input); // safe to do this now
                if (1 <= id && id <= 19) { // TODO: don't hardcode the 19
                    validInput = true;
                }
            }
        }
        return id;
    }

    private Reward promtForReward() {
        Reward reward = null;

        boolean validInput = false;
        while (!validInput) {
            System.out.println("Please enter [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("D|P")) {
                validInput = true;
                reward = ("D".equals(input)) ? Reward.DEBIT_CARD : Reward.PRIZES;
            }
        }

        return reward;
    }

    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("W E L C O M E  T O  T H E  D U C K  R A C E  A P P L I C A T I O N");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println();
    }

}