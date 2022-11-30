import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1078_Occurrences_After_Bigram {

    public String[] findOcurrences(String text, String first, String second) {

        List<String> res = new ArrayList<>();
        String[] inputArray = text.split(" ");

        for (int i = 0; i < inputArray.length - 2; i++) {
            if (inputArray[i].equals(first) && inputArray[i + 1].equals(second)) {
                res.add(inputArray[i + 2]);
            }
        }

        // Return output list (converted to array).
        String[] arrayedOutput = new String[res.size()];
        return res.toArray(arrayedOutput);
    }

    public static void main(String[] args) {

        L1078_Occurrences_After_Bigram s = new L1078_Occurrences_After_Bigram();

        long sysDate1 = System.currentTimeMillis();

        String text = "we will we will rock you";
        String first = "we";
        String second = "will";

        String[] res = s.findOcurrences(text, first, second);

        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}