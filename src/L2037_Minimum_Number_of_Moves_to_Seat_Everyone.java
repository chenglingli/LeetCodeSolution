import java.util.ArrayList;
import java.util.List;

public class L2037_Minimum_Number_of_Moves_to_Seat_Everyone {


    /*

    4 5 6
    2 3 7

    n == seats.length == students.length
    1 <= n <= 100
    1 <= seats[i], students[j] <= 100

     */
    public int minMovesToSeat(int[] seats, int[] students) {

        int res = 0;
        List<Integer> seatArray = new ArrayList<>();
        for (int x : seats) {
            seatArray.add(x);
        }
        seatArray.sort(Integer::compareTo);

        List<Integer> studentArray = new ArrayList<>();
        for (int x : students) {
            if (seatArray.contains(x)) {
                seatArray.remove((Integer) x);
            } else {
                studentArray.add(x);
            }
        }
        studentArray.sort(Integer::compareTo);

        for (int i = 0; i < seatArray.size(); i++) {
            res += Math.abs(seatArray.get(i) - studentArray.get(i));
        }

        return res;
    }

    public int minMovesToSeat2(int[] seats, int[] students) {
        int n = students.length;

        int[] seatArray = new int[101];
        int[] studentArray = new int[101];

        for (int i = 0; i < n; i++) {
            seatArray[seats[i]]++;
            studentArray[students[i]]++;
        }

        int j = 0;
        int res = 0;

        for (int i = 0; i < 101; i++) {
            if (seatArray[i] != 0) {

                // 寻找坐进来的student
                while (j < 101 && studentArray[j] == 0)
                    j++;
                res += Math.abs(i - j);

                // 待坐进来student -1
                studentArray[j]--;
                if (studentArray[j] == 0)
                    j++;

                // 可用seat - 1
                seatArray[i]--;
                if (seatArray[i] != 0)
                    i--;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L2037_Minimum_Number_of_Moves_to_Seat_Everyone s = new L2037_Minimum_Number_of_Moves_to_Seat_Everyone();
        long sysDate1 = System.currentTimeMillis();

        int[] seats = {4, 1, 5, 9};
        int[] students = {1, 3, 2, 6};
        int res = s.minMovesToSeat(seats, students);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}