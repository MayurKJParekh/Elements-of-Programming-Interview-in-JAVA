import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ComputeKClosest {

    /*
    11.4
    A max-heap is perfect for this application. Conceptually, we start by adding the
first k stars to the max-heap. As we process the stars, each time we encounter a new
star that is closer to Earth than the star which is the furthest from Earth among the
starsin themax-heap,wedelete from themax-heap,and add the new one. Otherwise,
we discard the new star and continue. We can simplify the code somewhat by simply
adding each star to the max-heap, and discarding the maximum element from the
max-heap once it contains k + 1elements.

The time complexity is0(n logk) and the space complexity is0(k).
    */

    public static class Star implements Comparable<Star> {
        private double x, y, z;

        public Star(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double distance() {
            return Math.sqrt(x * x + y * y + z * z);
        }

        @Override
        public int compareTo(Star rhs) {
            return Double.compare(this.distance(), rhs.distance());
        }
    }

    public static List<Star> findClosestKStars(int k, Iterator<Star> stars) {
// maxHeap to store the closest k stars seen so far.
        PriorityQueue<Star> maxHeap
                = new PriorityQueue<>(k, Collections.reverseOrder());

        while (stars.hasNext()) {
// Add each star to the max -heap. If the max-heap size exceeds k, remove
// the maximum element from the max-heap.
            Star star = stars.next();
            maxHeap.add(star);
            if (maxHeap.size() == k + 1) {
                maxHeap.remove();
            }
        }

        List<Star> orderedStars = new ArrayList<Star>(maxHeap);
// The only guarantee PriorityQueue makes about ordering is that the
// maximum element comes first, so we sort orderedStars.
        Collections.sort(orderedStars);
        return orderedStars;
    }
}
