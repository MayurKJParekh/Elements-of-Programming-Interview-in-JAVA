import java.util.List;

public class ScheduleMinimizedWaitingTime {

    /*
    18.2

        For the given example, the best schedule processes queriesin increasing order of
    service times. It has a total waiting time of 0 + (1) + (1+ 2) + (1+ 2 + 3) = 10. Note that
    scheduling queries with longer service times, which we gave as an earlier example,
    is the worst approach.

        The time complexity is dominated by the time to sort, i.e.,0(n log «).

    */


    public static int minimumTotalWaitingTime(List<Integer> serviceTimes) {
// Sort the service times in increasing order.
        Collections.sort(serviceTimes);
        int totalWaitingTime = 0;
        for (int i = 0; i < serviceTimes.size(); ++i) {
            int numRemainingQueries = serviceTimes.size() - (i + 1);
            totalWaitingTime += serviceTimes.get(i) * numRemainingQueries;
        }
        return totalWaitingTime;
    }

}
