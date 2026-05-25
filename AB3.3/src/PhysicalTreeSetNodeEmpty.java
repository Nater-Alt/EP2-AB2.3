/**
 * Empty subtree of a {@link PhysicalTreeSet}.
 *
 * <p>This class represents an empty binary-search-tree subtree.</p>
 */
public class PhysicalTreeSetNodeEmpty  implements PhysicalTreeSetNode // TODO: activate clause.
{
    public static final PhysicalTreeSetNodeEmpty EMPTY = new PhysicalTreeSetNodeEmpty();
    @Override
    public Physical getValue() {
        return null;
    }

    @Override
    public PhysicalTreeSetNode getLeft() {
        return EMPTY;
    }

    @Override
    public PhysicalTreeSetNode getRight() {
        return EMPTY;
    }

    @Override
    public boolean contains(Physical p, PhysicalComparator comparator) {
        return false;
    }

    @Override
    public PhysicalTreeSetNode insert(Physical p, PhysicalComparator comparator) {
        return new PhysicalTreeSetNodeNonEmpty(p,comparator);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Physical iter(PhysicalTreeIterator iterator, boolean next) {
        return null;
    }


}