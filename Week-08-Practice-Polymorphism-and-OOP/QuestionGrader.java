abstract class Question {
    protected double points;
    public Question(double points) { this.points = points; }
    public abstract double evaluateScore();
}

class MCQQuestion extends Question {
    private boolean correct;
    public MCQQuestion(double points, boolean correct) { super(points); this.correct = correct; }
    @Override public double evaluateScore() { return correct ? points : 0; }
}

public class QuestionGrader {
    public static void main(String[] args) {
        Question q = new MCQQuestion(5.0, true);
        System.out.println("Score: " + q.evaluateScore());
    }
}