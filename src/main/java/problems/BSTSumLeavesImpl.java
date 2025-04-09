package problems;

import adt.bst.BST;
import adt.bt.BTNode;

public class BSTSumLeavesImpl implements BSTSumLeaves {

    @Override
    public int sumLeaves(BST<Integer> bst) {
        return sumleavesNode(bst.getRoot());
    }

    private int sumleavesNode(BTNode<Integer> node) {
        int result = 0;
        if (!node.isEmpty()) {
            if (node.isLeaf()) {
                result += node.getData();
            } else {
                result += sumleavesNode(node.getLeft()) + sumleavesNode(node.getRight());
            }
        }
        return result;
    }

}
