package problems;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Esta classe é fornecida como uma implementacao de uma BST para propositos de teste.
 * 
 * NAO MODIFIQUE ESSA CLASSE!!!!
 */
public class BSTInteger extends BSTImpl<Integer>{

    @Override
    public void insert(Integer element) {
        insert(root, element);
    }

    protected void insert(BSTNode<Integer> node, Integer element) {
        if (node.isEmpty()) {
            node.setData(element);
            node.setLeft(new BSTNode<Integer>());
            node.getLeft().setParent(node);
            node.setRight(new BSTNode<Integer>());
            node.getRight().setParent(node);
        } else {
            if (node.getData().compareTo(element) > 0) {
                insert((BSTNode<Integer>)node.getLeft(), element);
            } else if (element.compareTo(node.getData()) > 0) {
                insert((BSTNode<Integer>)node.getRight(), element);
            }
        }
    }

    @Override
	public BSTNode<Integer> search(Integer element) {
		return search(root, element);
	}

	protected BSTNode<Integer> search(BSTNode<Integer> node, Integer element) {
		BSTNode<Integer> result = node;
		if (element != null) {
			if (!node.isEmpty()) {
				if (element.compareTo(node.getData()) == 0) {
					result = node;
				} else if (element.compareTo(node.getData()) < 0) {
					result = search((BSTNode<Integer>)node.getLeft(), element);
				} else {
					result = search((BSTNode<Integer>)node.getRight(), element);
				}
			}
		}

		return result;
	}
}
