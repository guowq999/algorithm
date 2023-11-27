package tree.binaryTree;

/**
 * 树的递归遍历
 *
 * @author wenqiang
 * @date 2023/11/27 11:27
 **/
public class Code01_PreInPosRecurTraversal {
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

        // 递归序
//        f(root);

        // 先序
//        preOrderRecur(root);

        // 中序
//        inOrderRecur(root);

        // 后序
        posOrderRecur(root);
    }

    /**
     * 递归遍历树
     *
     * @param root 根节点
     */
    public static void f(Node root) {
        // 递归终止条件
        if (root == null) {
            return;
        }

        // 1、第一次打印节点值
        System.out.print(root.value);
        f(root.left);
        // 2、遍历完左树第二次打印节点值
        System.out.print(root.value);
        f(root.right);
        // 3、遍历完右数后第三次打印节点值
        System.out.print(root.value);
    }

    /**
     * 先序遍历
     *
     * @param root 根节点
     */
    public static void preOrderRecur(Node root) {
        // 递归终止条件
        if (root == null) {
            return;
        }

        // 1、第一次打印节点值
        System.out.print(root.value);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    /**
     * 中序遍历
     *
     * @param root 根节点
     */
    public static void inOrderRecur(Node root) {
        // 递归终止条件
        if (root == null) {
            return;
        }

        inOrderRecur(root.left);
        // 2、遍历完左树第二次打印节点值
        System.out.print(root.value);
        inOrderRecur(root.right);
    }

    /**
     * 后序遍历
     *
     * @param root 根节点
     */
    public static void posOrderRecur(Node root) {
        // 递归终止条件
        if (root == null) {
            return;
        }

        posOrderRecur(root.left);
        posOrderRecur(root.right);
        // 3、遍历完右数后第三次打印节点值
        System.out.print(root.value);
    }
}