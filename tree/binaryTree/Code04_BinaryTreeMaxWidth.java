package tree.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

/**
 * @author wenqiang
 * @date 2023/12/05 17:36
 **/
public class Code04_BinaryTreeMaxWidth {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value && Objects.equals(left, node.left) && Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, left, right);
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

        maxWidth(root);
    }

    private static int maxWidth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Integer> map = new HashMap<>();
        queue.add(root);
        map.put(root, 1);

        int max = 1;
        int currentLevel = 1;
        int nextLevelNum = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            Integer level = map.get(cur);
            if (level > currentLevel) {
                max = Math.max(max, nextLevelNum);
                currentLevel++;
                nextLevelNum = 0;
            }

            if (cur.left != null) {
                nextLevelNum++;
                queue.add(cur.left);
                map.put(cur.left, currentLevel + 1);
            }

            if (cur.right != null) {
                nextLevelNum++;
                queue.add(cur.right);
                map.put(cur.right, currentLevel + 1);
            }
        }

        max = Math.max(max, nextLevelNum);
        return max;
    }
}