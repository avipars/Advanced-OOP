package LSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Book {
    String title, author;
    int year;
    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}

class BookCatalog{
    protected Book[] books = {
            new Book("1984", "George Orwell", 1949),
            new Book("Animal Farm", "George Orwell", 1945),
            new Book("To Kill a Mockingbird", "Harper Lee", 1960),
            new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925),
            new Book("Brave New World", "Aldous Huxley", 1932),
            new Book("The Catcher in the Rye", "J.D. Salinger", 1951),
            new Book("Fahrenheit 451", "Ray Bradbury", 1953),
            new Book("The Grapes of Wrath", "John Steinbeck", 1939),
    };
    protected String acceptableCharsTitle = "[a-zA-Z0-9\\s]+";
    protected String acceptableCharsAuthor = "[a-zA-Z\\s]+";

    public ArrayList<Book> getBooks(String criteria){

        //valid books array - empty for now and then add dynamically
        ArrayList<Book> validBooks = new ArrayList<>();
        //precondition criteria is  name of author in english or name of title in english

        for(Book b : books){
            if(b.author.equalsIgnoreCase(criteria) || b.title.equalsIgnoreCase(criteria)){
                //add book to valid books
                //only accept in ENGLISH or numbers
                    //regex strings in english or numbers
                if (b.author.matches(acceptableCharsAuthor) && b.title.matches(acceptableCharsTitle)) {
                    validBooks.add(b);
                }
            }
        }

        //post condition return book published between 1940 and 2019
        for(Book b : validBooks){
           // remove any book that is not published between 1940 and 2019
            if(b.year < 1940 || b.year > 2019){
                validBooks.remove(b);
            }
        }
        return validBooks;
    }

    // do a stream version of the same thing above
    public ArrayList<Book> getBooksStream(String criteria) {
        return Arrays.stream(books)
                .filter(b -> b.author.matches(acceptableCharsAuthor) && b.title.matches(acceptableCharsTitle))
                .filter(b -> b.author.equalsIgnoreCase(criteria) || b.title.equalsIgnoreCase(criteria))
                .filter(b -> b.year >= 1940 && b.year <= 2019)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void printEntries(ArrayList<Book> books) {
        for (Book book : books) {
            System.out.println(book.title + " by " + book.author + " (" + book.year + ")");
        }
    }

    // sort comparator for sorting by
    public static java.util.Comparator<Book> bookComparator = new java.util.Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {
            // if title is same then compare by author and then year

            int titleComparison = b1.title.compareToIgnoreCase(b2.title);
            if (titleComparison != 0) {
                return titleComparison;
            } else {
                int authorComparison = b1.author.compareToIgnoreCase(b2.author);
                if (authorComparison != 0) {
                    return authorComparison;
                } else {
                    return Integer.compare(b1.year, b2.year);
                }
            }
        }
    };


    public static void main(String [] args){
        System.out.println("Book Catalog Example");
        BookCatalog catalog = new BookCatalog();
        ArrayList<Book> booksByAuthor = catalog.getBooks("George Orwell");
        //sort it by title name
        booksByAuthor.sort(bookComparator);
        ArrayList<Book> booksByAuthorStream = catalog.getBooksStream("George Orwell");
        //compare the two methods
        booksByAuthorStream.sort(bookComparator);

        System.out.println("Books by George Orwell:");
        printEntries(booksByAuthor);
        System.out.println("Books by George Orwell (Stream):");
        printEntries(booksByAuthorStream);


        ArrayList<Book> booksByTitle = catalog.getBooks("1984");
        booksByTitle.sort(bookComparator);

        ArrayList<Book> booksByTitleStream = catalog.getBooksStream("1984");
        booksByTitleStream.sort(bookComparator);

        System.out.println("Books with title '1984':");
        printEntries(booksByTitle);
        System.out.println("Books with title '1984' (Stream):");
        printEntries(booksByTitleStream);
    }
}

class BookCatalogChild extends BookCatalog {
    // This class can override methods or add new functionality if needed
    // For now, it inherits the methods from BookCatalog
    String acceptableCharsAuthor =
            "[a-zA-Zא-ת\\s]+"; //english or hebrew
    String acceptableCharsTitle =
            "[a-zA-Zא-ת0-9\\s]+"; //english or hebrew

    @Override
    public ArrayList<Book> getBooks(String criteria) {
        // preconditon : name of author in English/Hebrew or title in English/Hebrew

        // postcondition: return books published between 1940 and 1980
        ArrayList<Book> validBooks = new ArrayList<>();

        for(Book b : books){
            if(b.author.equalsIgnoreCase(criteria) || b.title.equalsIgnoreCase(criteria)){
                //add book to valid books
                //only accept in ENGLISH or numbers
                //regex strings in english or numbers
                if (b.author.matches(acceptableCharsAuthor) && b.title.matches(acceptableCharsTitle)) {
                    validBooks.add(b);
                }
            }
        }

        //post condition return book published between 1940 and 2019
        for(Book b : validBooks){
            // remove any book that is not published between 1940 and 2019
            if(b.year < 1940 || b.year > 2019){
                validBooks.remove(b);
            }
        }
        return validBooks;

    }

    public static void main(String[] args) {
        System.out.println("Book Catalog Child Example");
        BookCatalogChild catalogChild = new BookCatalogChild();
        ArrayList<Book> booksByAuthor = catalogChild.getBooks("George Orwell");
        //sort it by title name
        booksByAuthor.sort(bookComparator);
        ArrayList<Book> booksByAuthorStream = catalogChild.getBooksStream("George Orwell");
        //compare the two methods
        booksByAuthorStream.sort(bookComparator);

        System.out.println("Books by George Orwell:");
        printEntries(booksByAuthor);
        System.out.println("Books by George Orwell (Stream):");
        printEntries(booksByAuthorStream);
    }

}

