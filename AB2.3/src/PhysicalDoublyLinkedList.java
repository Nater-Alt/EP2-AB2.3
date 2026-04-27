/**
 * Doubly linked list with elements of type {@link Physical}.
 *
 * <p>The list is implemented as a (non-cyclic) doubly linked structure with
 * references to the first (head) and last node (last).</p>
 * <p>
 * TODO: use {@link PhysicalDoublyLinkedListNode} as the node class of this list.
 *   Do NOT use the Java Collection Framework in your implementation.
 */
public class PhysicalDoublyLinkedList {

    private PhysicalDoublyLinkedListNode head;
    private PhysicalDoublyLinkedListNode last;
    private int size;

    /**
     * Creates an empty list.
     */
    public PhysicalDoublyLinkedList() {
        head = null;
        last = null;
        size = 0;
    }

    /**
     * Creates a new list that is a copy of the specified list. Later changes of
     * {@code this} (like adding or removing elements) will not affect {@code list} and
     * vice versa.
     *
     * <p>The new list contains the same elements and in the same order
     * as {@code list}.</p>
     *
     * @param list the list to copy; {@code list != null}
     */
    public PhysicalDoublyLinkedList(PhysicalDoublyLinkedList list) {
        head = null;
        last = null;
        size = 0;

        for (int i = 0; i < list.size(); i++) {
            addLast(list.get(i));
        }

    }

    /**
     * Adds an element at the head of the list.
     *
     * @param v the element to add
     */
    public void addFirst(Physical v) {
        PhysicalDoublyLinkedListNode newNode = new PhysicalDoublyLinkedListNode(v, null, head);
        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    /**
     * Adds an element at the end of the list.
     *
     * @param p the element to add
     */
    public void addLast(Physical p) {
        PhysicalDoublyLinkedListNode newNode = new PhysicalDoublyLinkedListNode(p, last, null);
        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
        size++;
    }

    /**
     * Adds an element at the specified position in the list.
     *
     * <p>If {@code index == 0}, the element is inserted at the head of the list.
     * If {@code index == size()}, the element is inserted at the end of the list.
     * All elements currently stored at positions greater than or equal to
     * {@code index} are shifted by one position toward the end of the list.</p>
     *
     * @param index the position at which the element is to be inserted;
     *              {@code 0 <= index <= size()}
     * @param p     the element to add
     */
    public void add(int index, Physical p) {
        if (index == 0) {
            addFirst(p);
            return;
        }
        if (index == size) {
            addLast(p);
            return;
        }
        PhysicalDoublyLinkedListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        PhysicalDoublyLinkedListNode newNode = new PhysicalDoublyLinkedListNode(p, current.getPrev(), current);
        current.getPrev().setNext(newNode);
        current.setPrev(newNode);
        size++;
    }

    /**
     * Removes and returns the head element of the list.
     *
     * <p>This method removes the first element of the list.</p>
     *
     * @return the first element in the list, or {@code null} if {@code size() == 0}
     */
    public Physical pollFirst() {
        if (head == null) {
            return null;
        }
        Physical value = head.getValue();
        if (size == 1) {
            head = null;
            last = null;
            size = 0;
            return value;
        }
        head.getNext().setPrev(null);
        head = head.getNext();
        size--;
        return value;
    }

    /**
     * Removes and returns the last element of the list.
     *
     * <p>This method removes the last element of the list.</p>
     *
     * @return the last element in the list, or {@code null} if {@code size() == 0}
     */
    public Physical pollLast() {
        if (head == null) {
            return null;
        }
        Physical value = last.getValue();
        if (size == 1) {
            head = null;
            last = null;
            size = 0;
            return value;
        }
        last.getPrev().setNext(null);
        last = last.getPrev();
        size--;
        return value;
    }

    /**
     * Returns the head element of the list without removing it.
     *
     * <p>The list remains unchanged after this operation.</p>
     *
     * @return the first element in the list, or {@code null} if {@code size() == 0}
     */
    public Physical peekFirst() {
        if (size == 0){
            return null;
        }
        return head.getValue();
    }

    /**
     * Returns the last element of the list without removing it.
     *
     * <p>The list remains unchanged after this operation.</p>
     *
     * @return the last element in the list, or {@code null} if {@code size() == 0}
     */
    public Physical peekLast() {
        if (size == 0){
            return null;
        }
        return last.getValue();
    }

    /**
     * Returns whether this list contains the specified element (identical to `p`).
     *
     * @param p the element to search for
     * @return {@code true} if present, otherwise {@code false}
     */
    public boolean contains(Physical p) {
        PhysicalDoublyLinkedListNode current = head;

        while (current != null) {
            if (current.getValue() == p) {
                return true;
            }

            current = current.getNext();
        }

        return false;
    }

    /**
     * Returns the element at the specified position in the list.
     *
     * <p>The first element has index {@code 0}.</p>
     *
     * @param index the index of the element to return;
     *              {@code 0 <= index < size()}
     * @return the element at the specified position
     */
    public Physical get(int index) {
        int counter = 0;
        PhysicalDoublyLinkedListNode current = head;
        while (counter != index){
            current = current.getNext();
            counter++;
        }
        return current.getValue();
    }

    /**
     * Removes and returns the element at the specified position in the list.
     *
     * <p>All elements following the removed element are shifted by one position
     * toward the head of the list.</p>
     *
     * @param index the index of the element to remove;
     *              {@code 0 <= index < size()}
     * @return the removed element
     */
    public Physical remove(int index) {
        if (index == 0) {
            return pollFirst();
        }

        if (index == size - 1) {
            return pollLast();
        }
        int counter = 0;
        PhysicalDoublyLinkedListNode current = head;
        while (counter != index){
            current = current.getNext();
            counter++;
        }
        Physical value = current.getValue();

        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());

        current.setPrev(null);
        current.setNext(null);

        size--;
        return value;
    }

    /**
     * Returns whether this list contains no elements.
     *
     * @return {@code true} if {@code size() == 0}, {@code false} otherwise
     */
    public boolean isEmpty() {

        return size == 0;
    }

    /**
     * Removes all elements from the list.
     */
    public void clear() {
        head = null;
        last = null;
        size = 0;
    }

    /**
     * Returns the number of elements currently stored in the list.
     *
     * @return the current size of the list
     */
    public int size() {
        return size;
    }
}
