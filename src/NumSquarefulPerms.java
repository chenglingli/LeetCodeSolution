import java.util.HashSet;
import java.util.Set;

public class NumSquarefulPerms {

    public int numSquarefulPerms(int[] A) {
        int res = 0;

        Set<int[]> fullSortRes = new HashSet<>();
        fullSort(fullSortRes, A, 0, A.length-1);

        for (int[] temp : fullSortRes) {
            if (isSquareful(temp)) {
                res += 1;
            }
        }

        return res;
    }

    private void fullSort(Set<int[]> res, int[] arr, int start, int end) {
        // 递归终止条件
        if (start == end) {
            int [] sample = arr.clone();

            boolean addTag = true;
            for (int[] data : res) {
                if (equals(data, sample)) {
                    addTag = false;
                    break;
                }
            }

            if (addTag) {
                res.add(sample);
            }

            return;
        }
        for (int i = start; i <= end; i++) {
            swap(arr, i, start);
            fullSort(res, arr, start + 1, end);
            swap(arr, i, start);
        }
    }

    private boolean equals(int [] data1, int [] data2) {
        for (int i = 0; i < data1.length; i++) {
            if (data1[i] != data2[i]) {
                return false;
            }
        }
        return true;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private boolean isSquareful(int[] A) {
        for (int i = 0 ; i < A.length-1 ; i++) {
            int temp = A[i] + A[i+1];
            if (!isSquare(temp)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSquare(int val) {
        double temp = Math.sqrt(val * 1.0);
        int tempInt = (int)temp;
        return tempInt * tempInt == val;
    }

    public static void main(String[] args) {

        NumSquarefulPerms s = new NumSquarefulPerms();

        long sysDate1 = System.currentTimeMillis();

        int[] input = {2, 2, 2};

        int res = s.numSquarefulPerms(input);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}