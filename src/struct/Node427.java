package struct;

public class Node427 {

    public boolean val;
    public boolean isLeaf;
    public Node427 topLeft;
    public Node427 topRight;
    public Node427 bottomLeft;
    public Node427 bottomRight;


    public Node427() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node427(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node427(boolean val, boolean isLeaf, Node427 topLeft, Node427 topRight, Node427 bottomLeft, Node427 bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

}
