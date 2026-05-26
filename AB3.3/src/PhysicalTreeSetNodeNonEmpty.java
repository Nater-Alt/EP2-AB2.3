import java.util.Objects;

/**
 * Non-empty subtree of a {@link PhysicalTreeSet}.
 *
 * <p>This class represents a node of a binary search tree storing
 * {@link Physical} objects.</p>
 */
public class PhysicalTreeSetNodeNonEmpty implements PhysicalTreeSetNode // TODO: activate clause.
{
    private PhysicalTreeSetNode left;
    private PhysicalTreeSetNode right;
    private Physical value;
    // TODO: all object variables and additional constructors and methods are private,
    //  unless a method overrides or implements an inherited public method.

    /**
     * Creates a new node storing the specified value.
     *
     * @param value the stored value; {@code value != null}
     * @param comparator the comparator defining the tree order;
     *                   {@code comparator != null}
     */
    public PhysicalTreeSetNodeNonEmpty(
            Physical value,
            PhysicalComparator comparator) {
        this.left = PhysicalTreeSetNodeEmpty.EMPTY;
        this.right = PhysicalTreeSetNodeEmpty.EMPTY;
        this.value = value;
    }

    @Override
    public Physical getValue() {
        return value;
    }

    @Override
    public PhysicalTreeSetNode getLeft() {
        return left;
    }

    @Override
    public PhysicalTreeSetNode getRight() {
        return right;
    }

    @Override
    public boolean contains(Physical p, PhysicalComparator comparator) {
        int cmp = comparator.compare(p,value);

        if (cmp == 0){
            return true;
        }
        if (cmp > 0){
            return right.contains(p,comparator);
        }
        return left.contains(p, comparator);
    }

    @Override
    public PhysicalTreeSetNode insert(Physical p, PhysicalComparator comparator) {
        int cmp = comparator.compare(p,value);

        if (cmp == 0){
            return this;
        }
        if (cmp > 0){
            right = right.insert(p,comparator);
        }
        if (cmp < 0) {
            left = left.insert(p, comparator);
        }
        return this;
    }

    @Override
    public int size() {
        return 1 + left.size() + right.size();
    }

    @Override
    public Physical iter(PhysicalTreeIterator iterator, boolean next) {
        if (!next){
            new PhysicalTreeIterator(this,iterator);
            left.iter(iterator,false);
            right.iter(iterator,false);
        }
        return value;
    }
}