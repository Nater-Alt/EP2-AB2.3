/**
 * Iterator over the keys stored in a {@link PhysicalPhysicalHashMap}.
 *
 * <p>The iterator scans the internal hash table and
 * returns the key of each occupied table entry.</p>
 *
 * <p>The iteration order is determined by the internal table layout and is
 * therefore unspecified.</p>
 */
public class PhysicalPhysicalHashMapIterator implements PhysicalIterator
{
    private Physical[] keys;
    private int index;
    /**
     * Creates a new iterator over the specified hash table key array.
     *
     * @param keys the internal key array of the hash map;
     *             {@code keys != null}
     */
    public PhysicalPhysicalHashMapIterator(Physical[] keys) {
        this.keys = keys;
        this.index = 0;
        advanceToNextOccupied();
    }

    @Override
    public boolean hasNext() {
        return index < keys.length;
    }

    @Override
    public Physical next() {
        if (index >= keys.length) {
            return null;
        }
        Physical result = keys[index];
        index++;
        advanceToNextOccupied();
        return result;
    }
    private void advanceToNextOccupied() {
        while (index < keys.length && keys[index] == null) {
            index++;
        }
    }

}