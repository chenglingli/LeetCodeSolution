import java.util.Arrays;

class Person implements Comparable<Person> {
    String name;
    int height;

    Person(String n, int h) {
        this.name = n;
        this.height = h;
    }

    @Override
    public int compareTo(Person o) {
        return o.height - this.height;
    }
}

public class L2418_Sort_the_People {

    /*
    n == names.length == heights.length
    1 <= n <= 103
    1 <= names[i].length <= 20
    1 <= heights[i] <= 105
    names[i] consists of lower and upper case English letters.
    All the values of heights are distinct.
     */
    public String[] sortPeople(String[] names, int[] heights) {
        Person[] pList = new Person[names.length];
        for (int i = 0; i < names.length; i++) {
            Person p = new Person(names[i], heights[i]);
            pList[i] = p;
        }

        Arrays.sort(pList);

        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            res[i] = pList[i].name;
        }

        return res;
    }


    public String[] sortPeople2(String[] names, int[] heights) {
        quickSort(names, heights, 0, heights.length - 1);
        return names;
    }

    private static void quickSort(String[] names, int[] heights, int lowerBound, int upperBound) {
        if (lowerBound < upperBound) {
            int pivotIndex = partition(names, heights, lowerBound, upperBound);
            quickSort(names, heights, lowerBound, pivotIndex - 1);
            quickSort(names, heights, pivotIndex + 1, upperBound);
        }
    }

    private static int partition(String[] names, int[] heights, int lowerBound, int upperBound) {

        int pivot = heights[lowerBound];
        int start = lowerBound;
        int end = upperBound;

        while (start < end) {

            while (heights[start] >= pivot && start < end) start++;
            while (heights[end] < pivot) end--;

            if (start < end) {
                swap(heights, start, end);
                swap(names, start, end);
            }
        }

        swap(heights, lowerBound, end);
        swap(names, lowerBound, end);
        return end;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {

        L2418_Sort_the_People s = new L2418_Sort_the_People();
        long sysDate1 = System.currentTimeMillis();

        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};
        String[] res = s.sortPeople(names, heights);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}