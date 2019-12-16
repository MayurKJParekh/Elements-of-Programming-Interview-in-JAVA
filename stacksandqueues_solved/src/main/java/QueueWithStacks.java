import java.util.Stack;

public class QueueWithStacks {

    /*
    9.9
    This approach takes0(m) time for m operations, which can be seen from the fact that
each element is pushed no more than twice and popped no more than twice.
    */
    public static class Queue {
        private Deque<Integer> enq = new LinkedList<>();
        private Deque<Integer> deq = new LinkedList<>();

        public void enqueue(Integer x) {
            enq.addFirst(x);
        }

        public Integer dequeue() {
            if (deq.isEmpty()) {
// Transfers the elements from enq to deq.
                while (!enq.isEmpty()) {
                    deq.addFirst(enq.removeFirst());
                }
            }
            if (!deq.isEmpty()) {
                return deq.removeFirst();
            }
            throw new NoSuchElementException("Cannot pop empty queue");
        }
    }
}
