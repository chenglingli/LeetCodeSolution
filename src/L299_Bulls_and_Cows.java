public class L299_Bulls_and_Cows {

    /*
    1 <= secret.length, guess.length <= 1000
    secret.length == guess.length
    secret and guess consist of digits only.

    先计算bulls，然后计算cows
    用2个数字数组分别记录secret和guess中每个数字出现的次数，然后遍历数组，取两个数组中较小的数字相加即可

     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int [] digitCount1 = new int[10];
        int [] digitCount2 = new int[10];

        char[] secretArray = secret.toCharArray();
        char[] guessArray = guess.toCharArray();
        int n = secretArray.length;

        for (int i = 0 ; i < n; i++) {
            if (secretArray[i] == guessArray[i]) {
                bulls++;
            } else {
                digitCount1[secretArray[i] - '0']++;
                digitCount2[guessArray[i] - '0']++;
            }
        }

        for(int i = 0 ; i < 10; i++) {
            cows += Math.min(digitCount1[i], digitCount2[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        return sb.toString();
    }

    public static void main(String[] args) {

        L299_Bulls_and_Cows s = new L299_Bulls_and_Cows();
        long sysDate1 = System.currentTimeMillis();

//        String secret = "1123";
//        String guess = "0111";
        String secret = "1807";
        String guess = "7810";
        String res = s.getHint(secret, guess);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}