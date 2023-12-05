public class L2383_Minimum_Hours_of_Training_to_Win_a_Competition {

    /*

    n == energy.length == experience.length
    1 <= n <= 100
    1 <= initialEnergy, initialExperience, energy[i], experience[i] <= 100

     */
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;

        int sumEnergy = 0;
        for (int x : energy) {
            sumEnergy += x;
        }
        if (initialEnergy <= sumEnergy) {
            ans += sumEnergy - initialEnergy + 1;
        }

        for (int x : experience) {
            if (initialExperience - x <= 0) {
                ans += x - initialExperience + 1;
                initialExperience = x + 1;
            }
            initialExperience += x;
        }

        return ans;
    }

    public static void main(String[] args) {

        L2383_Minimum_Hours_of_Training_to_Win_a_Competition s =
                new L2383_Minimum_Hours_of_Training_to_Win_a_Competition();
        long sysDate1 = System.currentTimeMillis();

        //        int initialEnergy = 5;
        //        int initialExperience = 3;
        //        int[] energy = {1, 4, 3, 2};
        //        int[] experience = {2, 6, 3, 1};

        int initialEnergy = 1;
        int initialExperience = 1;
        int[] energy = {1, 1, 1, 1};
        int[] experience = {1, 1, 1, 50};
        // 5 4 3 2 - 4
        // 48 49 50 51 - 47


        int res = s.minNumberOfHours(
                initialEnergy, initialExperience, energy, experience);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}