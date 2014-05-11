package josephus;

import josephus.DoublyCircularLL.Node;

/**
 ****************************************************************************** 
 * HOMEWORK, 15-121
 ****************************************************************************** 
 * The Josephus Game
 ****************************************************************************** 
 * 
 * This is a main driver.
 * 
 * Name:
 * 
 * AndrewID:
 *****************************************************************************/

public class MainDriver {
	public static void printDCLLInOrder(DoublyCircularLL dcll, int numOfNode) {
		Node n1 = dcll.head;
		System.out.println("size: " + dcll.size());
		System.out.println("head:" + dcll.head.data + ",tail: "
				+ dcll.tail.data);
		for (int i = 0; i < numOfNode; i++) {
			System.out.print(n1.data + " ");
			n1 = n1.next;
		}
		System.out.println();
	}

	public static void printDCLLReverseOrder(DoublyCircularLL dcll,
			int numOfNode) {
		Node n2 = dcll.tail;
		for (int i = 0; i < numOfNode; i++) {
			System.out.print(n2.data + " ");
			n2 = n2.prev;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// DoublyCircularLL dcll = new DoublyCircularLL(4);
		// printDCLLInOrder(dcll, dcll.size() * 2);
		// printDCLLReverseOrder(dcll, dcll.size() * 3);
		//
		// dcll.removeAt(3);
		// System.out.println("\nAfter remove '3':");
		// printDCLLInOrder(dcll, dcll.size());
		// printDCLLReverseOrder(dcll, dcll.size() * 3 + 1);
		//
		// System.out.println("\nAfter remove '1':");
		// dcll.removeAt(1);
		// System.out.println("size: " + dcll.size());
		// printDCLLInOrder(dcll, dcll.size());
		// printDCLLReverseOrder(dcll, dcll.size() * 3 + 1);
		//
		// System.out.println("\nAfter remove '4':");
		// dcll.removeAt(-2);
		// printDCLLInOrder(dcll, dcll.size());
		// printDCLLReverseOrder(dcll, dcll.size() * 3 + 1);
		//
		// System.out.println("\nAfter remove '2':");
		// dcll.removeAt(10);
		// printDCLLInOrder(dcll, dcll.size());
		// printDCLLReverseOrder(dcll, dcll.size());
		//
		// dcll.clear();
		// System.out.print("\nAfter clear, size: " + dcll.size()
		// + ". \nList is empty: " + dcll.isEmpty());

		int size = 5;
		int rotation = 2;

		Josephus game = new Josephus();

		//System.out.println("LinkedList: " + game.josephusDCLL(size, rotation));
		// PLEASE ADD MORE TEST CASES TO MAKE SURE YOUR IMPLEMENTATION WORKS!
		System.out.println(game.josephusDCLL(5, -10) + ", 3"); // 3
		System.out.println(game.josephusDCLL(5, 1) + ", 5");// 5
		System.out.println(game.josephusDCLL(5, -5) + ", 5");// 5
		System.out.println(game.josephusDCLL(1, 5) + ", 1");// = 1
		System.out.println(game.josephusDCLL(13, 1) + ", 13");// = 13
		System.out.println(game.josephusDCLL(40, 7) + ", 24");// = 24
		System.out.println(game.josephusDCLL(40, -7) + ", 18");// = 18
		System.out.println(game.josephusDCLL(100, -2) + ", 29");// = 29
		System.out.println(game.josephusDCLL(66, 1) + ", 66");// = 66
		System.out.println(game.josephusDCLL(66, 100) + ", 7");// = 7
		System.out.println(game.josephusDCLL(66, -100) + ", 61");// = 61
		System.out.println(game.josephusDCLL(1000, 123) + ", 2");// = 2
		System.out.println(game.josephusDCLL(1000, -123) + ", 1000");// = 1000
		System.out.println(game.josephusDCLL(1000, 1000) + ", 609");// = 609
		System.out.println(game.josephusDCLL(1000, -1000) + ", 393");// = 393
//		System.out.println(game.josephusDCLL(-3, 2));// = exception
//		System.out.println(game.josephusDCLL(3, 0));// = exception
	}
}
