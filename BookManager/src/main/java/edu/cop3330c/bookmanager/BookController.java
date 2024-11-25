// BookController.java
// D. Singletary
// 11/20/24
// Book controller component in MVC example

package edu.cop3330c.bookmanager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookController {
    private List<Book> books;
    private BookView view;

    public BookController(BookView view) {
        this.books = new ArrayList<>();
        this.view = view;
    }

    public void addBook(String title) {
        books.add(new Book(title));
        view.showMessage("Book added: " + title);
    }

    public void displayBooks() {
        view.displayBooks(books);
    }

    public void saveBooksToFile(String fileName) {
        // TODO: create an ObjectOutputStream named oos that nests
        //       a FileOutputStream constructed from fileName
        //       The streams must be created in a try-with-resources
        try (...) {
            oos.writeObject(books);
            view.showMessage("Books saved to file: " + fileName);
        } catch (IOException e) {
            view.showMessage("Error saving books: " + e.getMessage());
        }
    }

    public void loadBooksFromFile(String fileName) {
        // TODO: create an ObjectInputStream named ois that nests
        //       a FileInputStream constructed from fileName
        //       The streams must be created in a try-with-resources
        try (...) {
            books = (List<Book>) ois.readObject();
            view.showMessage("Books loaded from file: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            view.showMessage("Error loading books: " + e.getMessage());
        }
    }

    public void handleUserInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            view.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    addBook(title);
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    saveBooksToFile("books.dat");
                    break;
                case 4:
                    loadBooksFromFile("books.dat");
                    break;
                case 5:
                    view.showMessage("Exiting program...");
                    return;
                default:
                    view.showMessage("Invalid choice. Try again.");
            }
        }
    }
    public static void main(String[] args) {
        BookView view = new BookView();
        BookController controller = new BookController(view);
        controller.handleUserInput();
    }
}
