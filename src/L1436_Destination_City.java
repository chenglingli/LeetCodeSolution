import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L1436_Destination_City {


    /*

    A - B
    B - C
    C - D


     */
    public String destCity(List<List<String>> paths) {

        Map<String, Integer> count = new HashMap<>();
        for (List<String> pair : paths) {

            count.put(pair.get(0), 0);

            String toKey = pair.get(1);
            if (!count.containsKey(toKey)) {
                count.put(toKey, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return "";
    }

    public String destCity2(List<List<String>> paths) {

        HashMap<String, String> h = new HashMap<>();

        for (List<String> path : paths) {
            h.put(path.get(0), path.get(1));
        }

        String first = paths.get(0).get(0);
        String result;

        while (true) {
            if (h.containsKey(first))
                first = h.get(first);
            else {
                result = first;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        L1436_Destination_City s = new L1436_Destination_City();
        long sysDate1 = System.currentTimeMillis();


        List<List<String>> paths = new ArrayList<>();
        List<String> v1 = new ArrayList<>();
        v1.add("London");
        v1.add("New York");


        List<String> v2 = new ArrayList<>();
        v2.add("New York");
        v2.add("Lima");


        List<String> v3 = new ArrayList<>();
        v3.add("Lima");
        v3.add("Sao Paulo");

        paths.add(v1);
        paths.add(v3);
        paths.add(v2);

        String res = s.destCity(paths);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}