package ru.mail.library;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class LibraryController {

    private @NotNull
    ArrayList<BookModel> library;
    private @NotNull
    String fileName;
    private @NotNull
    ArrayList<BookModel> books;



    public LibraryController(int capacity, @NotNull String fileName) {
        this.fileName = fileName;
        final Injector injector = Guice.createInjector(new MainModule());
        library = injector.getInstance(LibraryFactoryImpl.class).library(capacity);
        books = (ArrayList<BookModel>) injector.getInstance(BooksFactory.class).books(fileName);
        fillLibrary(books);
    }

    public void takeBook(int cell) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            if (library.get(cell) == null)
                throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Cell is empty!");
        }
        System.out.println("Cell " + cell + " :");
        System.out.println(gson.toJson(library.get(cell)));
        library.set(cell, null);
    }

    public void addBook(BookModel book) {
        try {
            if (!library.contains(null))
                throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Library is full");
        }
        int cell = library.indexOf(null);
        library.set(cell, book);
    }

    public void printContent() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        for (int i = 0; i < library.size(); i++) {
            System.out.println("Cell " + i + " :" + gson.toJson(library.get(i)));
        }
    }

    private void fillLibrary(ArrayList<BookModel> books) {
        if (books.size() <= library.size()) {
            for (int i = 0; i < books.size(); i++) {
                library.set(i, books.get(i));
            }
        } else
            throw new IndexOutOfBoundsException();

    }

}
