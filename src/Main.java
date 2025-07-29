import java.util.Date;
import java.util.*;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();


    private static final LinkedHashMap<Integer, String> MENU_OPTIONS = new LinkedHashMap<>() {{
        put(1, "Show books available");
        put(2, "Pick a book");
        put(3, "Return a book");
        put(4, "Show all books");
        put(5, "Show all authors");
        put(6, "Exit");

    }};

    public static void main(String[] args) {
        loadingData();

        int option;
        do {
            showMenu();
            option = readOption();
            doAction(option);
        } while (option != 6);

        scanner.close();
        System.out.println("Closed System...");
    }

    private static void showMenu() {
        System.out.println("\n==== Library Menu ====");
        for (Map.Entry<Integer, String> entry : MENU_OPTIONS.entrySet()) {
            System.out.printf("%d. %s%n", entry.getKey(), entry.getValue());
        }
        System.out.println("Choose an option: ");
    }

    private static int readOption() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void doAction(int option) {
        switch (option) {
            case 1 -> showBooksAvailable();
            case 2 -> pickBook();
            case 3 -> returnBook();
            case 4 -> showAllBooks();
            case 5 -> showAllAuthors();
            case 6 -> System.out.println("Exit.....");
            default -> System.out.println("Please, choose a valid option...");
        }
    }

    private static void showBooksAvailable() {
        List<Book> available = library.listBooksAvailable();
        if (available.isEmpty()) {
            System.out.println("We have no books available");
        } else {
            System.out.println("Books Available: ");
            available.forEach(book -> System.out.println(book.getId() + ": " + book.getTitle()));
        }
    }

    private static void pickBook() {
        showBooksAvailable();
        System.out.print("Insert ID of book: ");
        int id = readOption();

        Book book = library.searchBookForId(id);
        if (book != null && book.isAvailable()) {
            System.out.print("Insert your name: ");
            String name = scanner.nextLine();
            library.lendBook(book, name);
            System.out.println("Success...");
        } else {
            System.out.println("Book not found or unavailable");
        }
    }

    private static void returnBook() {
        List<Lend> activeLens = library.listActiveLends();
        if(activeLens.isEmpty()) {
            System.out.println("No books to return");
            return;
        }

        System.out.println("Active lends");
        for(Lend lend : activeLens) {
            System.out.printf("Lend ID: %d - Book: %s - User: %s%n",
                    lend.getId(),
                    lend.getBook().getTitle(),
                    lend.getUserName());
        }
        System.out.println("Insert ID of the lend to return: ");
        int lendID = readOption();
        library.returnBook(lendID);
        System.out.println("Book returned successfully...");
    }

    private static void showAllBooks() {
        List<Book> todos = library.listBooks();
        if (todos.isEmpty()) {
            System.out.println("No book registered");
        } else {
            System.out.println("All books: ");
            todos.forEach(book -> {
                String status = book.isAvailable() ? "Available" : "Unavailable";
                System.out.printf("%d - %s [%s]%n", book.getId(), book.getTitle(), status);
            });
        }
    }

    private static void showAllAuthors() {
        List<Author> authors = library.listAuthors();
        if (authors.isEmpty()) {
            System.out.println("No authors registered");
        } else {
            System.out.println("All authors:");
            authors.forEach(author -> System.out.println(author.getId() + ": " + author.getName()));

        }
    }

    private static void loadingData() {
        Author autor1 = new Author(1, "J.K. Rowling", new Date());
        Author autor2 = new Author(2, "J.R.R. Tolkien", new Date());

        library.addAuthor(autor1);
        library.addAuthor(autor2);

        library.addBook(new Book(1, "Harry Potter e a Pedra Filosofal", autor1));
        library.addBook(new Book(2, "O Senhor dos Anéis: A Sociedade do Anel", autor2));
        library.addBook(new Book(3, "Harry Potter e a Câmara Secreta", autor1));
    }
}

