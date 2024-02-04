public class L1422_Maximum_Score_After_Splitting_a_String {

    public int maxScore(String s) {

        int n = s.length();
        int countOne = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                countOne++;
            }
        }

        int score = -1;
        int leftOne = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '1') {
                leftOne++;
            }
            int temp = (i + 1 - leftOne) + (countOne - leftOne);
            score = Math.max(temp, score);
        }

        return score;
    }

    public int maxScore2(String s) {
        char[] ch = s.toCharArray();

        int zeroCount = ch[0] == '0' ? 1 : 0;
        int oneCount = ch[ch.length - 1] == '1' ? 1 : 0;

        int maxScore = 0;
        int maxIndex = 0;
        int curScore = 0;
        for (int i = 1; i < ch.length - 1; i++) {
            curScore += ch[i] == '0' ? 1 : -1;
            if (curScore > maxScore) {
                maxScore = curScore;
                maxIndex = i;
            }
        }

        int leftLen = maxIndex;
        int rightLen = ch.length - 2 - maxIndex;

        int leftScore = maxScore;
        int rightScore = maxScore - curScore;

        int leftCount = (leftLen - leftScore) / 2 + leftScore;
        int rightCount = (rightLen - rightScore) / 2 + rightScore;

        zeroCount = zeroCount + leftCount;
        oneCount = oneCount + rightCount;
        return zeroCount + oneCount;
    }


    public int maxScore3(String s) {

        int n = s.length(), max = -n - 1, zeroCount = 0, oneCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }

            if (i < n - 1) {
                max = Math.max(zeroCount - oneCount, max);
            }
        }

        return max + oneCount;
    }

    public static void main(String[] args) {

        L1422_Maximum_Score_After_Splitting_a_String s = new L1422_Maximum_Score_After_Splitting_a_String();
        long sysDate1 = System.currentTimeMillis();

        String input = "0001010";

        int res = s.maxScore2(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}