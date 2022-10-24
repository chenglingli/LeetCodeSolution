public class L941_Valid_Mountain_Array {

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int i = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        while (i < arr.length-1 && arr[i] < arr[i+1]) {
            i++;
            flag1 = true;
        }

        while (i < arr.length-1 && arr[i] > arr[i+1]) {
            i++;
            flag2 = true;
        }

        return flag1 && flag2 && i == arr.length - 1;
    }

    public static void main(String[] args) {

        L941_Valid_Mountain_Array s = new L941_Valid_Mountain_Array();

        long sysDate1 = System.currentTimeMillis();

        int[] arr = {1,2,3,4,2};

        boolean res = s.validMountainArray(arr);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}