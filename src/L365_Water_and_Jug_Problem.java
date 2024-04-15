import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class L365_Water_and_Jug_Problem {

    /*
        1 <= x, y, target <= 10^3
        GCD数学办法
        数学原理是，如果x和y的最大公约数能够整除z，那么z就可以由x和y的组合得到。
        例如，x=3，y=5，z=4，那么3和5的最大公约数是1，1可以整除4，所以4可以由3和5的组合得到。

     */
    public boolean canMeasureWater2(int x, int y, int target) {
        if (target > x + y) return false;

        // If target is divisible by GCD of x and y, it's possible
        return target % gcd(x, y) == 0;
    }

    // Helper method to calculate GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    class State {
        int x, y;

        State(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }

    /*
    广度优先搜索办法
    一共存在6种操作：
    1. x倒入y
    2. y倒入x
    3. x倒空
    4. y倒空
    5. x满
    6. y满

     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y == z)
            return true;
        if (x + y < z)
            return false;

        // cannot measure odd capacity using even capacity jugs
        if (x % 2 == 0 && y % 2 == 0 && z % 2 != 0)
            return false;

        // state visited HashSet of jugs
        HashSet<String> visited = new HashSet<>();
        State start = new State(0, 0);
        Queue<State> q = new LinkedList<>();
        q.add(start);

        // run a bfs. don't add already visited states
        while (q.size() > 0) {

            int n = q.size();
            State curr = q.poll();

            // 找到目标值
            if (curr.x + curr.y == z)
                return true;
            visited.add(curr.x + "," + curr.y);

            int newY, newX;


            // 操作1，x倒入y
            newX = curr.x - Math.min(curr.x, y - curr.y);
            newY = curr.y + Math.min(curr.x, y - curr.y);
            if (!visited.contains(newX + "," + newY))
                q.add(new State(newX, newY));

            // 操作2，y倒入x
            newX = curr.x + Math.min(curr.y, x - curr.x);
            newY = curr.y - Math.min(curr.y, x - curr.x);
            if (!visited.contains(newX + "," + newY))
                q.add(new State(newX, newY));

            // 操作3，清空x
            newX = 0;
            newY = curr.y;//same
            if (!visited.contains(newX + "," + newY))
                q.add(new State(newX, newY));

            // 操作4，清空y
            newX = curr.x;//same
            newY = 0;
            if (!visited.contains(newX + "," + newY))
                q.add(new State(newX, newY));

            // 操作5，装满x
            newX = x;//max capacity
            newY = curr.y;
            if (!visited.contains(newX + "," + newY))
                q.add(new State(newX, newY));

            // 操作6，装满y
            newX = curr.x;
            newY = y;//max capacity
            if (!visited.contains(newX + "," + newY))
                q.add(new State(newX, newY));
        }

        return false;
    }

    public static void main(String[] args) {

        L365_Water_and_Jug_Problem s = new L365_Water_and_Jug_Problem();

        long sysDate1 = System.currentTimeMillis();

        int x = 5;
        int y = 3;
        int target = 4;
        boolean res = s.canMeasureWater(x, y, target);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}