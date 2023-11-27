package tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 宽度遍历
 *
 * @author wenqiang
 * @date 2023/11/27 14:34
 **/
public class Code03_WidthTraversal {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        // 创建一棵树
        Node root = new Node(1);
        Node l1 = new Node(2);
        Node r1 = new Node(3);
        root.left = l1;
        root.right = r1;

        Node l1_l1 = new Node(4);
        Node l1_r1 = new Node(5);
        l1.left = l1_l1;
        l1.right = l1_r1;
        Node r1_l1 = new Node(6);
        Node r1_r1 = new Node(7);
        r1.left = r1_l1;
        r1.right = r1_r1;

        widthOrder(root);
    }

    public static void widthOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.value);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }
}