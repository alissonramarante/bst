package adt.bst;

import adt.bst.BSTImpl;
import adt.bt.BTNode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BSTTest {
    private BSTImpl<Integer> tree;
	private BSTImpl<Integer> bst;
	private BTNode<Integer> NIL = new BTNode<Integer>();

	private void fillTree() {
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		for (int i : array) {
			tree.insert(i);
		}
	}

	private void fillBst() {
		Integer[] array = {18,28,13,9,15,45,21,5,11,17,14,16,25,40,26,27,35,33,50,67,90,55,65,30,29,63,64,60};
		for (int i : array) {
			bst.insert(i);
		}
	}

	@Before
	public void setUp() {
		tree = new BSTImpl<>();
		bst = new BSTImpl<>();
	}

	@Test
	public void testInit() {
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());
		assertEquals(-1, tree.height());

		assertEquals(NIL, tree.getRoot());

		assertArrayEquals(new Integer[] {}, tree.order());
		assertArrayEquals(new Integer[] {}, tree.preOrder());
		assertArrayEquals(new Integer[] {}, tree.postOrder());

		assertEquals(NIL, tree.search(12));
		assertEquals(NIL, tree.search(-23));
		assertEquals(NIL, tree.search(0));

		assertEquals(null, tree.minimum());
		assertEquals(null, tree.maximum());

		assertEquals(null, tree.sucessor(12));
		assertEquals(null, tree.sucessor(-23));
		assertEquals(null, tree.sucessor(0));

		assertEquals(null, tree.predecessor(12));
		assertEquals(null, tree.predecessor(-23));
		assertEquals(null, tree.predecessor(0));
	}

	@Test
	public void testMinMax() {
		tree.insert(6);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(6), tree.maximum().getData());

		tree.insert(23);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(-34);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(5);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(9);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());
	}

	@Test
	public void testSucessorPredecessor() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(null, tree.predecessor(-40));
		assertEquals(new Integer(-34), tree.sucessor(-40).getData());

		assertEquals(new Integer(-40), tree.predecessor(-34).getData());
		assertEquals(new Integer(0), tree.sucessor(-34).getData());

		assertEquals(new Integer(-34), tree.predecessor(0).getData());
		assertEquals(new Integer(2), tree.sucessor(0).getData());

		assertEquals(new Integer(0), tree.predecessor(2).getData());
		assertEquals(new Integer(5), tree.sucessor(2).getData());
	}

	@Test
	public void testSize() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		int size = 12;
		assertEquals(size, tree.size());

		while (!tree.isEmpty()) {
			tree.remove(tree.getRoot().getData());
			assertEquals(--size, tree.size());
		}
	}

	@Test
	public void testHeight() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] preOrder = new Integer[] { 6, -34, -40, 5, 2, 0, 23, 9, 12,
				76, 67, 232 };
		assertArrayEquals(preOrder, tree.preOrder());
		assertEquals(4, tree.height());

		tree.remove(0);
		assertEquals(3, tree.height());

		tree.remove(2);
		assertEquals(3, tree.height());
	}

	@Test
	public void testRemove() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] order = { -40, -34, 0, 2, 5, 6, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		tree.remove(6);
		order = new Integer[] { -40, -34, 0, 2, 5, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		tree.remove(9);
		order = new Integer[] { -40, -34, 0, 2, 5, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		assertEquals(NIL, tree.search(6));
		assertEquals(NIL, tree.search(9));

	}

	@Test
	public void testSearch() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(new Integer(-40), tree.search(-40).getData());
		assertEquals(new Integer(-34), tree.search(-34).getData());
		assertEquals(NIL, tree.search(2534));
	}

	@Test
	public void testBst(){
		assertTrue(bst.isEmpty());
		assertEquals(-1, bst.height());
		assertEquals(0, bst.size());
		fillBst();
		assertFalse(bst.isEmpty());
		assertEquals(28, bst.size());
		assertEquals(8, bst.height());
		assertEquals(new Integer (5), bst.minimum().getData());
		assertEquals(new Integer(90), bst.maximum().getData());
		Integer[] order = {5,9,11,13,14,15,16,17,18,21,25,26,27,28,29,30,33,35,40,45,50,55,60,63,64,65,67,90};
		assertArrayEquals(order, bst.order());
		bst.remove(60);
		bst.remove(64);
		Integer[] orderRemov2 = {5,9,11,13,14,15,16,17,18,21,25,26,27,28,29,30,33,35,40,45,50,55,63,65,67,90};
		assertArrayEquals(orderRemov2, bst.order());
		assertEquals(26, bst.size());
		assertEquals(7, bst.height());
		assertEquals(new Integer(28), bst.predecessor(29).getData());
		assertEquals(new Integer(28), bst.sucessor(27).getData());
		bst.remove(18);
		Integer[] orderRemov3 = {5,9,11,13,14,15,16,17,21,25,26,27,28,29,30,33,35,40,45,50,55,63,65,67,90};
		assertArrayEquals(orderRemov3, bst.order());
		assertEquals(new Integer(21), bst.getRoot().getData());
		assertEquals(25, bst.size());
		bst.insert(21);
		bst.insert(21);
		bst.insert(21);
		bst.insert(21);
		bst.insert(21);
		assertEquals(25, bst.size());
	}
    
}
