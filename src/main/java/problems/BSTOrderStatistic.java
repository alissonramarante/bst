package problems;

import adt.bst.BST;
import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class BSTOrderStatistic<T extends Comparable<T>> extends BSTImpl<T> {

    public T orderStatistic(BST<T> bst, int k) {
        T orderStatistic = null;
        if (bst != null && !bst.isEmpty() && k > 0) {
            orderStatistic = orderStatistic((BSTNode<T>) bst.getRoot(), k);
        }
        return orderStatistic;
    }

    private T orderStatistic(BSTNode<T> node, int k) {
        T result = null;
        if (!node.isEmpty()) {
            int sizeLeft = size((BSTNode<T>) node.getLeft());
            if ((k - 1) == sizeLeft) {
                result = node.getData();
            } else if (k - 1 > sizeLeft) {
                result = orderStatistic((BSTNode<T>) node.getRight(), k - sizeLeft - 1);
            } else {
                result = orderStatistic((BSTNode<T>) node.getLeft(), k);
            }
        }

        return result;
    }

    private int size(BSTNode<T> node) {
        int size = 0;
        if (node != null && !node.isEmpty()) {
            size = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
        }
        return size;
    }

}
