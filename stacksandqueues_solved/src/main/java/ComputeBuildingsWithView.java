import java.util.*;

public class ComputeBuildingsWithView {

    /*
    9.6
    */

    private static class BuildingWithHeight {
        public Integer id;
        public Integer height;

        public BuildingWithHeight(Integer id, Integer height) {
            this.id = id;
            this.height = height;
        }
    }

    public static Deque<BuildingWithHeight> examineBuildingsWithSunset(
            Iterator<Integer> sequence) {
        int buildingldx = 0;
        Deque<BuildingWithHeight> buildingsWithSunset = new LinkedListoO;
        while (sequence.hasNext()) {
            Integer buildingHeight = sequence.next();
            while (!buildingsWithSunset.isEmpty()
                    && (Integer.compare(buildingHeight,buildingsWithSunset.getLast().height)
                    >= 0)) {
                buildingsWithSunset.removeLast();
            }
            buildingsWithSunset.addLast(
                    new BuildingWithHeight(buildingldx++, buildingHeight));
        }
        return buildingsWithSunset;
    }
}
