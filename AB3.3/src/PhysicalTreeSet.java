import java.util.Objects;

/**
 * Binary-search-tree implementation of {@link PhysicalSet}.
 *
 * <p>The elements are stored in a binary search tree ordered according to
 * a {@link PhysicalComparator}. Duplicate elements are not stored. Two
 * elements are considered duplicates iff they are equal according to
 * {@link Physical#equals(Object)}.</p>
 */
public class PhysicalTreeSet implements PhysicalSet
{
    private PhysicalTreeSetNode root;
    private int size;
    private PhysicalComparator comparator;

    /**
     * Creates an empty set ordered according to {@link XComparator}.
     */
    public PhysicalTreeSet() {
        root = PhysicalTreeSetNodeEmpty.EMPTY;
        size = 0;
        comparator = new XComparator();
    }

    /**
     * Creates an empty set ordered according to the specified comparator.
     *
     * @param comparator the comparator defining the tree order;
     *                   {@code comparator != null}
     */
    public PhysicalTreeSet(PhysicalComparator comparator) {
        root = new PhysicalTreeSetNodeEmpty();
        size = 0;
        this.comparator = comparator;
    }

    @Override
    public boolean add(Physical p) {
        return root.insert(p, comparator) != null;
    }

    @Override
    public boolean contains(Physical p) {
        return root.contains(p,comparator);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        root = PhysicalTreeSetNodeEmpty.EMPTY;
        size = 0;
        comparator = new XComparator();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The iterator traverses the elements in ascending order according
     * to the comparator of this set.</p>
     */
    // @Override
    public PhysicalIterator iterator() {
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>Two {@code PhysicalTreeSet} objects are considered equal iff</p>
     * <ul>
     *   <li>the specified object is also a {@code PhysicalTreeSet},</li>
     *   <li>both sets contain the same number of elements, and</li>
     *   <li>for every element contained in this set, an equal element is
     *       contained in the other set.</li>
     * </ul>
     *
     * <p>The iteration order and the concrete internal tree structure are
     * irrelevant.</p>
     *
     * @param o the object to compare with
     * @return {@code true} iff the specified object represents an equal set
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PhysicalTreeSet physicals = (PhysicalTreeSet) o;
        return physicals.root.equals(this.root);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(root);
    }

}