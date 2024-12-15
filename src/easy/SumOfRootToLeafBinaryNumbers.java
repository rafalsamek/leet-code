package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1022. Sum of Root To Leaf Binary Numbers
 * Easy
 * Topics
 * Companies
 * Hint
 * You are given the root of a bsinary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.
 *
 * For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.
 *
 * The test cases are generated so that the answer fits in a 32-bits integer.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * Example 2:
 *
 * Input: root = [0]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * Node.val is 0 or 1.
 */
public class SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        checkConstraint(args);

        BinaryTree binaryTree = new BinaryTree(args);
        System.out.println(binaryTree.getSumOfRootToLeafBinaryNumbers());
    }

    private static void checkConstraint(String[] args) {
        //The number of nodes in the tree is in the range [1, 1000]
        if (args.length > 1000) {
            throw new IllegalArgumentException("number of nodes in the tree is greater than 1000");
        }
        if (args.length < 1) {
            throw new IllegalArgumentException("the number of nodes in the tree is less than 1");
        }
        for (int i = 0; i < args.length; i++) {
            if (!args[i].equals("0") && !args[i].equals("1")) {
                throw new IllegalArgumentException("the values of nodes must be '0' or '1'");
            }
        }
    }


    private static class BinaryTree {
        private List<Node> nodes = new ArrayList<>();
        BinaryTree(String[] input) {
            for (int i = 0; i < input.length; i++) {
                Node parentNode = nodes.isEmpty() ? null : nodes.get((i - 1) / 2);
                Node node = new Node(input[i], parentNode);
                nodes.add(node);

                if (parentNode != null) {
                    parentNode.setIsLeaf(false);
                }
            }
        }

        public List<Node> getLeaves() {
            List<Node> leaves = new ArrayList<>();
            for (Node node : this.nodes) {
                if (node.getIsLeaf()) {
                    leaves.add(node);
                }
            }

            return leaves;
        }

        @Override
        public String toString() {
            return "BinaryTree{" +
                    "nodes=" + nodes +
                    '}';
        }

        public int getSumOfRootToLeafBinaryNumbers() {
            int sum = 0;
            for (Node leaf : this.getLeaves()) {
                StringBuilder path = new StringBuilder();
                while (leaf.getParentNode() != null) {
                    path.append(leaf.getValue());
                    leaf = leaf.getParentNode();
                }
                path.append(leaf.getValue());
                String binaryNumber = path.reverse().toString();
                sum += Integer.parseInt(binaryNumber, 2);
            }

            return sum;
        }
    }

    private static class Node {
        private String value;
        private Node parentNode = null;
        private boolean isLeaf = true;

        public String getValue() {
            return this.value;
        }

        public Node getParentNode() {
            return this.parentNode;
        }

        public void setIsLeaf(boolean isLeaf) {
            this.isLeaf = isLeaf;
        }

        public boolean getIsLeaf() {
            return this.isLeaf;
        }

        public Node(String value, Node parentNode) {
            this.value = value;
            this.parentNode = parentNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", parentNode=" + parentNode +
                    "}\n";
        }
    }
}
