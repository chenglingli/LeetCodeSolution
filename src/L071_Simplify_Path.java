import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

public class L071_Simplify_Path {

    public String simplifyPath2(String path) {

        if (path.isEmpty())
            return path;

        StringBuilder simplifiedPath = new StringBuilder();
        String[] tokens = path.split("/");
        Deque<String> q = new LinkedList<>();
        int pop = 0;

        for (int i = tokens.length - 1; i >= 0; i--) {

            String token = tokens[i];

            if (token.isEmpty() || ".".equals(token) || "_".equals(token))
                continue;

            if ("..".equals(token)) {
                pop++;
            } else {
                if (pop > 0) {
                    pop--;
                } else {
                    q.add(token);
                }
            }

        }

        while (!q.isEmpty()) {
            simplifiedPath.append("/" + q.removeLast());
        }

        return simplifiedPath.toString().equals("") ? "/" : simplifiedPath.toString();
    }


    public String simplifyPath(String path) {

        Stack<String> blocks = new Stack<>();
        StringBuilder block = new StringBuilder();

        path = path + "/";

        for (int i = 0; i < path.length(); i++) {

            if (path.charAt(i) == '/') {
                if (block.toString().equals("..") && blocks.size() > 0) {
                    blocks.pop();
                } else if (!Objects.equals(block.toString(), "")
                        && !Objects.equals(block.toString(), ".")
                        && !Objects.equals(block.toString(), "..")) {
                    blocks.push(block.toString());
                }

                block = new StringBuilder();
                continue;
            }

            block.append(path.charAt(i));
        }

        StringBuilder simplified = new StringBuilder();
        while (blocks.size() > 0) {
            simplified.insert(0, "/" + blocks.peek());
            blocks.pop();
        }

        return simplified.toString().equals("") ? "/" : simplified.toString();
    }

    public static void main(String[] args) {

        L071_Simplify_Path s = new L071_Simplify_Path();

        long sysDate1 = System.currentTimeMillis();
        int x = 12;
        String res = s.simplifyPath("/a//b////c/d//././/..");
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}