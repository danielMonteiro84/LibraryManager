import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Lend> lends = new ArrayList<>();

    //gerenciamento dos livros
    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> listBooks() {
        return books;
    }

    public List<Book> listBooksAvailable(){
        List<Book> booksAvailable = new ArrayList<>();
        for (Book book : books){
            if(book.isAvailable()) {
                booksAvailable.add(book);
            }
        }
        return booksAvailable;
    }

    public Book searchBookForId(int id) {
        for (Book book : books) {
            if(book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void updateBook(int id, String newTitle) {
        for(Book book : books) {
            if(book.getId() == id){
                book.setTitle(newTitle);
                        break;
            }
        }
    }

    public void removeBook(int id){
        books.removeIf(book -> book.getId() == id);
    }

        // gerenciamento dos autores

    public void addAuthor(Author author) {
        authors.add(author);
        }

    public List<Author> listAuthors(){
        return authors;
    }

    public void updateAuthor(int id, String newName) {
        for (Author author : authors) {
            if(author.getId() == id) {
                author.setName(newName);
                break;
            }
        }
    }

    public void removeAuthor(int id){
        authors.removeIf(author -> author.getId() == id);
    }

    // gerenciamento dos emprestimos

    public List<Lend> listActiveLends(){
        return lends.stream()
                .filter(Lend::isActive)
                .toList();
    }

    public void lendBook(Book book, String userName) {
        if(book.isAvailable()) {
            Lend lend = new Lend(book, userName);
            lends.add(lend);
            book.setAvailable(false);
        } else {
            System.out.println("The book is not available");
        }
    }

    public void returnBook(int idLend){
        for (Lend lend : lends) {
            if(lend.getId() == idLend && lend.isActive()) {
                lend.returnBook();
                lend.getBook().setAvailable(true);
                break;
            }
        }
    }

    public List<Lend> listLends(){
        return lends;
    }
}
