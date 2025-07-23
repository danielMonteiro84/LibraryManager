import java.util.Date;

public class Book {
    private final int id;
    private String title;
    private Author author;
    private boolean available;
    private Date registrationDate;
    private Date updateDate;

    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
        this.registrationDate = new Date();
        this.updateDate = new Date();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAthor() {
        return author;
    }

    public boolean isAvailable(){
        return available;
    }

    public Date getRegistrationDate(){
        return registrationDate;
    }

    public Date getUpdateDate(){
        return updateDate;
    }

    public void setTitle(String title) {
        this.title = title;
        this.updateDate = new Date();
    }

    public void setAvailable(boolean available){
        this.available = available;
    }
}
