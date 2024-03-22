import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L380_Insert_Delete_GetRandom_O1 {

    public static void main(String[] args) {

        L380_Insert_Delete_GetRandom_O1 s = new L380_Insert_Delete_GetRandom_O1();
        long sysDate1 = System.currentTimeMillis();


        RandomizedSet randomizedSet = new RandomizedSet();

        System.out.println(randomizedSet.insert(1));
        // Inserts 1 to the set. Returns true as 1 was inserted successfully.

        System.out.println(randomizedSet.remove(2));
        // Returns false as 2 does not exist in the set.

        System.out.println(randomizedSet.insert(2));
        // Inserts 2 to the set, returns true. Set now contains [1,2].

        System.out.println(randomizedSet.getRandom());
        // getRandom() should return either 1 or 2 randomly.

        System.out.println(randomizedSet.remove(1));
        // Removes 1 from the set, returns true. Set now contains [2].

        System.out.println(randomizedSet.insert(2));
        // 2 was already in the set, so return false.

        System.out.println(randomizedSet.getRandom());
        // Since 2 is the only number in the set, getRandom() will always return 2.

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}

class RandomizedSet {

    private Map<Integer, Integer> m;
    private List<Integer> l;

    public RandomizedSet() {
        this.m = new HashMap<>();
        this.l = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (this.m.containsKey(val)) {
            return false;
        }

        l.add(val);
        m.put(val, l.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (this.m.containsKey(val)) {
            int index = this.m.get(val);
            int lastElement = this.l.get(this.l.size() - 1);
            this.l.set(index, lastElement);
            this.m.put(lastElement, index);
            this.l.remove(this.l.size() - 1);
            this.m.remove(val);
            return true;
        }

        return false;
    }

    public int getRandom() {
        return this.l.get((int) (Math.random() * this.l.size()));
    }
}