package basic.knowledge.henry.algorithm.InterviewExperience.canva;

class Leetcode348 {
    int[] vertical;
    int[] horizon;

    int diagonal;

    int antiDiagonal;

    int winner;


    public Leetcode348(int n) {
        vertical = new int[n];
        horizon = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
        winner = 0;
    }

    public int move(int row, int col, int player) {
        if (winner != 0) {
            return winner;
        }

        if (player == 1) {
            vertical[col]++;
            horizon[row]++;
            if(row == col){
                diagonal++;
            }
            if(row + col == vertical.length - 1){
                antiDiagonal++;
            }

            if (checkWinner(row, col, 1)) {
                return player;
            }
        } else if (player == 2) {
            vertical[col]--;
            horizon[row]--;
            if(row == col){
                diagonal--;
            }
            if(row + col == vertical.length - 1){
                antiDiagonal--;
            }
            if (checkWinner(row, col, -1)) {
                return player;
            }
        }
        return 0;
    }

    private boolean checkWinner(int row, int col, int num) {
        int len = vertical.length;
        if (num == 1) {
            if (vertical[col] == len) {
                return true;
            }

            if (horizon[row] == len) {
                return true;
            }

            if (diagonal == len) {
                return true;
            }

            if (antiDiagonal == len) {
                return true;
            }
        } else if (num == -1) {
            if (vertical[col] == -len) {
                return true;
            }

            if (horizon[row] == -len) {
                return true;
            }

            if (diagonal == -len) {
                return true;
            }

            if (antiDiagonal == -len) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
