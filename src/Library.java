import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Library {

    private LinkedList<Book> bookList;
    private LinkedList<eBook> eBooksList;
    private LinkedList<Member> membersList;

    public Library() {
        this.bookList = new LinkedList<>();
        this.eBooksList = new LinkedList<>();
        this.membersList = new LinkedList<>();
    }

    public LinkedList<Book> getBookList() {
        return bookList;
    }

    public LinkedList<eBook> getBooksList() {
        return eBooksList;
    }

    public LinkedList<Member> getMembersList() {
        return membersList;
    }

    Scanner scanner = new Scanner(System.in);


    // book-specific methods:
    public void addBook() {

        System.out.println("Adding a physical book. Please enter Book Title: ");
        String bookTitle = scanner.nextLine();

        System.out.println("Please enter Book Author: ");
        String bookAuthor = scanner.nextLine();

        System.out.println("Please enter Book ISBN: ");
        String ISBN = scanner.nextLine();


        System.out.println("\nAdding book: " + "Title: " + bookTitle + ", " + "Author: " + bookAuthor + ", ISBN: " + ISBN + " to library...");

        for (Book bookToBeAdded : bookList) {
            if (ISBN.equals(bookToBeAdded.getISBN())) {
                System.out.println("ISBN already taken. Please choose another.");
                return;
            }
        }

        bookList.add(new Book(bookTitle, bookAuthor, ISBN));
        System.out.println("Book added.");
    }

    public void removeBook() {

        System.out.println("Please enter ISBN to remove Book from Library: ");
        String bookISBN = scanner.nextLine();

        for (Book searchedBook : bookList) {
            if (searchedBook.getISBN().equalsIgnoreCase(bookISBN)) {
                System.out.println("\nRemoving book: Title: " + searchedBook.getTitle() + ", Author: " + searchedBook.getAuthor() + " from library...");
                bookList.remove(searchedBook);
                System.out.println("Book removed.");
                return;
            }
        }
        System.out.println("Book with ISBN: " + bookISBN + " not found.");
    }

    public void searchBook() {

        System.out.println("Searching for a physical Book. Please enter Title: ");
        String bookTitle = scanner.nextLine();

        for (Book searchedBook : bookList) {
            if (searchedBook.getTitle().equalsIgnoreCase(bookTitle)) {
                System.out.println("\nBook found: " + searchedBook.displayBookDetails());
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void displayAllBooks() {

        // Sorting the books by title:
        ArrayList<Book> booksArrayList = new ArrayList<>(bookList);
        booksArrayList.sort(Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
        bookList = new LinkedList<>(booksArrayList);


        // Displaying the sorted books:

        if (bookList.isEmpty()) {
            System.out.println("\nDisplaying library physical book list: ");
            System.out.println("Nothing to display as there are currently no physical books in the library.");
            return;
        }
        System.out.println("\nDisplaying library book list: ");
        for (Book book : bookList) {
            System.out.println(book.displayBookDetails());
        }


    }

    public void checkBookAvailable() {

        System.out.println("Checking if Book is available. Please enter Title: ");
        String bookTitle = scanner.nextLine();

        for (Book searchedBook : bookList) {
            if (searchedBook.getTitle().equalsIgnoreCase(bookTitle)) {
                System.out.println("\nBook found: ");
                System.out.println(searchedBook.displayBookDetails());
                String status = searchedBook.isBorrowed() ? "Not available / Borrowed" : "Available";
                System.out.println("Book is: " + status);
                return;
            }

        }
        System.out.println("Book not found.");
    }

    public void countBooks() {
        int count = 0;
        for (Book book : bookList) {
            count++;
        }
        System.out.println("\nTotal physical Books in library: " + count);
    }

    public void saveBooks(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Book book : bookList) {
                writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getISBN() + "," + book.isBorrowed());
                writer.newLine();
            }
            System.out.println("Books saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error while writing Books to file " + filename);
        }
    }

    public void loadBooks(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            bookList.clear();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String title = parts[0];
                String author = parts[1];
                String ISBN = parts[2];
                bookList.addLast(new Book(title, author, ISBN));
            }
            System.out.println("Books loaded from file " + filename);
        } catch (Exception e) {
            System.out.println("Error while reading from file " + filename);
        }
    }


