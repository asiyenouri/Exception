import java.util.ArrayList;
import java.lang.Throwable;

public class Library {
    private ArrayList<Book> books;
    public Library() {
        Library books = new Library(); //??
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
        for (Book book : books) {
            if (!(findBook(title).equals(book))) {
                throw new BookNotFoundException("Book with \" " + title + " \" not found");
            }
            else {
                System.out.println(title + " borrowed successfully");
                System.out.println("Book's info: " + book.toString());
            }
        }
    }
    public void returnBook(String title)throws BookNotFoundException {
        for (Book book : books) {
            if (findBook(title).equals(book)) {
                System.out.println(title + " returned successfully");
                System.out.println("Book's info: " + book.toString());
            }
            else {
                throw new BookNotFoundException()
            }
        }
    }
    public void listBooks() throws EmptyLibraryException{}

}
