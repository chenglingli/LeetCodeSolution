
public class L1700_Number_of_Students_Unable_to_Eat_Lunch {


    /*
    students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]

    Count students' preference of food to count
    Now we iterate the food one by one,
    and see if anyone in the left students queue will take it.

    We stop at sandwiches[k] if no one wants it,
    then n - k students are unable to eat.

    Time O(n)
    Space O(2)

     */
    public int countStudents(int[] students, int[] sandwiches) {

        int[] count = {0, 0};
        int n = students.length;
        int k;

        for (int a : students)
            count[a]++;

        for (k = 0; k < n && count[sandwiches[k]] > 0; ++k)
            count[sandwiches[k]]--;

        return n - k;
    }

    public static void main(String[] args) {

        L1700_Number_of_Students_Unable_to_Eat_Lunch s = new L1700_Number_of_Students_Unable_to_Eat_Lunch();
        long sysDate1 = System.currentTimeMillis();

        int[] students = {1, 1, 1, 0, 0, 1};
        int[] sandwiches = {1, 0, 0, 0, 1, 1};
        int res = s.countStudents(students, sandwiches);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}