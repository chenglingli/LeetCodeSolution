public class L1678_Goal_Parser_Interpretation {


    /*

    G -> G
    () -> o
    (al) -> al

     */
    public String interpret(String command) {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < command.length()) {
            if (command.charAt(i) == 'G') {
                sb.append("G");
                i++;
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    sb.append("o");
                    i += 2;
                } else {
                    sb.append("al");
                    i += 4;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        L1678_Goal_Parser_Interpretation s = new L1678_Goal_Parser_Interpretation();
        long sysDate1 = System.currentTimeMillis();

        //        String command = "G()()()()(al)";
        String command = "(al)G(al)()()G";
        String res = s.interpret(command);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}