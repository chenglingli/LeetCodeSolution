public class L289_Game_of_Life {

    public void gameOfLife(int[][] board) {

        int n = board.length;
        int m = board[0].length;
        int[][] arr = new int[n][m];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int count = 0;
                if (j + 1 < board[i].length && board[i][j + 1] == 1) {
                    count++;
                }
                if (j - 1 >= 0 && board[i][j - 1] == 1) {
                    count++;
                }
                if (i + 1 < board.length && board[i + 1][j] == 1) {
                    count++;
                }
                if (i - 1 >= 0 && board[i - 1][j] == 1) {
                    count++;
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (board[i - 1][j - 1] == 1) {
                        count++;
                    }
                }
                if (i - 1 >= 0 && j + 1 < board[i].length) {
                    if (board[i - 1][j + 1] == 1) {
                        count++;
                    }
                }
                if (i + 1 < board.length && j - 1 >= 0) {
                    if (board[i + 1][j - 1] == 1) {
                        count++;
                    }
                }
                if (i + 1 < board.length && j + 1 < board[i].length) {
                    if (board[i + 1][j + 1] == 1) {
                        count++;
                    }
                }
                //System.out.print(count+" ");
                if (board[i][j] == 0) {
                    if (count == 3) {
                        arr[i][j] = 1;
                    }
                }
                if (board[i][j] == 1) {
                    if (count < 2) {
                        arr[i][j] = 0;
                    } else if (count > 3) {
                        arr[i][j] = 0;
                    } else {
                        arr[i][j] = 1;
                    }
                }


            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = arr[i][j];
            }
        }


    }


    public void gameOfLifeInPlace(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                checkNeighbors(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private void checkNeighbors(int[][] board, int i, int j) {

        boolean isLive = board[i][j] == 1;

        int count = 0;
        // Top row
        if (i - 1 >= 0) {
            count += (j - 1 >= 0 && board[i - 1][j - 1] > 0) ? 1 : 0;
            count += (board[i - 1][j] > 0) ? 1 : 0;
            count += (j + 1 < board[i].length && board[i - 1][j + 1] > 0) ? 1 : 0;
        }

        count += (j - 1 >= 0 && board[i][j - 1] > 0) ? 1 : 0;
        count += (j + 1 < board[i].length && board[i][j + 1] > 0) ? 1 : 0;

        // Bottom row
        if (i + 1 < board.length) {
            count += (j - 1 >= 0 && board[i + 1][j - 1] > 0) ? 1 : 0;
            count += (board[i + 1][j] > 0) ? 1 : 0;
            count += (j + 1 < board[i].length && board[i + 1][j + 1] > 0) ? 1 : 0;
        }

        // To solve this in place, 2 will represent live before then dead
        // and -1 will represent dead before then live
        if (isLive && (count < 2 || count > 3)) {
            board[i][j] = 2;
        } else if (!isLive && count == 3) {
            board[i][j] = -1;
        }
    }

    public static void main(String[] args) {

        L289_Game_of_Life s = new L289_Game_of_Life();
        long sysDate1 = System.currentTimeMillis();

        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};

        s.gameOfLife(board);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}