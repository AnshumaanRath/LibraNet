import Book.Book;
import AudioBook.AudioBook;
import Emagazine.EMagazine;
import LibraNetItem.LibraryItem;
import Interfaces.PlayAble;
import com.CustomException.CustomException;

import java.util.*;

public class Main {

    private static List<LibraryItem> library = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\n===== LibraNet Menu =====");
                System.out.println("1. Admin Menu");
                System.out.println("2. Customer Menu");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> adminMenu();
                    case 2 -> customerMenu();
                    case 3 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println(" Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.err.println(" Please enter a valid number.");
                sc.nextLine(); // clear bad input
            }
        }
    }


    private static void adminMenu() {
        while (true) {
            try {
                System.out.println("\n--- Admin Menu ---");
                System.out.println("1. Add Book");
                System.out.println("2. Add AudioBook");
                System.out.println("3. Add EMagazine");
                System.out.println("4. Back");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> addBook();
                    case 2 -> addAudioBook();
                    case 3 -> addEMagazine();
                    case 4 -> { return; }
                    default -> System.out.println(" Invalid choice.");
                }
            } catch (InputMismatchException e) {
                System.err.println("️ Invalid input, please enter a number.");
                sc.nextLine();
            }
        }
    }

    private static void addBook() {
        try {
            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Title: ");
            String title = sc.nextLine();
            System.out.print("Enter Author: ");
            String author = sc.nextLine();
            System.out.print("Enter Page Count: ");
            int pages = sc.nextInt();

            Book b1 = new Book(id, title, author, pages);
            library.add(b1);
            System.out.println(" Book added successfully.");
        } catch (InputMismatchException e) {
            System.err.println("️ Page count must be a number.");
            sc.nextLine();
        }
    }

    private static void addAudioBook() {
        try {
            System.out.print("Enter AudioBook ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Title: ");
            String title = sc.nextLine();
            System.out.print("Enter Author: ");
            String author = sc.nextLine();
            System.out.print("Enter Duration (in minutes): ");
            int duration = sc.nextInt();

            AudioBook a1 = new AudioBook(id, title, author, duration);
            library.add(a1);
            System.out.println(" AudioBook added successfully.");
        } catch (InputMismatchException e) {
            System.err.println("️ Duration must be a number.");
            sc.nextLine();
        }
    }

    private static void addEMagazine() {
        try {
            System.out.print("Enter EMagazine ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Title: ");
            String title = sc.nextLine();
            System.out.print("Enter Author: ");
            String author = sc.nextLine();
            System.out.print("Enter Issue Number: ");
            int issue = sc.nextInt();

            EMagazine m1 = new EMagazine(id, title, author, issue);
            library.add(m1);
            System.out.println(" EMagazine added successfully.");
        } catch (InputMismatchException e) {
            System.err.println("️ Issue number must be a number.");
            sc.nextLine();
        }
    }


    private static void customerMenu() {
        while (true) {
            try {
                System.out.println("\n--- Customer Menu ---");
                System.out.println("1. View Items");
                System.out.println("2. Borrow Item");
                System.out.println("3. Return Item");
                System.out.println("4. Play AudioBook");
                System.out.println("5. Archive EMagazine");
                System.out.println("6. Back");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> viewItems();
                    case 2 -> borrowItem();
                    case 3 -> returnItem();
                    case 4 -> playAudioBook();
                    case 5 -> archiveMagazine();
                    case 6 -> { return; }
                    default -> System.out.println(" Invalid choice.");
                }
            } catch (InputMismatchException e) {
                System.err.println(" Please enter a valid number.");
                sc.nextLine();
            }
        }
    }

    private static void viewItems() {
        if (library.isEmpty()) {
            System.out.println("️ No items in library.");
            return;
        }
        for (LibraryItem item : library) {
            item.showDetails();
        }
    }

    private static void borrowItem() {
        try {
            System.out.print("Enter Item ID to borrow: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter duration (e.g., '7 days'): ");
            String duration = sc.nextLine();

            for (LibraryItem item : library) {
                if (item.getId() == id) {
                    try {
                        item.borrow(duration);
                    } catch (CustomException e) {
                        System.err.println(" " + e.getMessage());
                    }
                    return;
                }
            }
            System.out.println(" Item not found.");
        } catch (InputMismatchException e) {
            System.err.println(" Invalid input.");
            sc.nextLine();
        }
    }

    private static void returnItem() {
        try {
            System.out.print("Enter Item ID to return: ");
            int id = sc.nextInt();
            System.out.print("Enter overdue days: ");
            int overdue = sc.nextInt();

            for (LibraryItem item : library) {
                if (item.getId() == id) {
                    item.returnItem(overdue);
                    return;
                }
            }
            System.out.println(" Item not found.");
        } catch (InputMismatchException e) {
            System.err.println(" Overdue must be a number.");
            sc.nextLine();
        }
    }

    private static void playAudioBook() {
        try {
            System.out.print("Enter AudioBook ID: ");
            int id = sc.nextInt();

            for (LibraryItem item : library) {
                if (item.getId() == id && item instanceof PlayAble playable) {
                    playable.play();
                    return;
                }
            }
            System.out.println(" AudioBook not found.");
        } catch (InputMismatchException e) {
            System.err.println(" ID must be a number.");
            sc.nextLine();
        }
    }

    private static void archiveMagazine() {
        try {
            System.out.print("Enter EMagazine ID: ");
            int id = sc.nextInt();

            for (LibraryItem item : library) {
                if (item.getId() == id && item instanceof EMagazine mag) {
                    mag.archiveIssue();
                    return;
                }
            }
            System.out.println(" EMagazine not found.");
        } catch (InputMismatchException e) {
            System.err.println(" ID must be a number.");
            sc.nextLine();
        }
    }
}
