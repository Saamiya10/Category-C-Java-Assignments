import java.util.ArrayList;
import java.util.Arrays;

class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}

public class AutoDraftEngine {
    public static String draftAndRank(Player[] players) {
        if (players == null) return "";
        ArrayList<Player> draftableList = new ArrayList<>();
        for (Player p : players) {
            if (Player.isDraftable(p.matchesPlayed) || Player.isDraftable(p.matchesPlayed, p.injured)) {
                draftableList.add(p);
            }
        }
        Player[] draftableArray = draftableList.toArray(new Player[0]);
        Arrays.sort(draftableArray);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            if (i > 0) result.append(" | ");
            result.append((i + 1)).append(". ").append(draftableArray[i].name);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Player[] lineup = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(lineup));
    }
}