// eBook-specific methods:

    public void addEBook() {

        System.out.println("Adding an eBook. Please enter Title: ");
        String title = scanner.nextLine();

        System.out.println("Please enter Author: ");
        String author = scanner.nextLine();

        System.out.println("Please enter ISBN: ");
        String ISBN = scanner.nextLine();

        System.out.println("Please enter Format: ");
        String format = scanner.nextLine();

        System.out.println("Please enter File Size: ");
        double fileSize = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Please enter Download Link: ");
        String link = scanner.nextLine();

        System.out.println("Please enter if eBook is DRM protected (true/false): ");
        boolean drm = scanner.nextBoolean();

        scanner.nextLine();


        System.out.println("\nAdding eBook: " + "Title: " + title + ", " + "Author: " + author + " to library...");
        eBooksList.add(new eBook(title, author, ISBN, format, fileSize, link, drm));
        System.out.println("Book added.");
    }

    public void removeEBook() {

        System.out.println("Please enter ISBN to remove eBook from Library: ");
        String bookISBN = scanner.nextLine();

        for (eBook searchedEBook : eBooksList) {
            if (searchedEBook.getISBN().equalsIgnoreCase(bookISBN)) {
                System.out.println("\nRemoving eBook: Title: " + searchedEBook.getTitle() + ", Author: " + searchedEBook.getAuthor() + " from library...");
                eBooksList.remove(searchedEBook);
                System.out.println("eBook removed.");
                return;
            }
        }
        System.out.println("eBook with ISBN: " + bookISBN + " not found.");
    }

    public void searchEBook() {

        System.out.println("Searching for a physical Book. Please enter Title: ");
        String eBookTitle = scanner.nextLine();

        for (Book searchedEBook : eBooksList) {
            if (searchedEBook.getTitle().equalsIgnoreCase(eBookTitle)) {
                System.out.println("\neBook found: " + searchedEBook.displayBookDetails());
                return;
            }
        }
        System.out.println("eBook not found.");

    }

    public void displayAllEBooks() {


        // Sorting the books by title:
        ArrayList<eBook> ebooksArrayList = new ArrayList<>(eBooksList);
        ebooksArrayList.sort(Comparator.comparing(eBook::getTitle, String.CASE_INSENSITIVE_ORDER));
        eBooksList = new LinkedList<>(ebooksArrayList);


        // Displaying the sorted books:

        if (eBooksList.isEmpty()) {
            System.out.println("\nDisplaying library eBook list: ");
            System.out.println("Nothing to display as there are currently no eBooks in the library.");
            return;
        }

        System.out.println("\nDisplaying library eBook list: ");
        for (eBook book : eBooksList) {
            System.out.println(book.displayBookDetails());
        }


    }

    public void countEBooks() {
        int count = 0;
        for (Book book : eBooksList) {
            count++;
        }
        System.out.println("\nTotal eBooks in library: " + count);
    }

    public void saveEBook(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (eBook book : eBooksList) {
                writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getISBN() + "," + book.getFormat() + "," +
                        book.getFileSize() + "," + book.getDownloadLink() + "," + book.isDrmProtected());
                writer.newLine();
            }
            System.out.println("eBooks save to file: " + filename);
        } catch (IOException e) {
            System.out.println("Failed to save eBooks to file: " + filename);
        }

    }

    public void loadEBook(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String title = parts[0];
                String author = parts[1];
                String ISBN = parts[2];
                String format = parts[3];
                double fileSize = Double.parseDouble(parts[4]);
                String link = parts[5];
                boolean drm = Boolean.parseBoolean(parts[6]);

                eBooksList.addLast(new eBook(title, author, ISBN, format, fileSize, link, drm));
            }
            System.out.println("eBooks saved to file: " + filename);
        } catch (Exception e) {
            System.out.println("Error while saving eBooks to file: " + filename);
        }
    }


// member-specific methods:


    public void addMember() {
        System.out.println("Adding new Library member. Please enter Name: ");
        String name = scanner.nextLine();

        int ID;
        boolean IDExists;

        do {
            System.out.println("Please enter member ID: ");
            ID = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            IDExists = false;
            for (Member searchedMember : membersList) {
                if (searchedMember.getMemberID() == ID) {
                    System.out.println("Member ID already exists. Please enter a unique ID number: ");
                    IDExists = true;
                    break;  // Exit the loop since we know the ID exists
                }
            }
        } while (IDExists);

        System.out.println("\nAdding member. Name: " + name + ", ID: " + ID);
        membersList.add(new Member(name, ID));
        System.out.println("Member added.");
    }

    public void removeMember () {

        System.out.println("Please enter member ID to remove a Library member: ");
        int ID = scanner.nextInt();
        scanner.nextLine();

        for (Member searchedMember : membersList) {
            if (searchedMember.getMemberID() == ID) {
                System.out.println("Removing member: ID: " + searchedMember.getMemberID() + ", Name: " + searchedMember.getName());
                membersList.remove(searchedMember);
                System.out.println("Member removed.");
                return;
            }
        }
        System.out.println("Member ID not found.");
    }

    public void displayMembers() {
        System.out.println("\nDisplaying library members: ");
        for (Member member : membersList) {
            System.out.println(member.displayMemberDetails());
        }
    }

    public void searchMemberByName() {
        System.out.println("Searching for Library member by Name. Please enter Name: ");
        String name = scanner.nextLine();

        for (Member searchedMember : membersList) {
            if (searchedMember.getName().equalsIgnoreCase(name)) {
                System.out.println("Member found:" + searchedMember.displayMemberDetails());
                return;
            }
        }
        System.out.println("Member not found.");

    }

    public void searchMemberByID() {

        System.out.println("Searching for Library member by ID. Please enter ID: ");
        int ID = scanner.nextInt();

        System.out.println("\nSearching for member. MemberID: " + ID);
        for (Member searchedMember : membersList) {
            if (searchedMember.getMemberID() == ID) {
                System.out.println("Member found:" + searchedMember.displayMemberDetails());
                return;
            }
        }
        System.out.println("Member not found.");

    }

    public void saveMembers (String filename) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Member member: membersList) {
                writer.write(member.getName() + "," + member.getMemberID());
                writer.newLine();
            }
            System.out.println("Members list saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error while saving members to file: " + filename);
        }
    }

    public void loadMembers (String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String []parts = line.split(",");
                String name = parts[0];
                int ID = Integer.parseInt(parts[1]);

                membersList.addLast(new Member(name, ID));
            }
            System.out.println("Members loaded from file: " + filename);
        } catch (Exception e) {
            System.out.println("Error while loading members from file: " + filename);
        }
    }

}