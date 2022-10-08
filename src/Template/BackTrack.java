package Template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrack {


    public void backTrack(
            List<List<Integer>> res,    /* 结果容器 */
            List<Integer> ans,          /* 临时容器 */
            int[] num,                  /* 原数组 */
            int start,                  /* 起始位置 */
            int target                  /* 目标值 */
    ) {


        /* 剪枝 - 条件 */
        if (target < 0) {
            return;
        }

        /* 结果容器收集 - 条件 */
        if (0 == target) {
            res.add(new ArrayList<>(ans));
            return;
        }

        /* 回溯过程 - 循环候选数组 */
        for (int i = start; i < num.length; i++) {

            // 这里也可能有剪枝条件，比如去除重复元素
            if (num[i] % 2 == 0) {
                continue;
            }

            // 加入
            ans.add(num[i]);

            // 回溯 - 变更位置、目标值
            backTrack(res, ans, num, i, target - num[i]);

            // 取出
            ans.remove(ans.size() - 1);
        }
    }


    // sample 1 - 组合值等于某个sum，可以重复利用
    public void backTrack(List<List<Integer>> res, int start, List<Integer> ans, int[] num, int target) {

        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(ans));
        } else {
            for (int i = start; i < num.length; i++) {

                ans.add(num[i]);
                backTrack(res, i, ans, num, target - num[i]);
                ans.remove(ans.size() - 1);
            }
        }
    }

    // sample 2 - 全排列
    public void backTrack(List<List<Integer>> res, List<Integer> tmp, int[] num, int target, boolean[] used) {

        if (tmp.size() == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < num.length; i++) {

            if (used[i]) {
                continue;
            }

            if (i > 0 && num[i] == num[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            tmp.add(num[i]);

            backTrack(res, tmp, num, target, used);

            tmp.remove(tmp.size() - 1);
            used[i] = false;
        }

    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length != 0) {
            List<Integer> ans = new ArrayList<>();
            backTrack(res, ans, candidates, 0, target);
        }
        return res;
    }

    public static void main(String[] args) {

        BackTrack s = new BackTrack();

        long sysDate1 = System.currentTimeMillis();

        int[] input = {1, 2, 3, 4, 5};
        List<List<Integer>> res = s.combinationSum(input, 8);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }

}
