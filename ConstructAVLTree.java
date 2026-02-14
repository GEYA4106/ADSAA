//Program for AVL Trees
class Node {
    int data;
    int h;
    Node leftChild;
    Node rightChild;
    public Node() {
        data = 0;
        h = 0;
        leftChild = null;
        rightChild = null;
    }
    public Node(int value) {
        this.data = value;
        h = 0;
        leftChild = null;
        rightChild = null;
    }
}
class ConstructAVLTree {
    private Node root;
    public ConstructAVLTree() {
        root = null;
    }
    public void insert(int value) {
        root = insertRec(root, value);
    }
    private Node insertRec(Node node, int value) {
        if (node == null)
            return new Node(value);
        if (value < node.data)
            node.leftChild = insertRec(node.leftChild, value);
        else if (value > node.data)
            node.rightChild = insertRec(node.rightChild, value);
        else
            return node; 
        node.h = 1 + max(getHeight(node.leftChild), getHeight(node.rightChild));
        int balance = getBalance(node);
        if (balance > 1 && value < node.leftChild.data)
            return rotateRight(node);
        if (balance < -1 && value > node.rightChild.data)
            return rotateLeft(node);
        if (balance > 1 && value > node.leftChild.data) {
            node.leftChild = rotateLeft(node.leftChild);
            return rotateRight(node);
        }
        if (balance < -1 && value < node.rightChild.data) {
            node.rightChild = rotateRight(node.rightChild);
            return rotateLeft(node);
        }
        return node;
    }
    private int getHeight(Node node) {
        return (node == null) ? -1 : node.h;
    }
    private int getBalance(Node node) {
        return (node == null) ? 0 :
                getHeight(node.leftChild) - getHeight(node.rightChild);
    }
    private int max(int l, int r) {
        return (l > r) ? l : r;
    }
    private Node rotateRight(Node y) {
        Node x = y.leftChild;
        Node t2 = x.rightChild;
        x.rightChild = y;
        y.leftChild = t2;
        y.h = max(getHeight(y.leftChild), getHeight(y.rightChild)) + 1;
        x.h = max(getHeight(x.leftChild), getHeight(x.rightChild)) + 1;
        return x;
    }
    private Node rotateLeft(Node x) {
        Node y = x.rightChild;
        Node t2 = y.leftChild;
        y.leftChild = x;
        x.rightChild = t2;
        x.h = max(getHeight(x.leftChild), getHeight(x.rightChild)) + 1;
        y.h = max(getHeight(y.leftChild), getHeight(y.rightChild)) + 1;
        return y;
    }
    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.leftChild);
            preorder(node.rightChild);
        }
    }
    public static void main(String[] args) {
        ConstructAVLTree tree = new ConstructAVLTree();
        int[] values = {10, 20, 30, 40, 50, 25};
        for (int v : values)
            tree.insert(v);
        System.out.println("Preorder traversal of AVL Tree:");
        tree.preorder(tree.root);
    }
}
