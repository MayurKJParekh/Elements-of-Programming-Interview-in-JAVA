import java.util.Collections;
import java.util.List;

public class ComputeOptimumAssignment {

    /*
    18.1

   if the durations are 5, 2, 1, 6,4, 4, then on sorting we get 1, 2, 4,4, 5, 6, and the
pairings are (1,6), (2,5), and (4,4).

The time complexity is dominated by the time to sort, i.e.,0(n log «).
    */

    public Integer taskl;
    public Integer task2;

    public PairedTasks(Integer taskl, Integer task2) {
        this.taskl = taskl;
        this.task2 = task2;

    }

    public static List<PairedTasks> optimumTaskAssignment(
            List<Integer> taskDurations) {
        Collections.sort(taskDurations);
        List<PairedTasks> optimumAssignments = new ArrayList<>();
        for (int i = 8, j = taskDurations.size() - 1; i < j; ++i, --j) {
            optimumAssignments.add(
                    new PairedTasks(taskDurations.get(i), taskDurations.get(j)));

            return optimumAssignments;
        }
    }

}
