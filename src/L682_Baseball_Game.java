import java.util.ArrayList;
import java.util.List;

public class L682_Baseball_Game {


    public int calPoints(String[] operations) {

        int res = 0;
        List<Integer> resList = new ArrayList<>();

        for (String operation : operations) {

            switch (operation) {
                case "+":
                    resList.add(resList.get(resList.size() - 1) + resList.get(resList.size() - 2));
                    break;
                case "D":
                    resList.add(resList.get(resList.size() - 1) << 1);
                    break;
                case "C":
                    resList.remove(resList.get(resList.size() - 1));
                    break;
                default:
                    resList.add(Integer.parseInt(operation));
                    break;
            }
        }

        for (Integer i : resList) {
            res += i;
        }

        return res;
    }

    public int calPoints2(String[] operations) {

        int[] record = new int[operations.length];
        int sum = 0, index = 0;

        for (String operation : operations) {
            switch (operation) {
                case "C":
                    record[--index] = 0;
                    break;
                case "D":
                    record[index++] = record[index - 2] << 1;
                    break;
                case "+":
                    record[index++] = record[index - 2] + record[index - 3];
                    break;
                default:
                    record[index++] = Integer.parseInt(operation);
                    break;
            }
        }//end for loop

        while (index > 0)
            sum += record[--index];

        return sum;
    }//end calPoints

    public static void main(String[] args) {

        L682_Baseball_Game s = new L682_Baseball_Game();
        long sysDate1 = System.currentTimeMillis();

        String[] operations = {"5","-2","4","C","D","9","+","+"};
        int res = s.calPoints(operations);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}