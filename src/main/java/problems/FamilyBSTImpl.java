package problems;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class FamilyBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements FamilyBST<T>{

    @Override
	public boolean primosPrimeiroGrau(T elem1, T elem2) {
		boolean result = false;
		if (!isEmpty() && elem1 != null && elem2 != null) {
			BSTNode<T> node1 = searchNode(root, elem1);
			BSTNode<T> node2 = searchNode(root, elem2);
			if (!node1.isEmpty() && !node2.isEmpty() && !(node1.getData().compareTo(node2.getData()) == 0)){
				return foundGrau(node1, node2);
			}
		}
		return result;
	}

	@Override
	public boolean primosSegundoGrau(T elem1, T elem2) {
		boolean result = false;
		if (!isEmpty() && elem1 != null && elem2 != null) {
			BSTNode<T> node1 = searchNode(root, elem1);
			BSTNode<T> node2 = searchNode(root, elem2);
			if (!node1.isEmpty() && !node2.isEmpty() && !(node1.getData().compareTo(node2.getData()) == 0)){
				return foundGrau((BSTNode<T>) node1.getParent(), node2);
			}
		}
		return result;
	}

	private boolean foundGrau(BSTNode<T> node1, BSTNode<T> node2) {
		BSTNode<T> father1 = (BSTNode<T>) node1.getParent();
		BSTNode<T> father2 = (BSTNode<T>) node2.getParent();
		if (father1.getData().compareTo(father2.getData()) == 0){
			return false;
		}
		if (father1.getParent().isEmpty() || father2.getParent().isEmpty()){
			return false;
		}
		if((father1.getParent().getData().compareTo(father2.getParent().getData())== 0)){
			return true;
		}
		return false;
	}
    
}
