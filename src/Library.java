import java.util.ArrayList;
import java.util.Objects;


public class Library {
    private ArrayList<Book> books;
    public Library() {
        books = new ArrayList<>();
    }
    public void addBook(Book book) throws InvalidBookException {
        if(book == null) {
            throw new InvalidBookException("Book should not be null"); //??
        }
        books.add(book);

    }
    private Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
    public void borrowBook(String title) throws BookNotFoundException, EmptyLibraryException {
        if (books == null) {
            throw new EmptyLibraryException("Library is empty, no books to borrow");
        }
        if (Objects.isNull(findBook(title))) {
            throw new BookNotFoundException("Book with title \" " + title + " \" not found");
        }
        System.out.println(title + " borrowed successfully");

    }

    public void returnBook(String title)throws BookNotFoundException {
        for (Book book : books) {
            if (Objects.equals(findBook(title), book.getTitle())) {
                System.out.println(title + " returned successfully");
                System.out.println("Book's info: " + book.toString());
                return;
            }
        }
        throw new BookNotFoundException("Cannot return. book with title " + title + " not found");
    }
    public void listBooks() throws EmptyLibraryException{
        if (books.isEmpty()) {
            throw new EmptyLibraryException("Library is empty");
        }
        else {
            System.out.println("Books in Library:");
            for (Book book : books) {
                System.out.println(book.toString());
            }
        }
    }

}
