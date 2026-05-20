/**
 * Iterator over a {@link PhysicalDoublyLinkedList}.
 *
 * <p>The iterator traverses the list from the first element to the last
 * element.</p>
 */
public class PhysicalDoublyLinkedListIterator implements PhysicalIterator {

    //TODO: all variables and additional methods and constructors are private.
    private PhysicalDoublyLinkedListNode current;
    /**
     * Creates a new iterator starting at the specified node.
     *
     * @param start the first node to be returned, or {@code null} if the
     *              iteration is empty
     */
    public PhysicalDoublyLinkedListIterator(PhysicalDoublyLinkedListNode start) {
        current = start;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
        return current != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Physical next() {
        if (!hasNext()){
            return null;
        }
        Physical value = current.getValue();
        current = current.getNext();
        return value;
    }
}