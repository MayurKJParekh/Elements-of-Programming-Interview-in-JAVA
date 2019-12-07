import java.util.List;

public class RenderCalendar {

    /*
    14.4

    Sorting the endpoint array takes 0(n log n) time; iterating through the sorted array
takes0(n) time, yielding an0(n log n) time complexity The space complexity is0(n),
which is the size of the endpoint array.
    */

    public static class Event {
        public int start, finish;

        public Event(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    private static class Endpoint implements Comparable<Endpoint> {
        public int time;
        public boolean isStart;

        public int compareTo(Endpoint e) {
            if (time != e.time) {
                return Integer.compare(time, e.time);
            }
// If times are equal, an endpoint that starts an interval comes first.
            return isStart && !e.isStart ? -1 : !isStart && e.isStart ? 1 : Q;
        }

        Endpoint(int t, boolean is) {
            time = t;
            isStart = is;
        }
    }

    public static int findMaxSimultaneousEvents(List<Event> A) {
// Builds an array of all endpoints.
        List<Endpoint> E = new ArrayList<>();
        for (Event event : A) {

            E.add(new Endpoint(event.start, true));
            E.add(new Endpoint(event.finish, false));
        }
// Sorts the endpoint array according to the time, breaking ties
// by putting start times before end times.
        Collections.sort(E);
// Track the number of simultaneous events, and record the maximum
// number of simultaneous events.
        int maxNumSimultaneousEvents =®,numSimultaneousEvents =®;
        for (Endpoint endpoint : E) {
            if (endpoint.isStart) {
                ++numSimultaneousEvents;
                maxNumSimultaneousEvents
                        = Math.max(numSimultaneousEvents, maxNumSimultaneousEvents);
            } else {
                --numSimultaneousEvents;
            }
        }
        return maxNumSimultaneousEvents;
    }
}
