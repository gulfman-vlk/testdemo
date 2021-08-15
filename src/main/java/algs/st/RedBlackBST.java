package algs.st;

import static edu.princeton.cs.algs4.StdIn.isEmpty;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int n;
        boolean color;

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            this.n = n;
            this.color = color;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.n;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    /**
     * 树的左旋方法，通过此方法用以使得节点右边为红色连接的的节点转向左侧，以满足红黑树规范
     *
     * @param h 一个错误的2-3节点树父节点方式
     * @return
     */
    private Node rotateLeft(Node h) {
        //定义另一个节点
        Node x = h.right;
        //把x节点的左边放置在h节点的右侧
        h.right = x.left;
        x.left = h;

//        把h节点的上节点颜色移到x节点上，并且把h节点和x节点的连接变为红色
        x.color = h.color;
        h.color = RED;

//        更新h和x的节点中的N的个数
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);

        return x;

    }

    /**
     * 树的右旋方法，通过此方法用以使得节点右边为红色连接的的节点转向左侧，以满足红黑树规范
     *
     * @param h 一个错误的2-3节点树父节点方式
     * @return
     */
    private Node rotateRight(Node h) {
        //定义另一个节点
        Node x = h.left;
        //把x节点的右边放置在h节点的左侧
        h.left = x.right;
        x.right = h;

//        把h节点的上节点颜色移到x节点上，并且把h节点和x节点的连接变为红色
        x.color = h.color;
        h.color = RED;

//        更新h和x的节点中的N的个数
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);

        return x;

    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) return new Node(key, value, 1, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, value);
        else if (cmp > 0) h.right = put(h.right, key, value);
        else h.val = value;
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.n = size(h.left) + size(h.right) + 1;
        return h;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    /**
     * 该方法仅仅是使得当前节点的父连接为红色，而和左右连接的颜色变为黑色。（注意：不会取反颜色）
     * @param h 操作节点
     */
    private void flipColors(Node h) {

        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
/*
* 删除最小的键，实现红黑树的deleteMin方法，为了实现在删除最小元素后，整个树的完美平衡，必须保证要删除的节点不是2节点，即最终使得要删除的节点的父节点为红色连接
* */
    private Node moveRedLeft(Node h){
        //假设节点h为红色，h.left和h.left.left都是黑色，将h.left或者h.left的子节点之一变红
        flipColor(h);
        //判断当前节点的右节点是否是个3节点
        if(isRed(h.right.left))
        {
            h.right=rotateRight(h.right);
            h=rotateLeft(h);
        }
        return h;
    }

    private void flipColor(Node h) {
        h.color=BLACK;
        h.left.color=RED;
        h.right.color=RED;
    }

    //删除元素从根元素开始，
    public void deleteMin(){
        //如果根节点的左右节点都不为红线，则根节点的父连接为红线
        if(!isRed(root.left)&&!isRed(root.right))
            root.color=RED;
        root=deleteMin(root);
        if(!isEmpty()) root.color=BLACK;
    }
    private Node deleteMin(Node h){
        //如果左节点为空则返回null
        if(h.left==null)
            return null;
        //如果当前节点的左节点和当前节点的左节点的左节点都不是红线，
        if(!isRed(h.left)&&!isRed(h.left.left))
            h=moveRedLeft(h);
        h.left=deleteMin(h.left);
        return  balance(h);
    }

    private Node balance(Node h) {
        if(isRed(h.right))h=rotateLeft(h);

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.n = size(h.left) + size(h.right) + 1;
        return h;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {

    }
}
