package problems;

import adt.bt.BTNode;
import main.java.adt.bst.BST;
import main.java.adt.bst.BSTNode;

public class BTOperationsImpl<T> implements BTOperations<T> {

    
    public boolean isSymmetric(BTNode<T> bt){
        boolean result = true;
        // em um nó NIL o left e right são null,
        // portanto evita a chamada
        if (!bt.isEmpty()) {
            result = isSymmetric(bt.getLeft(), bt.getRight());
        }
        return result;
    }

    private boolean isSymmetric(BTNode<T> a, BTNode<T> b){
        boolean result = false;
        if (a.isEmpty() || b.isEmpty()) {
            // se algum é vazio, então
            // ambos tem que ser vazio
            result = a.isEmpty() && b.isEmpty();
        } else {
            // nenhum dos dois é vazio
            result = a.equals(b) && isSymmetric(a.getLeft(), b.getRight()) && isSymmetric(a.getRight(), b.getLeft());
        }
        return result;
    }


    public boolean isSimilar(BTNode<T> node1, BTNode<T> node2){
        boolean result = false;
        if (node1.isEmpty() || node2.isEmpty()) {
            // se algum é vazio, então
            // ambos tem que ser vazio
            result = node1.isEmpty() && node2.isEmpty();
        } else {
            // nenhum dos dois é vazio
            result = isSimilar(node1.getLeft(), node2.getLeft()) && isSimilar(node1.getRight(), node2.getRight());
        }
        return result;
    }

    @Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		boolean result = false;
		if (tree1 != null && tree2 != null) {
			result = equals((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
		}
		return result;
	}
	private boolean equals(BSTNode<T> node1, BSTNode<T> node2) {
		boolean result = false;
		if (node1.isEmpty() && node2.isEmpty()) {
			result = true;
		} else if (node1.getData().equals(node2.getData())) {
			result = this.equals((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft())
					&& this.equals((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
		}
		return result;
	}
}