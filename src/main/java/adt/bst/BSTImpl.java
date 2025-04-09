package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return heightNode(this.getRoot());
	}

	private int heightNode(BSTNode<T> node) {
		int result = -1;
		if (!node.isEmpty()) {
			result = Math.max(heightNode((BSTNode<T>) node.getLeft()), heightNode((BSTNode<T>) node.getRight()));
		}
		return result;
	}

	@Override
	public BSTNode<T> search(T element) {
		return searchNode(this.getRoot(), element);
	}

	private BSTNode<T> searchNode(BSTNode<T> node, T element) {
		BSTNode<T> result = new BSTNode<T>();
		if (element != null && !node.isEmpty()) {
			if (node.getData().compareTo(element) == 0) {
				result = node;
			}
			if (node.getData().compareTo(element) < 0) {
				result = searchNode((BSTNode<T>) node.getLeft(), element);
			} else {
				result = searchNode((BSTNode<T>) node.getRight(), element);
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		insertNode(this.getRoot(), element);
	}

	private void insertNode(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		} else {
			if (node.getData().compareTo(element) < 0) {
				insertNode((BSTNode<T>) node.getLeft(), element);
			} else if (node.getData().compareTo(element) > 0) {
				insertNode((BSTNode<T>) node.getRight(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximumNode(this.getRoot());
	}

	private BSTNode<T> maximumNode(BSTNode<T> node) {
		BSTNode<T> result = null;
		if (!node.isEmpty()) {
			if (node.getRight().isEmpty()) {
				result = node;
			} else {
				result = maximumNode((BSTNode<T>) node.getRight());
			}
		}
		return result;
	}

	@Override
	public BSTNode<T> minimum() {
		return minimumNode(this.getRoot());
	}

	private BSTNode<T> minimumNode(BSTNode<T> node) {
		BSTNode<T> result = null;
		if (!node.isEmpty()) {
			if (node.getLeft().isEmpty()) {
				result = node;
			} else {
				result = minimumNode((BSTNode<T>) node.getLeft());
			}
		}
		return result;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> result = null;
		BSTNode<T> current = this.search(element);
		if (!current.getRight().isEmpty()) {
			result = this.minimumNode((BSTNode<T>) current.getRight());
		} else {
			result = sucessorNode(current);
		}

		return result;
	}

	private BSTNode<T> sucessorNode(BSTNode<T> node) {
		BSTNode<T> result = (BSTNode<T>) node.getParent();
		if (node.getParent() != null && node.equals(result.getRight())) {
			result = sucessorNode(result);
		}
		return result;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> result = null;
		BSTNode<T> current = this.search(element);
		if (!current.getLeft().isEmpty()) {
			result = maximumNode((BSTNode<T>) current.getLeft());
		} else {
			result = predecessNode(current);
		}

		return result;
	}

	private BSTNode<T> predecessNode(BSTNode<T> node) {
		BSTNode<T> result = (BSTNode<T>) node.getParent();
		if (node.getParent() != null && node.equals(result.getLeft())) {
			result = predecessNode(result);
		}
		return result;

	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = this.search(element);
		if (!node.isEmpty()) {
			// Caso 01: o nó é uma folha
			if (node.isLeaf()) {
				node.setData(null);
				// Caso 02: o nó possui um filho
			} else if (node.getLeft().isEmpty() || node.getRight().isEmpty()) {
				BSTNode<T> child;
				// Acha o filho do node que nao eh NIL
				if (!node.getRight().isEmpty()) {
					child = (BSTNode<T>) node.getRight();
				} else {
					child = (BSTNode<T>) node.getLeft();
				}

				// Se o node for a raiz, entao a raiz passa a ser o filhoValido
				if (node.equals(this.getRoot())) {
					this.root = child;
					this.root.setParent(null);

				} else {
					// Se o node nao for a raiz, entao o pai dele vai virar o pai do filhoValido
					// dele

					BSTNode<T> parentNode = (BSTNode<T>) node.getParent();
					child.setParent(parentNode);

					if (parentNode.getLeft().equals(node)) {
						parentNode.setLeft(child);
					} else {
						parentNode.setRight(child);
					}

				}

				// Caso 03: o nó possui dois filhos
			} else {
				T sucessor = sucessor(node.getData()).getData();
				remove(sucessor);
				node.setData(sucessor);
			}

		}
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> list = new ArrayList<T>();
		preOrder(list, this.getRoot());
		return (T[]) list.toArray(new Comparable[list.size()]);
	}

	private void preOrder(ArrayList<T> array, BSTNode<T> node) {
		if (!node.isEmpty()) {
			array.add(node.getData());
			preOrder(array, (BSTNode<T>) node.getLeft());
			preOrder(array, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> list = new ArrayList<T>();
		order(list, this.getRoot());
		return (T[]) list.toArray(new Comparable[list.size()]);
	}

	private void order(ArrayList<T> array, BSTNode<T> node) {
		if (!node.isEmpty()) {
			order(array, (BSTNode<T>) node.getLeft());
			array.add(node.getData());
			order(array, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList<T>();
		postOrder(list, this.getRoot());
		return (T[]) list.toArray(new Comparable[list.size()]);
	}

	private void postOrder(ArrayList<T> array, BSTNode<T> node) {
		if (!node.isEmpty()) {
			postOrder(array, (BSTNode<T>) node.getLeft());
			postOrder(array, (BSTNode<T>) node.getRight());
			array.add(node.getData());
			
		}
		
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
