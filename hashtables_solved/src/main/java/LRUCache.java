public class LRUCache {

    /*
    13.3
    The Java language provides the class LinkedHashMap, which is a subclass of
HashMap that preserves the insertion order—an iteration through a LinkedHashMap
visits keysin the order they were inserted. By calling the appropriate constructor, we
can ensure that any time an entry is read, it automatically moves to the front. We can
take advantage of this class to avoid having to implement the linked list.

    The time complexity for each lookup is (9(1) for the hash table lookup and (9(1) for
updating the queue, i.e., (9(1) overall.
    */

    public class LRUCache {

    }
        LinkedHashMap<Integer , Integer> isbnToPrice ;

        LRUCache(final int capacity) {
            this.isbnToPrice
                    = new LinkedHashMap<Integer , Integer>(capacity , 1.0f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer , Integer> e)
                {
                    return this.size() > capacity;
                }
            };
        }

        public Integer lookup(Integer key) {
            if (!isbnToPrice.containsKey(key)) {
                return null ;
            }
            return isbnToPrice.get(key);
        }

        public Integer insert(Integer key, Integer value) {
// We add the value for key only if key is not present - we don’t update
// existing values.
            Integer currentValue = isbnToPrice.get(key);
            if (!isbnToPrice.containsKey(key)) {
                isbnToPrice.put(key , value);
                return currentValue;
            } else {
                return null ;
            }
        }
        public Integer erase(Object key) { return isbnToPrice.remove(key); }
}
