import java.util.Scanner;

public class LibraryMenu {

    public static void printLibraryMenu() {

        System.out.println("""
                
                     LIBRARY MENU
                (Authorize personnel only!
                
                Type in number:
                
                1 - Book Management
                2 - eBook Management
                3 - Member Management
                
                4 - Exit

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


        while (true) {

            printLibraryMenu();
            int userResponse = scanner.nextInt();

            switch (userResponse) {
                case 1: {

                    printBookMenu();

                    while (true) {

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
                                break;
                            }
                            default: {
                                System.out.println("Incorrect input. Try again or type in '9' for Menu");
                                break;
                            }
                        }
                        if (userResponse == 10) {
                            System.out.println("Returning to Main Menu...");
                            break;
                        }
                    }
                    break;


                }

                case 2: {
                    printEBookMenu();

                    while (true) {
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
                            }
                            case 8: {
                                printEBookMenu();
                                break;
                            }
                            case 9: {
                                break;
                            }
                        }
                        if (userResponse == 9) {
                            System.out.println("Returning to Main Menu...");
                            break;
                        }
                    }
                    break;
                }


                case 3: {
                    printMemberMenu();

                    while (true) {
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
                                break;
                            }
                        }
                        if (userResponse == 9) {
                            System.out.println("Returning to Main Menu...");
                            break;
                        }
                    }

                    break;

                }

                case 4: {
                    System.out.println("Quitting...");
                    return;
                }


            }
        }

    }

}
