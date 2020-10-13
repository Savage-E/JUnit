package ru.mail.library;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class LibraryApplication {
    public static void main(String[] args) {
        int capacity = 0;
        String fileName = "";

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter file address");
            fileName = scanner.nextLine();
            System.out.println("Enter library size");
            capacity = scanner.nextInt();

        } catch (IllegalStateException | NoSuchElementException e) {
            System.out.println(e);
        }

        LibraryController library = new LibraryController(capacity, fileName);
        library.printContent();


    }
}
