import java.util.HashMap;
import java.util.Map;

public class L1640_Check_Array_Formation_Through_Concatenation {


    /*
        1 <= pieces.length <= arr.length <= 100
        sum(pieces[i].length) == arr.length
        1 <= pieces[i].length <= arr.length

        1 <= arr[i], pieces[i][j] <= 100

        The integers in arr are distinct.
        The integers in pieces are distinct
            (i.e., If we flatten pieces in a 1D array,
            all the integers in this array are distinct).
    */
    public boolean canFormArray(int[] arr, int[][] pieces) {

        // 存储pieces到Map
        Map<Integer, int[]> pieceMap = new HashMap<>();
        for (int[] piece : pieces) pieceMap.put(piece[0], piece);

        // 检索每个arr元素是否存在
        for (int i = 0; i < arr.length; i++) {
            if (pieceMap.containsKey(arr[i])) {

                int[] piece = pieceMap.get(arr[i]);
                int k = 0;

                // 首元素匹配，则进行后续元素寻找
                while (k < piece.length && i < arr.length) {
                    if (arr[i] != piece[k]) return false;
                    i++;
                    k++;
                }

                // 字典子串是否到头。如到头，母串index需要退格
                if (k != piece.length) return false;
                else i--;
                
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        L1640_Check_Array_Formation_Through_Concatenation s = new L1640_Check_Array_Formation_Through_Concatenation();
        long sysDate1 = System.currentTimeMillis();

        //        int[][] pieces = {{78, 2}, {4, 64}, {91}};
        //        int[] arr = {91, 4, 64, 78};

        int[][] pieces = {{78}, {4, 64}, {91}};
        int[] arr = {91, 4, 64, 78};

        boolean res = s.canFormArray(arr, pieces);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}