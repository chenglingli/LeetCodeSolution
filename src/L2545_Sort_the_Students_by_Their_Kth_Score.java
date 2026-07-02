import java.util.Arrays;

public class L2545_Sort_the_Students_by_Their_Kth_Score {

    /*
    There is a class with m students and n exams. You are given a 0-indexed m x n integer matrix score,
    where each row represents one student and score[i][j] denotes the score the ith student got in the jth exam.

    The matrix score contains distinct integers only.

    You are also given an integer k. Sort the students (i.e., the rows of the matrix) by their scores in the kth (0-indexed) exam from the highest to the lowest.

    Return the matrix after sorting it.



    Example 1:
    Input: score = [[10,6,9,1],[7,5,11,2],[4,8,3,15]], k = 2
    Output: [[7,5,11,2],[10,6,9,1],[4,8,3,15]]
    Explanation: In the above diagram, S denotes the student, while E denotes the exam.
    - The student with index 1 scored 11 in exam 2, which is the highest score, so they got first place.
    - The student with index 0 scored 9 in exam 2, which is the second highest score, so they got second place.
    - The student with index 2 scored 3 in exam 2, which is the lowest score, so they got third place.
    Example 2:


    Input: score = [[3,4],[5,6]], k = 0
    Output: [[5,6],[3,4]]
    Explanation: In the above diagram, S denotes the student, while E denotes the exam.
    - The student with index 1 scored 5 in exam 0, which is the highest score, so they got first place.
    - The student with index 0 scored 3 in exam 0, which is the lowest score, so they got second place.


    Constraints:

    m == score.length
    n == score[i].length
    1 <= m, n <= 250
    1 <= score[i][j] <= 105
    score consists of distinct integers.
    0 <= k < n

     */
    public int[][] sortTheStudents(int[][] score, int k) {
        // 按照第k列进行j降序排序矩阵
        Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));
        return score;
    }

    public int[][] sortTheStudents2(int[][] score, int k) {
        final int N = score.length;
        for (int i = 0; i < N; i++) {
            int[] max = findMax(score, i, k);
            if (score[i][k] != max[0]) {
                swap(score, i, max[1]);
            }
        }

        return score;
    }

    int[] findMax(int[][] grid, int start, int k) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = start; i < grid.length; i++) {
            if (max < grid[i][k]) {
                max = grid[i][k];
                idx = i;
            }
        }

        return new int[]{max, idx};
    }

    void swap(int[][] grid, int i, int j) {
        int[] temp = grid[i];
        grid[i] = grid[j];
        grid[j] = temp;
    }

    public static void main(String[] args) {

        L2545_Sort_the_Students_by_Their_Kth_Score s = new L2545_Sort_the_Students_by_Their_Kth_Score();
        long sysDate1 = System.currentTimeMillis();

        int[][] score = {{10, 6, 9, 1}, {7, 5, 11, 2}, {4, 8, 3, 15}};
        int k = 3;

        int[][] res = s.sortTheStudents(score, k);
        System.out.println(Arrays.deepToString(res));


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}