public class Solution {

    public int minDeletionSize(String[] A) {
        int res = 0;

        if (A.length == 0) {
            return 0;
        }

        for (int i = 0; i<A[0].length();i++) {

            for (int j = 0; j < A.length-1 ; j++) {
                if (A[j].charAt(i) > A[j+1].charAt(i)) {
                    res +=1;
                    j = A.length;
                }
            }

        }
        return res;
    }


    public static void main(String[] args) {

        L944_Delete_Columns_to_Make_Sorted s = new L944_Delete_Columns_to_Make_Sorted();

        long sysDate1 = System.currentTimeMillis();

        String [] A = {"zyx","wvu","tsr"};

        int res = s.minDeletionSize(A);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}