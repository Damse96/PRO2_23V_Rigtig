package opgave;

import java.util.Random;


    public class TestFindMax {
    private static final int rowindex = 2;
    private static final int colindex = 20000000;
    private static int[][] board = new int[rowindex][colindex];

    public static void main(String[] args) {

        findMax t1 = new findMax( board[0]);
        findMax t2 = new findMax( board[1]);


        fillBoard();
    // printBoard();
        long l1 = System.nanoTime();
    System.out.println("Max: " + findMax());
        try {
            System.out.println("Max: " +
                    findMaxThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long l2 = System.nanoTime();
        System.out.println("Køretiden var " + (l2 - l1) / 1000000
                + " millisekunder");
    }

    public static int findMax() {
    //TODO
        int max = 0;
        for (int i = 0; i < rowindex ; i++) {
            for (int j = 0; j < colindex; j++) {
                if (board[i][j] > max) {
                    max = board[i][j];
                }

            }

        }
        return max;
    }

    public static int findMaxThread() throws InterruptedException {
        findMax[] tk = new findMax[board.length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < board.length; i++) {
            tk[i] = new findMax(board[i]);
            tk[i].start();
        }
        for (int i = 0; i < board.length; i++) {
            tk[i].join();
            max = Math.max(max, tk[i].getMax());
        }
        return max;
    }

    public static void fillBoard() {
        Random rand = new Random();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length;
                 col++) {
                board[row][col] = rand.nextInt(1000);
            }
        }
    }

    public static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
