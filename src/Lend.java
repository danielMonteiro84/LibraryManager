import java.util.Date;

public class Lend {
    private final int id;
    private static int counterId;
    private Book book;
    private String userName;
    private Date lendDate;
    private Date returnDate;
    private boolean active;

    public Lend(Book book, String userName) {
        this.id = counterId++;
        this.book = book;
        this.userName = userName;
        this.lendDate = new Date();
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public String getUserName() {
        return userName;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public boolean isActive() {
        return active;
    }

    public void returnBook() {
        this.returnDate = new Date();
        this.active = false;
        this.book.setAvailable(true);
    }
}
