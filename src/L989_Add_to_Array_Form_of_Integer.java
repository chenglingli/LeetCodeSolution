import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class L989_Add_to_Array_Form_of_Integer {

    public List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> res = new ArrayList<>();

        int l = num.length;
        int i = 0;
        int curry = 0;
        int addNum = k;

        // 处理累加
        while (addNum > 0 && i < l) {
            int addedNum = addNum % 10;

            int cur = num[l - i - 1];
            cur = cur + addedNum + curry;

            curry = cur / 10;
            cur = cur % 10;

            res.add(cur);

            addNum /= 10;
            i++;
        }

        // 处理被加数剩余
        while (addNum > 0) {
            int addedNum = addNum % 10;

            int cur = addedNum + curry;

            curry = cur / 10;
            cur = cur % 10;

            res.add(cur);

            addNum /= 10;
        }

        // 处理加数剩余
        while (i < l) {
            int cur = num[l - i - 1];
            cur = cur + curry;

            curry = cur / 10;
            cur = cur % 10;

            res.add(cur);

            i++;
        }

        // 处理进位剩余
        if (curry > 0) {
            res.add(curry);
        }

        // 返回结果
        Collections.reverse(res);
        return res;
    }

    public List<Integer> addToArrayForm2(int[] num, int k) {

        LinkedList<Integer> res = new LinkedList<>();

        int l = num.length;
        int i = 0;
        int curry = 0;
        int addNum = k;

        // 处理累加
        while (addNum > 0 && i < l) {
            int addedNum = addNum % 10;

            int cur = num[l - i - 1];
            cur = cur + addedNum + curry;

            curry = cur / 10;
            cur = cur % 10;

            res.addFirst(cur);

            addNum /= 10;
            i++;
        }

        // 处理被加数剩余
        while (addNum > 0) {
            int addedNum = addNum % 10;

            int cur = addedNum + curry;

            curry = cur / 10;
            cur = cur % 10;

            res.addFirst(cur);

            addNum /= 10;
        }

        // 处理加数剩余
        while (i < l) {
            int cur = num[l - i - 1];
            cur = cur + curry;

            curry = cur / 10;
            cur = cur % 10;

            res.addFirst(cur);

            i++;
        }

        // 处理进位剩余
        if (curry > 0) {
            res.addFirst(curry);
        }

        // 返回结果
        return res;
    }

    // 该方法更为巧妙，直接将k加在个位，然后依次看进位进行累加
    public List<Integer> addToArrayForm3(int[] num, int k) {

        LinkedList<Integer> res = new LinkedList<>();

        for (int i = num.length - 1; i >= 0; i--) {
            int sum = num[i] + k;
            res.addFirst(sum % 10);
            k = sum / 10;
        }

        while (k > 0) {
            res.addFirst(k % 10);
            k /= 10;
        }

        return res;
    }

    public static void main(String[] args) {

        L989_Add_to_Array_Form_of_Integer s = new L989_Add_to_Array_Form_of_Integer();

        long sysDate1 = System.currentTimeMillis();

        int[] input = {2, 1, 5};

        List<Integer> res = s.addToArrayForm3(input, 806);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}