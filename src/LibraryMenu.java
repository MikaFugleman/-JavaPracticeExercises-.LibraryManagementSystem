import java.util.Scanner;

public class LibraryMenu {


    public static void printMenu() {
        System.out.println("""
                
                    WELCOME TO THE LIBRARY!
                
                Type in number:
                
                1 - Library Management (Authorized only!)
                2 - Member's Menu
                
                3 - Exit.
                
                """);
    }

    public static void printUserMenu() {
        System.out.println("""
                        MEMBER MENU
                
                Please select an option:
                
                1 - View Available Books
                2 - Borrow a Book
                3 - Return a Book
                4 - View Borrowed Books
                5 - Download eBooks
                6 - View Downloaded eBooks
                7 - Delete eBook
                
                8 - Print Menu
                9 - Return
                
                """);
    }

    public static void printLibraryMenu() {

        System.out.println("""
                
                     LIBRARY MENU
                (Authorize personnel only!)
                
                Type in number:
                
                1 - Book Management
                2 - eBook Management
                3 - Member Management
                
                4 - Return

                """);
    }

    public static void printBookMenu() {
        System.out.println("""
                
                    BOOK MANAGEMENT
                
                Type in number:
                
                1 - Add Book
                2 - Remove Book
                3 - Search Book
                4 - Display All Books
                5 - Check Book Availability
                6 - Total Book Number
                
                7 - Save Book List
                8 - Load Book List
                
                9 - Print Menu
                10 - Return
                
                """);
    }

    public static void printEBookMenu() {
        System.out.println("""
                
                    eBOOK MANAGEMENT
                
                Type in number:
                
                1 - Add eBook
                2 - Remove eBook
                3 - Search eBook
                4 - Display All eBooks
                5 - Total eBook Number
                
                6 - Save eBook List
                7 - Load eBook List
                
                8 - Print Menu
                9 - Return
                
                """);
    }

    public static void printMemberMenu() {
        System.out.println("""
                
                    MEMBER MANAGEMENT
                
                Type in number:
                
                1 - Add Member
                2 - Remove Member
                3 - Display Members
                4 - Search Member (By Name)
                5 - Search Member (By ID)
                
                6 - Save Members List
                7 - Load Members List
                
                8 - Print Menu
                9 - Return
                
                """);
    }

