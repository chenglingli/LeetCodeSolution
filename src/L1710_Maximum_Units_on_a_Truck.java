import java.util.Arrays;
import java.util.Comparator;

public class L1710_Maximum_Units_on_a_Truck {


    public int maximumUnits(int[][] boxTypes, int truckSize) {

        int ans = 0;
        int curSize = 0;

        Arrays.sort(boxTypes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });


        for (int[] boxType : boxTypes) {

            if (curSize + boxType[0] <= truckSize) {
                ans += boxType[0] * boxType[1];
                curSize += boxType[0];
            } else {
                ans += (truckSize - curSize) * boxType[1];
                return ans;
            }
        }

        return ans;
    }

    /*
    1 <= boxTypes.length <= 1000
    1 <= numberOfBoxes, numberOfUnitsPerBox <= 1000
    1 <= truckSize <= 106

    桶 收集 逻辑

     */
    public int maximumUnits2(int[][] boxTypes, int truckSize) {

        int[] unitCount = new int[10001];
        for (int[] boxType : boxTypes) {
            unitCount[boxType[1]] += boxType[0];
        }

        int count = 0;
        for (int i = unitCount.length - 1; i >= 0; i--) {
            if (unitCount[i] != 0) {
                int min = Math.min(truckSize, unitCount[i]);
                count += min * i;
                truckSize -= min;

                if (truckSize == 0)
                    return count;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        L1710_Maximum_Units_on_a_Truck s = new L1710_Maximum_Units_on_a_Truck();
        long sysDate1 = System.currentTimeMillis();

        int[][] boxTypes = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        int truckSize = 10;
        int res = s.maximumUnits(boxTypes, truckSize);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}