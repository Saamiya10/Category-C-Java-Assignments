import java.time.LocalDate;

abstract class StreamingPlan {
    protected LocalDate startDate;
    public StreamingPlan(LocalDate startDate) { this.startDate = startDate; }
    public abstract LocalDate calculateRenewalDate();
}

class BasicPlan extends StreamingPlan {
    public BasicPlan(LocalDate startDate) { super(startDate); }
    @Override public LocalDate calculateRenewalDate() { return startDate.plusDays(30); }
}

public class StreamingRenewalReminder {
    public static void main(String[] args) {
        StreamingPlan p = new BasicPlan(LocalDate.now());
        System.out.println("Renewal: " + p.calculateRenewalDate());
    }
}