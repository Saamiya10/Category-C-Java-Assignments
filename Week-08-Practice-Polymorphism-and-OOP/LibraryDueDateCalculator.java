import java.time.LocalDate;

abstract class LibraryItem {
    public abstract LocalDate calculateDueDate(LocalDate baseDate);
}

class BookItem extends LibraryItem {
    @Override public LocalDate calculateDueDate(LocalDate baseDate) { return baseDate.plusDays(14); }
}

public class LibraryDueDateCalculator {
    public static void main(String[] args) {
        LibraryItem item = new BookItem();
        System.out.println("Due: " + item.calculateDueDate(LocalDate.now()));
    }
}