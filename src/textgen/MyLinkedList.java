package textgen;

import java.util.AbstractList;

/**
 * A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E>
 *            The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * 
	 * @param element
	 *            The element to add
	 */
	public boolean add(E element) {
		// TODO: Implement this method

		LLNode<E> n = new LLNode<E>(element);
		n.next = tail.prev.next;
		n.prev = tail.prev;
		n.next.prev = n;
		n.prev.next = n;
		size++;

		return false;
	}

	/**
	 * Get the element at position index
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */
	public E get(int index) {
		// TODO: Implement this method.

		LLNode<E> current = head.next;

		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Check out of bounds");
		}

		for (int i = 0; i < size; i++) {
			if (i == index) {
				return current.data;
			}

			current = current.next;
		}
		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * 
	 * @param The
	 *            index where the element should be added
	 * @param element
	 *            The element to add
	 */
	public void add(int index, E element) {
		// TODO: Implement this method

		LLNode<E> current = head;
		LLNode<E> n = new LLNode<E>(element);

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Check out of bounds");
		}

		for (int i = -1; i < index; i++) {

			current = current.next;
		}

		n.next = current;
		n.prev = current.prev;
		n.next.prev = n;
		n.prev.next = n;

		size++;

	}

	/** Return the size of the list */
	public int size() {
		// TODO: Implement this method
		return size;

		// return -1;
	}

	/**
	 * Remove a node at the specified index and return its data element.
	 * 
	 * @param index
	 *            The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException
	 *             If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) {
		// TODO: Implement this method

		LLNode<E> current = head.next;

		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Check out of bounds");
		}

		if (size == 0) {
			throw new NullPointerException("Empty list");
		}

		for (int i = 0; i < index; i++) {

			current = current.next;

		}

		current.prev.next = current.next;
		current.next.prev = current.prev;
		current.next = null;
		current.prev = null;

		size--;
		return current.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * 
	 * @param index
	 *            The index of the element to change
	 * @param element
	 *            The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */
	public E set(int index, E element) {
		// TODO: Implement this method
		LLNode<E> current = head.next;
		LLNode<E> n = new LLNode<E>(element);

		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Check out of bounds");
		}

		if (element == null) {
			throw new NullPointerException("Tried to insert null value");
		}

		for (int i = 0; i < size; i++) {
			if (i == index) {

				n.next = current.next;
				n.prev = current.prev;
				n.next.prev = n;
				n.prev.next = n;
				current.next = null;
				current.prev = null;

			}

		}
		return current.data;
	}
}

class LLNode<E> {
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
