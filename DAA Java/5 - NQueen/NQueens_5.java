import java.util.Scanner;

public class NQueens_5 {

    static int N;
    static int[][] board;

    static boolean isAttack(int i, int j) {
        // Checking if there is a queen in the row or column
        for (int k = 0; k < N; k++) {
            if (board[i][k] == 1 || board[k][j] == 1) {
                return true;
            }
        }

        // Checking diagonals
        for (int k = 0; k < N; k++) {
            for (int l = 0; l < N; l++) {
                if (k + l == i + j || k - l == i - j) {
                    if (board[k][l] == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean nQueen(int n) {
        // If n is 0, solution found
        if (n == 0) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // Checking if we can place a queen here or not
                // Queen will not be placed if the place is being attacked or already occupied
                if (!isAttack(i, j) && board[i][j] != 1) {
                    board[i][j] = 1;
                    // Recursion
                    // Whether we can put the next queen with this arrangement or not
                    if (nQueen(n - 1)) {
                        return true;
                    }
                    board[i][j] = 0;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of queens: ");
        N = sc.nextInt();
        System.out.println("Entered number of queens: " + N);

        // Chessboard - NxN matrix with all elements 0
        board = new int[N][N];

        nQueen(N);

        System.out.println("Solution for " + N + " - Queens Problem:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
