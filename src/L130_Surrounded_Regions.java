public class L130_Surrounded_Regions {

    public void solve(char[][] board) {

        int height = board.length;
        if (height == 0) {
            return;
        }
        int width = board[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == height - 1 || j == width - 1) {
                    solveDFS(board, i, j);
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '$') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void solveDFS(char[][] board, int i, int j) {
        if (board[i][j] == 'O') {
            board[i][j] = '$';
            if (i > 0 && board[i - 1][j] == 'O')
                solveDFS(board, i - 1, j);
            if (j < board[i].length - 1 && board[i][j + 1] == 'O')
                solveDFS(board, i, j + 1);
            if (i < board.length - 1 && board[i + 1][j] == 'O')
                solveDFS(board, i + 1, j);
            if (j > 1 && board[i][j - 1] == 'O')
                solveDFS(board, i, j - 1);
        }
    }

    public static void main(String[] args) {

        L130_Surrounded_Regions s = new L130_Surrounded_Regions();

        long sysDate1 = System.currentTimeMillis();

        char[][] board = {
                {'X', 'O', 'X', 'X'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X'}};


        s.solve(board);

        int height = board.length;
        int width = board[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(board[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}