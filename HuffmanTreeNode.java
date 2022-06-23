class HuffmanTreeNode {
    private boolean leaf;
    private char key;
    private int frequency;
    private HuffmanTreeNode left, right;

    public HuffmanTreeNode() {
        leaf = false;
        key = '.';
        frequency = 0;
    };

    public HuffmanTreeNode(char k, int f) {
        leaf = true;
        key = k;
        frequency = f;
    };

    public int getFrequency() { return frequency; };
    public void setFrequency(int newFrequency) { frequency = newFrequency; };
    public HuffmanTreeNode getLeft() { return left; };
    public HuffmanTreeNode getRight() { return right; };
    public void setLeft(HuffmanTreeNode l) { left = l; };
    public void setRight(HuffmanTreeNode r) { right = r; };
    public boolean isLeaf() { return leaf; };
    public char getKey() { return key; };
    // call isLeaf before using getKey... if not leaf, this cannot be used...
    
};