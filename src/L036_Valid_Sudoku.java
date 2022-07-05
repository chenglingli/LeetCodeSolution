import java.util.ArrayList;
import java.util.List;

public class L036_Valid_Sudoku {

    public boolean isValidSudoku(char[][] board) {

        List<Character>[] rowExistList = new List[9];
        List<Character>[] ColumnExistList = new List[9];
        List<Character>[] gridExistList = new List[9];

        for (int i = 0; i < 9; i++) {
            rowExistList[i] = new ArrayList<>();
            ColumnExistList[i] = new ArrayList<>();
            gridExistList[i] = new ArrayList<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') {

                    // 行(
                    if (rowExistList[j].contains(board[i][j])) {
                        return false;
                    } else {
                        rowExistList[j].add(board[i][j]);
                    }

                    // 列
                    if (ColumnExistList[i].contains(board[i][j])) {
                        return false;
                    } else {
                        ColumnExistList[i].add(board[i][j]);
                    }

                    // 九宫格
                    int x = (i / 3) * 3 + j / 3;
                    if (gridExistList[x].contains(board[i][j])) {
                        return false;
                    } else {
                        gridExistList[x].add(board[i][j]);
                    }
                }

            }
        }

        return true;
    }

    public static void main(String[] args) {

        L036_Valid_Sudoku s = new L036_Valid_Sudoku();

        long sysDate1 = System.currentTimeMillis();

        char[][] board =
                {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        boolean res = s.isValidSudoku(board);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }

}