    public static void getLibraryMenu() {

        Library lib1 = new Library();
        Scanner scanner = new Scanner(System.in);

        lib1.loadProgress();

        while (true) {

            printMenu();
            int userResponse = scanner.nextInt();

            switch (userResponse) {
                case 1: {

                    libraryMenu:
                    while (true) {

                        printLibraryMenu();
                        userResponse = scanner.nextInt();

                        switch (userResponse) {
                            case 1: {

                                bookMenu:
                                while (true) {

                                    printBookMenu();
                                    userResponse = scanner.nextInt();

                                    switch (userResponse) {
                                        case 1: {
                                            lib1.addBook();
                                            break;
                                        }
                                        case 2: {
                                            lib1.removeBook();
                                            break;
                                        }
                                        case 3: {
                                            lib1.searchBook();
                                            break;
                                        }
                                        case 4: {
                                            lib1.displayAllBooks();
                                            break;
                                        }
                                        case 5: {
                                            lib1.checkBookAvailable();
                                            break;
                                        }
                                        case 6: {
                                            lib1.countBooks();
                                            break;
                                        }
                                        case 7: {
                                            lib1.saveBooks("books");
                                            break;
                                        }
                                        case 8: {
                                            lib1.loadBooks("books");
                                            break;
                                        }
                                        case 9: {
                                            printBookMenu();
                                            break;
                                        }
                                        case 10: {
                                            break bookMenu;
                                        }
                                        default: {
                                            System.out.println("Incorrect input. Try again or type in '9' for Menu");
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                            case 2: {

                                eBookMenu:
                                while (true) {
                                    printEBookMenu();
                                    userResponse = scanner.nextInt();

                                    switch (userResponse) {
                                        case 1: {
                                            lib1.addEBook();
                                            break;
                                        }
                                        case 2: {
                                            lib1.removeEBook();
                                            break;
                                        }
                                        case 3: {
                                            lib1.searchEBook();
                                            break;
                                        }
                                        case 4: {
                                            lib1.displayAllEBooks();
                                            break;
                                        }
                                        case 5: {
                                            lib1.countEBooks();
                                            break;
                                        }
                                        case 6: {
                                            lib1.saveEBook("eBooks");
                                            break;
                                        }
                                        case 7: {
                                            lib1.loadEBook("eBooks");
                                            break;
                                        }
                                        case 8: {
                                            printEBookMenu();
                                            break;
                                        }
                                        case 9: {
                                            break eBookMenu;
                                        }
                                        default: {
                                            System.out.println("Incorrect input. Try again or type in '8' for Menu");
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                            case 3: {

                                memberMenu:
                                while (true) {
                                    printMemberMenu();
                                    userResponse = scanner.nextInt();

                                    switch (userResponse) {
                                        case 1: {
                                            lib1.addMember();
                                            break;
                                        }
                                        case 2: {
                                            lib1.removeMember();
                                            break;
                                        }
                                        case 3: {
                                            lib1.displayMembers();
                                            break;
                                        }
                                        case 4: {
                                            lib1.searchMemberByName();
                                            break;
                                        }
                                        case 5: {
                                            lib1.searchMemberByID();
                                            break;
                                        }
                                        case 6: {
                                            lib1.saveMembers("members");
                                            break;
                                        }
                                        case 7: {
                                            lib1.loadMembers("members");
                                            break;
                                        }
                                        case 8: {
                                            printMemberMenu();
                                            break;
                                        }
                                        case 9: {
                                            break memberMenu;
                                        }
                                        default: {
                                            System.out.println("Incorrect input. Try again or type in '8' for Menu");
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                            case 4: {
                                break libraryMenu;
                            }
                            default: {
                                System.out.println("Incorrect input. Try again.");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2: {

                    System.out.println("Please enter your memberID: ");
                    int ID = scanner.nextInt();
                    scanner.nextLine();

                    Member member = null;

                    while (member == null) {
                        for (Member searchedMember : lib1.getMembersList()) {
                            if (searchedMember.getMemberID() == ID) {
                                member = searchedMember;
                                break;
                            }
                        }

                        if (member == null) {
                            System.out.println("Member ID not found. Please enter a valid memberID: ");
                            ID = scanner.nextInt();
                            scanner.nextLine();
                        }
                    }

                    System.out.println("\n\tWelcome, " + member.getName() + "!");

                    userMenu:
                    while (true) {

                        printUserMenu();
                        userResponse = scanner.nextInt();

                        switch (userResponse) {
                            case 1: {
                                lib1.displayAllBooks();
                                break;
                            }
                            case 2: {
                                member.borrowBook(lib1.findBookForUserMenu());
                                break;
                            }
                            case 3: {
                                member.returnBook(lib1.findBookForUserMenu());
                                break;
                            }
                            case 4: {
                                member.printBorrowedBooks();
                                break;
                            }
                            case 5: {
                                member.downloadEBook(lib1.findEBookForUserMenu());
                                break;
                            }
                            case 6: {
                                System.out.println(member.getDownloadedEBooks());
                                break;
                            }
                            case 7: {
                                member.deleteEBook(lib1.findEBookForUserMenu());
                                break;
                            }
                            case 8: {
                                printUserMenu();
                                break;
                            }
                            case 9: {
                                break userMenu;
                            }
                            default: {
                                System.out.println("Invalid choice. Please try again.");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Saving session: ");
                    lib1.saveProgress();

                    System.out.println("Quitting...");
                    return;
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

}
