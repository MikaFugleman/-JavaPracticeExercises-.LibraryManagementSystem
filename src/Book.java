public class Book {

    private final String title;
    private final String author;
    private final String ISBN;
    private boolean isBorrowed;


    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isBorrowed = false;
    }


    public String getTitle() {
        return title;
    }



    public String getAuthor() {
        return author;
    }


    public String getISBN() {
        return ISBN;
    }

    public String displayBookDetails() {
        String status = isBorrowed ? "Borrowed" : "Available";
        return String.format("Title: %s, Author: %s, ISBN: %s, Status: %s", title, author, ISBN, status);
    }


    public boolean isBorrowed() {
        return isBorrowed;
    }


    public void borrowBook() {

        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Book has been borrowed.");
            return;
        }
        System.out.println("Book is already borrowed.");
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Book has been returned.");
        }
        System.out.println("Book has already been returned.");
    }


}
