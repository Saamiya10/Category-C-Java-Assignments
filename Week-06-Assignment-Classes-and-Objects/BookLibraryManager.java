class Book {
    String isbn;
    String title;
    boolean isIssued;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.isIssued = false;
    }

    public void issueBook() {
        if (!isIssued) isIssued = true;
    }

    public void returnBook() {
        if (isIssued) isIssued = false;
    }
}

public class BookLibraryManager {
    public static void main(String[] args) {
        Book b = new Book("978-0134685991", "Effective Java");
        b.issueBook();
        System.out.println(b.title + " Issued: " + b.isIssued);
    }
}