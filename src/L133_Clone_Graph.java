import struct.GraphNode;

import java.util.*;

public class L133_Clone_Graph {

    /*

     if (!node) return NULL;
    map<Node*, Node*> m;
    queue<Node*> q;
    q.push(node);
    //注意下vector<Node*>{}写法
    Node* clone = new Node(node->val, vector<Node*>{});
    m[node] = clone;

    while (!q.empty())
    {
        Node* t = q.front();
        q.pop();
        for (Node* nei : t->neighbors)
        {
            //nei是原节点，m[nei]是复制节点，凡是
            //m[xx]都是复制节点
            if (!m.count(nei))
            {
                m[nei] = new Node(nei->val,vector<Node*>{});
                q.push(nei);
            }
            m[t]->neighbors.push_back(m[nei]);
        }
    }
     */
    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        }

        Map<GraphNode, GraphNode> m = new HashMap<>();
        Queue<GraphNode> q = new LinkedList<>();
        q.add(node);

        GraphNode clone = new GraphNode(node.val, new ArrayList<GraphNode>());
        m.put(node, clone);

        while (!q.isEmpty()) {
            GraphNode t = q.poll();
            for (GraphNode nei : t.neighbors) {
                if (!m.containsKey(nei)) {
                    m.put(nei, new GraphNode(nei.val, new ArrayList<GraphNode>()));
                    q.add(nei);
                }
                m.get(t).neighbors.add(m.get(nei));
            }
        }

        return clone;
    }


    public GraphNode cloneGraph2(GraphNode node) {
        if (node == null) return null;

        HashMap<Integer, GraphNode> map = new HashMap<>();
        return dfs(node, map);
    }

    private GraphNode dfs(GraphNode node, HashMap<Integer, GraphNode> map) {
        if (map.containsKey(node.val))
            return map.get(node.val);

        GraphNode clone = new GraphNode(node.val, new ArrayList<>());
        map.put(clone.val, clone);

        for (GraphNode neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, map));
        }
        return clone;
    }

    public static void main(String[] args) {

        L133_Clone_Graph s = new L133_Clone_Graph();

        long sysDate1 = System.currentTimeMillis();
        GraphNode x = new GraphNode(1);
        GraphNode res = s.cloneGraph(x);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}