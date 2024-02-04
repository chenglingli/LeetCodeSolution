import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1773_Count_Items_Matching_a_Rule {

    /*
    1 <= items.length <= 104
    1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
    ruleKey is equal to either "type", "color", or "name".
    All strings consist only of lowercase letters.
     */
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;

        int index = 0;
        switch (ruleKey) {
            case "type":
                index = 0;
                break;
            case "color":
                index = 1;
                break;
            case "name":
                index = 2;
                break;
        }

        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L1773_Count_Items_Matching_a_Rule s = new L1773_Count_Items_Matching_a_Rule();
        long sysDate1 = System.currentTimeMillis();


        List<List<String>> items = new ArrayList<>();
        List<String> item1 = new ArrayList<>(Arrays.asList("phone", "blue", "pixel"));
        items.add(item1);
        List<String> item2 = new ArrayList<>(Arrays.asList("computer", "silver", "phone"));
        items.add(item2);
        List<String> item3 = new ArrayList<>(Arrays.asList("phone", "gold", "iphone"));
        items.add(item3);
        String ruleKey = "type";
        String ruleValue = "phone";

        int res = s.countMatches(items, ruleKey, ruleValue);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}