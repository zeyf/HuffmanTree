import java.util.*;

public class HuffmanTree {

    HuffmanTreeNode root = null;

    public HuffmanTree(ArrayList<Pair<Character, Integer>> keyFrequencyPairs) { 
        PriorityQueue<HuffmanTreeNode> minHeap = new PriorityQueue<>(new HuffmanTreeNodeComparator());

        for (int x = 0; x < keyFrequencyPairs.size(); ++x)
            minHeap.add(new HuffmanTreeNode(keyFrequencyPairs.get(x).getFirst(), keyFrequencyPairs.get(x).getSecond()));

        build(minHeap);
    };

    void build(PriorityQueue<HuffmanTreeNode> minHeap) {
        while (minHeap.size() > 1) {
            HuffmanTreeNode parent = new HuffmanTreeNode();
            HuffmanTreeNode leftChild = minHeap.poll();
            HuffmanTreeNode rightChild = minHeap.poll();
            parent.setLeft(leftChild);
            parent.setRight(rightChild);
            parent.setFrequency(leftChild.getFrequency() + rightChild.getFrequency());
            minHeap.add(parent);
        };

        this.root = minHeap.poll();
    };

    class HuffmanTreeNodeComparator implements Comparator<HuffmanTreeNode> {
        public int compare(HuffmanTreeNode u, HuffmanTreeNode v) {
            if (u.getFrequency() < v.getFrequency())
                return -1;
            else if (u.getFrequency() > v.getFrequency())
                return 1;
            return 0;
        };
    };

    public String decodeSequence(String sequence) {
        if (root == null) return "";

        String decodeResult = "";
        HuffmanTreeNode currentNode = root;
        for (int x = 0; x < sequence.length(); ++x) {
            if (sequence.charAt(x) == '0')
                currentNode = currentNode.getLeft();
            else
                currentNode = currentNode.getRight();

            if (currentNode.isLeaf()) {
                decodeResult += currentNode.getKey();
                currentNode = root;
            };
        };

        return decodeResult;
    };

    public void print() {
        if (this.root != null)
            printHelper(this.root, "");
    };

    public void printHelper(HuffmanTreeNode c, String built) {
        if (c.isLeaf()) {
            System.out.println(String.format("Code: %s\nKey: %c\nFrequency: %d\n\n", built, c.getKey(), c.getFrequency()));
            return;
        };

        printHelper(c.getLeft(), built + '0');
        printHelper(c.getRight(), built + '1');
    };

};