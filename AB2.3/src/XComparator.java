/**
 * A comparator that orders {@link Physical} objects lexicographically
 * by their position.
 *
 * <p>The comparison is performed in two steps:</p>
 * <ul>
 *   <li>First, objects are compared by their x-coordinate.</li>
 *   <li>If the x-coordinates are equal, the y-coordinate is used
 *       as a tie-breaker.</li>
 * </ul>
 *
 * <p>This defines a total order on {@code Physical} objects based on their
 * positions in the two-dimensional space.</p>
 *
 * <p>Example ordering:
 * (1.0, 2.0) &lt; (1.0, 3.0) &lt; (2.0, 0.0)</p>
 */
public class XComparator implements PhysicalComparator // TODO: activate clause.
{
    @Override
    public int compare(Physical a, Physical b) {
        double ax = a.getPosition().getX();
        double bx = b.getPosition().getX();

        if (ax < bx) {
            return -1;
        }

        if (ax > bx) {
            return 1;
        }

        double ay = a.getPosition().getY();
        double by = b.getPosition().getY();

        if (ay < by) {
            return -1;
        }

        if (ay > by) {
            return 1;
        }

        return 0;
    }
    //TODO: define missing parts of this class.
}
