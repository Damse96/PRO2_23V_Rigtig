package opgave;


public class findMax extends Thread {


    private int max = Integer.MIN_VALUE;
    private int[] board;

    public findMax(int[] board) {
        super();
        this.board = board;
    }

    public void run() {
        for (int i = 0; i < board.length; i++) {
            max = Math.max(max, board[i]);
        }
    }

    public int getMax() {
        return max;
    }

}



