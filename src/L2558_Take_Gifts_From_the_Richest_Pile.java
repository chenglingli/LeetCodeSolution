public class L2558_Take_Gifts_From_the_Richest_Pile {


    /*
    1 <= gifts.length <= 10^3
    1 <= gifts[i] <= 10^9
    1 <= k <= 10^3
     */
    public long pickGifts(int[] gifts, int k) {

        for (int i = 0; i < k; i++) {
            int maxIndex = getMax(gifts);
            gifts[maxIndex] = (int) (Math.sqrt(gifts[maxIndex]));
        }

        long sum = 0;
        for (int x : gifts) {
            sum += x;
        }
        return sum;
    }

    private int getMax(int[] gifts) {
        int max = -1;
        int index = 0;
        for (int i = 0; i < gifts.length; i++) {
            if (gifts[i] > max) {
                index = i;
                max = gifts[i];
            }
        }
        return index;
    }




    public int left(int index) {
        return (index * 2) + 1;
    }

    public int right(int index) {
        return (index * 2) + 2;
    }

    public int[] buildHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            arr = heapifyDown(arr, i);
        }
        return arr;
    }

    public int[] heapifyDown(int[] arr, int index) {
        if (index >= arr.length) {
            return arr;
        }
        int index_left = left(index);
        int index_right = right(index);
        int newIndex = -1;
        if (index_right < arr.length) {
            if (arr[index_left] > arr[index] && arr[index_left] >= arr[index_right]) {
                newIndex = index_left;
            } else if (arr[index_right] > arr[index] && arr[index_right] > arr[index_left]) {
                newIndex = index_right;
            }
        } else if (index_left < arr.length && arr[index_left] > arr[index]) {
            newIndex = index_left;
        }
        if (newIndex == -1) {
            return arr;
        }

        int temp = arr[index];
        arr[index] = arr[newIndex];
        arr[newIndex] = temp;

        return heapifyDown(arr, newIndex);
    }

    public int[] TakeMax(int[] arr) {
        arr[0] = (int) Math.sqrt(arr[0]);
        return heapifyDown(arr, 0);
    }

    public long SumLeftGifts(int[] arr) {
        long sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }

    public long pickGifts2(int[] gifts, int k) {

        gifts = buildHeap(gifts);

        for (int i = 0; i < k; i++) {
            gifts = TakeMax(gifts);
        }

        return SumLeftGifts(gifts);
    }

    public static void main(String[] args) {

        L2558_Take_Gifts_From_the_Richest_Pile s = new L2558_Take_Gifts_From_the_Richest_Pile();
        long sysDate1 = System.currentTimeMillis();

        int[] gifts = {25, 64, 9, 4, 100};
        int k = 4;
        long res = s.pickGifts(gifts, k);
        System.out.println(res);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}