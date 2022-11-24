public class L953_Verifying_an_Alien_Dictionary {

    public boolean isAlienSorted(String[] words, String order) {

        for (int i = 0; i < words.length - 1; i++) {
            if (!Sorted(words[i], words[i + 1], order)) {
                return false;
            }
        }

        return true;
    }

    private boolean Sorted(String a, String b, String order) {

        if (a.equals(b)) {
            return true;
        }

        int i = 0;
        while (i < a.length() && i < b.length()) {
            char chA = a.charAt(i);
            char chB = b.charAt(i);
            if (chA != chB) {
                return order.indexOf(chA) < order.indexOf(chB);
            }
            i++;
        }

        return a.length() < b.length();
    }

    public static void main(String[] args) {

        L953_Verifying_an_Alien_Dictionary s = new L953_Verifying_an_Alien_Dictionary();

        long sysDate1 = System.currentTimeMillis();

        String[] words = {"hello", "hello"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        boolean res = s.isAlienSorted(words, order);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}