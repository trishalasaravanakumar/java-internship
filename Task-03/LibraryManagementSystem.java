import java.util.*;
class Book {
    int id;
    String title;
    String author;
    boolean issued;
    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        int choice = 0;
        while (choice != 7) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Available Books");
            System.out.println("4. Search Book");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            in.nextLine();
            if (choice == 1) {
                System.out.print("Enter Book ID: ");
                int id = in.nextInt();
                in.nextLine();
                System.out.print("Enter Book Title: ");
                String title = in.nextLine();
                System.out.print("Enter Author: ");
                String author = in.nextLine();
                books.add(new Book(id, title, author));
                System.out.println("Book added successfully.");
            } else if (choice == 2) {
                System.out.print("Enter Book ID: ");
                int id = in.nextInt();
                boolean found = false;
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).id == id) {
                        books.remove(i);
                        found = true;
                        System.out.println("Book removed successfully.");
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Book not found.");
                }
            } else if (choice == 3) {
                boolean found = false;
                System.out.println("\nAvailable Books:");
                for (Book book : books) {
                    if (!book.issued) {
                        System.out.println("ID: " + book.id + " | Title: " + book.title + " | Author: " + book.author);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No available books.");
                }
            } else if (choice == 4) {
                System.out.println("1. Search by ID");
                System.out.println("2. Search by Title");
                System.out.print("Enter choice: ");
                int searchChoice = in.nextInt();
                in.nextLine();
                boolean found = false;
                if (searchChoice == 1) {
                    System.out.print("Enter Book ID: ");
                    int id = in.nextInt();
                    for (Book book : books) {
                        if (book.id == id) {
                            System.out.println("Book Found!");
                            System.out.println("ID: " + book.id);
                            System.out.println("Title: " + book.title);
                            System.out.println("Author: " + book.author);
                            System.out.println("Status: " + (book.issued ? "Issued" : "Available"));
                            found = true;
                            break;
                        }
                    }
                } else if (searchChoice == 2) {
                    System.out.print("Enter Book Title: ");
                    String title = in.nextLine();
                    for (Book book : books) {
                        if (book.title.equalsIgnoreCase(title)) {
                            System.out.println("Book Found!");
                            System.out.println("ID: " + book.id);
                            System.out.println("Title: " + book.title);
                            System.out.println("Author: " + book.author);
                            System.out.println("Status: " + (book.issued ? "Issued" : "Available"));
                            found = true;
                        }
                    }
                }
                if (!found) {
                    System.out.println("Book not found.");
                }
            } else if (choice == 5) {
                System.out.print("Enter Book ID: ");
                int id = in.nextInt();
                boolean found = false;
                for (Book book : books) {
                    if (book.id == id) {
                        found = true;
                        if (!book.issued) {
                            book.issued = true;
                            System.out.println("Book issued successfully.");
                        } else {
                            System.out.println("Book is already issued.");
                        }
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Book not found.");
                }
            } else if (choice == 6) {
                System.out.print("Enter Book ID: ");
                int id = in.nextInt();
                boolean found = false;
                for (Book book : books) {
                    if (book.id == id) {
                        found = true;
                        if (book.issued) {
                            book.issued = false;
                            System.out.println("Book returned successfully.");
                        } else {
                            System.out.println("Book is already available.");
                        }
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Book not found.");
                }
            } else if (choice == 7) {
                System.out.println("Thank you!");
            } else {
                System.out.println("Invalid choice.");
            }
        }
        in.close();
    }
}
