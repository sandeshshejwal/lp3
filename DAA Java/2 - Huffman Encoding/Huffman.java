import java.util.*;
import java.util.Scanner;

class Node {
    int freq;
    char c;

    Node left, right;

    public Node(int freq, char c) {
        this.freq = freq;
        this.c = c;
    }
}

class Huffman {

    public static void main(String[] args) {
        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freqArray = {5, 9, 13, 14, 16, 45};

        PriorityQueue<Node> q = new PriorityQueue<>(n, new MyComparator());

        for (int i = 0; i < n; i++) {
            Node node = new Node(freqArray[i], charArray[i]);
            node.left = null;
            node.right = null;
            q.add(node);
        }

        Node root = null;

        while (q.size() > 1) {
            Node x = q.peek();
            q.poll();
            Node y = q.peek();
            q.poll();

            Node f = new Node(x.freq + y.freq, '-');
            f.left = x;
            f.right = y;

            root = f;
            q.add(f);
        }

        print(root, "");
    }

    public static void print(Node root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + " : " + s);
            return;
        }

        print(root.left, s + "0");
        print(root.right, s + "1");
    }

}

class MyComparator implements Comparator<Node> {

    public int compare(Node x, Node y) {
        return x.freq - y.freq;
    }
}
