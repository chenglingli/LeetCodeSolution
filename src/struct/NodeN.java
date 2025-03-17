package struct;

import java.util.List;

public class NodeN {
    public int val;
    public List<NodeN> children;

    public NodeN() {}

    public NodeN(int _val) {
        val = _val;
    }

    public NodeN(int _val, List<NodeN> _children) {
        val = _val;
        children = _children;
    }
}