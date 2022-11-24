import java.util.Arrays;

public class L506_Relative_Ranks {

    public String[] findRelativeRanks(int[] score) {

        int[] copyScore = Arrays.copyOf(score, score.length);
        Arrays.sort(copyScore);
        String[] res = new String[score.length];

        for (int i = 0; i < score.length; i++) {
            int cur = score[i];
            int index = Arrays.binarySearch(copyScore, cur);
            index += 1;

            int place = score.length + 1 - index;
            if (place == 1) {
                res[i] = "Gold Medal";
            } else if (place == 2) {
                res[i] = "Silver Medal";
            } else if (place == 3) {
                res[i] = "Bronze Medal";
            } else {
                res[i] = String.valueOf(place);
            }
        }

        return res;
    }

    public String[] findRelativeRanks2(int[] score) {
        int len = score.length;
        int maxScore = 0;
        String[] temp = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};

        for (int num : score) {
            if (num > maxScore)
                maxScore = num;
        }

        String[] map = new String[maxScore + 1];
        for (int i = 0; i < len; i++) {
            map[score[i]] = "";
        }

        int cursor = 0;

        for (int i = maxScore; i >= 0; i--) {
            if (map[i] != null) {
                if (cursor < 3) {
                    map[i] = temp[cursor];
                } else {
                    map[i] = Integer.toString(cursor + 1);
                }
                cursor++;
            }
        }

        String[] res = new String[len];
        for (int i = 0; i < len; i++) {
            res[i] = map[score[i]];
        }
        return res;
    }

    public static void main(String[] args) {

        L506_Relative_Ranks s = new L506_Relative_Ranks();
        long sysDate1 = System.currentTimeMillis();
        int[] score = {10, 3, 8, 9, 4};
        String[] res = s.findRelativeRanks(score);
        System.out.println(Arrays.toString(Arrays.stream(res).toArray()));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}