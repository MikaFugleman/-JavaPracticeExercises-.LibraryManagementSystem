import java.util.ArrayList;

public class Member {
    private final String name;
    private final int memberID;
    private final ArrayList<Book> borrowedBooks;
    private final ArrayList<eBook> downloadedEBooks;


    public Member(String name, int memberID) {
        this.name = name;
        this.memberID = memberID;
        this.borrowedBooks = new ArrayList<>();
        this.downloadedEBooks = new ArrayList<>();
    }

    // getters:

    public String getName() {
        return name;
    }

    public int getMemberID() {
        return memberID;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public ArrayList<eBook> getDownloadedEBooks() {
        return downloadedEBooks;
    }


    // Book-specific methods:

    public void returnBook(Book book) {

        // in case an eBook is passed as an argument instead of a regular book:
        if (book instanceof eBook) {
            System.out.println("eBooks can not be returned. You may delete them instead!");
            return;
        }

        if (!borrowedBooks.contains(book)) {
            System.out.println("Member does not have this book!");
            return;
        }
        borrowedBooks.remove(book);
        book.returnBook();
        System.out.println("Book has been returned.");
    }

    public void borrowBook(Book book) {

        // in case an eBook is passed as an argument instead of a regular book:
        if (book instanceof eBook) {
            System.out.println("\neBooks can not be borrowed. You can download eBooks instead!");
            return;
        }

        if (borrowedBooks.contains(book)) {
            System.out.println("This member has already borrowed this book!");
            return;
        }
        if (!book.isBorrowed()) {
            borrowedBooks.add(book);
            book.borrowBook();
            System.out.printf("Book - title: %s, author: %s, ISBN: %s has been borrowed by Member - " +
                    "Name: %s, memberID: %d%n", book.getTitle(), book.getAuthor(), book.getISBN(), name, memberID);
        } else {
            System.out.println("Book has already been borrowed by someone else.");
        }

    }


    // eBook-specific methods:

    public void downloadEBook(eBook book) {
        String drm = book.isDrmProtected() ? "Yes" : "No";

        if (downloadedEBooks.contains(book)) {
            System.out.println("This member has already downloaded this eBook!");
        } else {
            downloadedEBooks.add(book);
            System.out.println("\nDownloading eBook...");
            System.out.println("link: " + book.getDownloadLink());
            System.out.println("DRM protected: " + drm);
            System.out.println("File size: " + book.getFileSize() + "MB");
            System.out.printf("\neBook - \n\t(Title: %s, Author: %s, ISBN: %s, Format: %s)" +
                            "\nMember: " +
                            "\n\t (Name: %s, memberID: %dn).\n", book.getTitle(), book.getAuthor(),
                    book.getISBN(), book.getFormat(), name, memberID);
            System.out.println("\n...download complete.");
        }
    }

    public void deleteEBook(eBook book) {
        if (!downloadedEBooks.contains(book)) {
            System.out.println("Member does not have this book downloaded!");
            return;
        }
        downloadedEBooks.remove(book);
        System.out.println("\nBook has been deleted:");
        System.out.println(book.displayBookDetails());
    }


    // member-specific methods:

    public String displayMemberDetails() {

        StringBuilder borrowedBooksDetails = new StringBuilder();
        StringBuilder downloadedEBooksDetails = new StringBuilder();

        // Append details of borrowed physical books
        for (Book book : borrowedBooks) {
            borrowedBooksDetails.append("\n\t").append(book.displayBookDetails());
        }

        // Append details of downloaded eBooks
        for (eBook eBook : downloadedEBooks) {
            downloadedEBooksDetails.append("\n\t").append(eBook.displayBookDetails());
        }

        return String.format("\nName: %s, memberID: %d:\nBorrowed books: %s \nDownloaded eBooks: %s",
                name, memberID, borrowedBooksDetails.toString(), downloadedEBooksDetails.toString());
    }


    // overridden methods:
    @Override
    public String toString() {
        return displayMemberDetails();
    }


}
