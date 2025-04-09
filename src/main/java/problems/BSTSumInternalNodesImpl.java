package problems;

import adt.bst.BST;
import adt.bt.BTNode;

public class BSTSumInternalNodesImpl implements BSTSumInternalNodes{
    public int sumInternalNodes(BST<Integer> bst){
       int sum = 0;
       if (!bst.getRoot().isEmpty()) {
        sum = sumNode(bst.getRoot(), 0);
       }
       return sum;
    }

    private int sumNode(BTNode<Integer> node, int soma) {
        int result = soma;
        if (!node.isEmpty() && node.getParent() != null && !node.isLeaf()) {
            result += node.getData();            
        }
        result = sumNode(node.getLeft(), result);
        result = sumNode(node.getRight(), result);
        return result;
    }
}
