import java.util.*;

// Book class - Kitabon ka data
class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public void issue() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    public boolean isAvailable() {
        return !isIssued;
    }

    public String toString() {
        return id + ": " + title + " by " + author + (isIssued ? " [Issued]" : " [Available]");
    }
}

// User class - Users aur unki borrowed books
class User {
    int userId;
    String name;
    ArrayList<Book> borrowedBooks;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.issue();
            borrowedBooks.add(book);
            System.out.println(name + " ne kitab li: " + book.title);
        } else {
            System.out.println(book.title + " already issued hai.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.returnBook();
            System.out.println(name + " ne kitab wapas ki: " + book.title);
        } else {
            System.out.println(name + " ke paas ye kitab nahi hai.");
        }
    }
}

// Library class - Books & Users ko manage karta hai
class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Book findBookById(int id) {
        for (Book b : books) {
            if (b.id == id) return b;
        }
        return null;
    }

    public User findUserById(int id) {
        for (User u : users) {
            if (u.userId == id) return u;
        }
        return null;
    }

    public void displayBooks() {
        System.out.println("\n--- Book List ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }
}

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        // ----------- Book Input -------------
        System.out.print("Kitni books add karni hain? ");
        int totalBooks = sc.nextInt();
        sc.nextLine(); // nextInt ke baad enter consume karne ke liye

        for (int i = 0; i < totalBooks; i++) {
            System.out.println("Book " + (i + 1) + " ka detail:");
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Enter clear karne ke liye

            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            library.addBook(new Book(id, title, author));
        }

        // ---------- User Input ---------------
        System.out.print("\nKitne users add karne hain? ");
        int totalUsers = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < totalUsers; i++) {
            System.out.println("User " + (i + 1) + " ka detail:");
            System.out.print("User ID: ");
            int uid = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            library.addUser(new User(uid, name));
        }

        // ----------- Menu System -------------
        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int uid1 = sc.nextInt();
                    System.out.print("Enter Book ID to borrow: ");
                    int bid1 = sc.nextInt();
                    User u1 = library.findUserById(uid1);
                    Book b1 = library.findBookById(bid1);
                    if (u1 != null && b1 != null) {
                        u1.borrowBook(b1);
                    } else {
                        System.out.println("User ya Book nahi mila.");
                    }
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    int uid2 = sc.nextInt();
                    System.out.print("Enter Book ID to return: ");
                    int bid2 = sc.nextInt();
                    User u2 = library.findUserById(uid2);
                    Book b2 = library.findBookById(bid2);
                    if (u2 != null && b2 != null) {
                        u2.returnBook(b2);
                    } else {
                        System.out.println("User ya Book nahi mila.");
                    }
                    break;

                case 4:
                    System.out.println("Library system se exit ho rahe hain...");
                    break;

                default:
                    System.out.println("Galat choice. Dubara try karo.");
            }

        } while (choice != 4);
    }
}


