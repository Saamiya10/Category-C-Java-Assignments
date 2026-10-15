import java.util.ArrayList;
import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    public double getCompositeScore() {
        return (cgpa * 10) + codingScore;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }
}

public class PlacementShortlistingEngine {
    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null) return "";
        ArrayList<Candidate> eligibleList = new ArrayList<>();
        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.cgpa) || Candidate.isEligible(c.cgpa, c.codingScore)) {
                eligibleList.add(c);
            }
        }
        Candidate[] eligibleArray = eligibleList.toArray(new Candidate[0]);
        Arrays.sort(eligibleArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < eligibleArray.length; i++) {
            if (i > 0) sb.append(" | ");
            sb.append((i + 1)).append(". ").append(eligibleArray[i].name)
              .append(" (").append(eligibleArray[i].getCompositeScore()).append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] batch = {
            new Candidate("Aisha", 8.2, 20),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 10)
        };
        System.out.println(shortlistAndRank(batch));
    }
}