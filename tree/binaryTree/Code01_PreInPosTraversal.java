package tree.binaryTree;

import java.util.Stack;

/**
 * 树的非递归遍历
 *
 * @author wenqiang
 * @date 2023/11/27 13:26
 **/
public class Code01_PreInPosTraversal {
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

        // 先序
//        preOrderUnRecur(root);

        // 中序
//        inOrderUnRecur(root);
        inOrderUnRecur_Ok(root);

        // 后序
//        posOrderUnRecur(root);
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    private static void preOrderUnRecur(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur.value);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历 【自己实现的版本】
     *
     * @param root
     */
    private static void inOrderUnRecur(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.peek();
            if (cur.left != null) {
                stack.push(cur.left);
                cur.left = null;
                continue;
            }
            Node pop = stack.pop();
            System.out.print(pop.value);
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历 【正确的版本】
     *
     * @param root
     */
    private static void inOrderUnRecur_Ok(Node root) {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.value);
            root = root.right;
        }
        System.out.println();
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    private static void posOrderUnRecur(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Stack<Node> result = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            result.push(cur);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        while (!result.isEmpty()) {
            Node cur = result.pop();
            System.out.print(cur.value);
        }
        System.out.println();
    }
}