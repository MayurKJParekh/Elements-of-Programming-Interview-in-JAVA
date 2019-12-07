import java.util.List;

public class PartitionSortRepeats {

    /*
    14.7

    The time complexity is 0(ri), since the first pass entails n hash table inserts, and
the second pass spends (9(1) time to move one element to its proper location. The
additional space complexity is dictated by the hash table, i.e., 0(m), where m is the
number of distinct ages.
    */

    private static class Person {
        public Integer age;
        public String name;

        public Person(Integer k, String n) {
            age = k;
            name = n;
        }
    }

    public static void groupByAge(List<Person> people) {
        Map<Integer, Integer> ageToCount = new HashMap<>();
        for (Person p : people) {
            if (ageToCount.containsKey(p.age)) {
                ageToCount.put(p.age, ageToCount.get(p.age) + 1);
            } else {
                ageToCount.put(p.age, 1);
            }
        }
        Map<Integer, Integer> ageToOffset = new HashMap<>();
        int offset = 0;
        for (Map.Entry<Integer, Integer> kc : ageToCount.entrySet()) {
            ageToOffset.put(kc.getKey(), offset);
            offset += kc.getValue();
        }
        while (!ageToOffset.isEmpty()) {
            Map.Entry dnteger, Integer>from
                    = ageToOffset.entrySet().iterator().next();
            Integer toAge = people.get(from.getValue()).age;
            Integer toValue = ageToOffset.get(toAge);
            Collections.swap(people, from.getValue(), toValue);
// Use ageToCount to see when we are finished with a particular age.
            Integer count = ageToCount.get(toAge) - 1;
            ageToCount.put(toAge, count);
            if (count > 0) {
                ageToOffset.put(toAge, toValue + 1);
            } else {
                ageToOffset.remove(toAge);
            }
        }
    }
}
