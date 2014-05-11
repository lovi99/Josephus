package josephus;

/**
 ******************************************************************************
 *                    HOMEWORK, 15-121
 ******************************************************************************
 *                    The Josephus Game
 ******************************************************************************
 *
 * The circular doubly linked list implementation
 *
 *
 *
 * @author
 * @date
 *****************************************************************************/

import java.util.*;

public class DoublyCircularLL implements ListInterface {
	private Node currentNode; // the current node. You always start with 1.
	private int currentSize; // the current number of nodes
	public Node head; // the head of the double linked list
	public Node tail; // the tail of the double linked list

	/**
	 * Builds a list with n nodes
	 */
	public DoublyCircularLL(int n) {
		this.currentSize = n;
		if (n <= 0) {
			throw new IllegalArgumentException(
					"Size of the linkedlist should be no less than 1.");
		}

		head = new Node(1, head, head);
		tail = head;
		this.currentNode = head;
		if (n != 1) {
			Node tmp = head;
			int cnt = n - 1;
			while (cnt != 0) {
				// add node
				tmp.next = new Node(tmp.data + 1, null, tmp);
				tmp = tmp.next;
				tail = tmp;
				cnt--;
			}

			// make the LinkedList circulars
			tail.next = head;
			head.prev = tail;
		}
	}

	/* Implement all methods from the ListInterface */
	/*
	 * Destroys the current list
	 */
	@Override
	public void clear() {
		head = null;
		tail = null;
		currentSize = 0;
	}

	/*
	 * Returns the size of the list
	 */
	@Override
	public int size() {
		return currentSize;
	}

	/*
	 * Returns true if value is contained in the list
	 */
	@Override
	public boolean contains(int value) {
		Node tmp = head;
		if (currentSize == 0) {
			return false;
		} else if (currentSize == 1) {
			return currentNode.data == value;
		} else {
			// find the Node that data=value
			while (tmp.next != head) {
				if (tmp.data == value) {
					return true;
				} else {
					tmp = tmp.next;
				}
			}
		}
		return false;
	}

	/*
	 * Returns true is the list is empty
	 */
	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}

	/*
	 * Returns the value stored in the current node
	 */
	@Override
	public int getData() {
		return currentNode.data;
	}

	public void printDCLLInOrder() {
		Node tmp = head;
		for (int i = 0; i < currentSize; i++) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	/*
	 * Removes and returns the node at specified index n. An integer index could
	 * positive as well as negative.. In case of error, it throws an exception.
	 */
	@Override
	public int removeAt(int n) throws NoSuchElementException {
		// check list's size
		if (currentSize == 0) {
			throw new NullPointerException("List is empty.");
		}
		if (n == 0) {
			throw new NoSuchElementException("Rotation should be either >=1 or <=-1.");
		}
		int cnt = 0;
		if (n > currentSize) {
			cnt = (n - 1) % currentSize;
		}
		
		Node tmp = currentNode;
		// remove the first node
		if (n >= 1) {
			cnt = n - 1;
			// find the n-th node
			while (cnt != 0) {
				tmp = tmp.next;
				cnt--;
			}
			currentNode = tmp.next;
		} else {
			cnt = -(n + 1);
			// find the target
			while (cnt != 0) {
				tmp = tmp.prev;
				cnt--;
			}
			currentNode = tmp.prev;
		}

		// if target is head
		if (tmp == head) {
			head = tmp.next;
		} else if (tmp == tail) { // if target is tail
			tail = tmp.prev;
		}
		// change the target's prev and next nodes'references
		tmp.prev.next = tmp.next;
		tmp.next.prev = tmp.prev;
		currentSize--;
		return tmp.data;
	}

	/* do not make any changes to the Node class */
	public class Node {
		public int data;
		public Node next;
		public Node prev;

		public Node(int data) {
			this.data = data;
			next = null;
			prev = null;
		}

		public Node(int data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		public String toString() {
			return data + "";
		}
	}
}
