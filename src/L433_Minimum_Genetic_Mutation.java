import java.util.LinkedList;
import java.util.Queue;

public class L433_Minimum_Genetic_Mutation {

    /*
    0 <= bank.length <= 10
    startGene.length == endGene.length == bank[i].length == 8
    startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].

     使用广度优先搜索
     */
    public int minMutation(String startGene, String endGene, String[] bank) {

        // 无需变换
        if (startGene.equals(endGene)) {
            return 0;
        }

        // 记录 bank 中基因序列是否被访问过
        boolean[] visited = new boolean[bank.length];

        // 记录基因序列的变化次数
        int count = 0;

        // 使用广度优先搜索
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);

        while (queue.size() > 0) {

            // 一轮出队列
            int size = queue.size();
            while (size > 0) {

                String gene = queue.poll();
                size--;

                for (int i = 0; i < bank.length; i++) {
                    if (visited[i]) {
                        continue;
                    }

                    boolean isMutation = isMutation(gene, bank[i]);
                    if (isMutation) {

                        // 找到变换路径
                        if (bank[i].equals(endGene)) {
                            return count + 1;
                        }

                        visited[i] = true;
                        queue.add(bank[i]);
                    }
                }

            }

            // 一轮出队列增加步数
            count++;
        }

        return -1;
    }

    private boolean isMutation(String gene1, String gene2) {
        int diff = 0;
        for (int i = 0; i < 8; i++) {
            if (gene1.charAt(i) != gene2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }


    public static void main(String[] args) {

        L433_Minimum_Genetic_Mutation s = new L433_Minimum_Genetic_Mutation();
        long sysDate1 = System.currentTimeMillis();

        //        String startGene = "AACCGGTT";
        //        String endGene = "AAACGGTA";
        //        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};

        String startGene = "AAAACCCC";
        String endGene = "CCCCCCCC";
        String[] bank = {"AAAACCCA", "AAACCCCA", "AACCCCCA",
                "AACCCCCC", "ACCCCCCC", "CCCCCCCC",
                "AAACCCCC", "AACCCCCC"};

        int res = s.minMutation(startGene, endGene, bank);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}