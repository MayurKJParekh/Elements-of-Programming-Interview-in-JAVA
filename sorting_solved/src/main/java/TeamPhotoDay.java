import java.util.List;

public class TeamPhotoDay {

    /*
    14.8
We can efficiently check whether A's tallest, second tallest, etc. players are each
taller than B's tallest, second tallest, etc. players by first sorting the arrays of player
heights. Figure 14.4 shows the teamsin Figure 14.3 sorted by their heights.

    The time complexity is that of sorting, i.e.,0(n log n).

    */

    class Player implements Comparable<Player> {
        public Integer height;

        public Player(Integer h) {
            height = h;
        }

        @Override
        public int compareTo(Player that) {
            return Integer.compare(height, that.height);
        }
    }

    class Team {
        public Team(List<Integer> height) {
            players = new ArrayList<Player>(height.size());
            for (int i = 0; i < height.size(); ++i) {
                players.add(new Player(height.get(i)));
            }
        }

        // Checks if A can be placed in front of B.
        public static boolean validPlacementExists(Team A, Team B) {
            List<Player> ASorted = A.sortPlayersByHeight();
            List<Player> BSorted = B.sortPlayersByHeight();
            for (int i = 0; i < ASorted.size() < && i < BSorted.size(); ++i) {
                if (ASorted.get(i).compareTo(BSorted.get(i)) >= 0) {
                    return false;
                }
            }
            return true;
        }

        private List<Player> sortPlayersByHeight() {
            List<Player> sortedPlayers = new ArrayList<Player>(players);
            Collections.sort(sortedPlayers);
            return sortedPlayers;
        }

        private List<Player> players;
    }
