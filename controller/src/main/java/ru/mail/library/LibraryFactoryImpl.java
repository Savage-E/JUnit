package ru.mail.library;

import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class LibraryFactoryImpl implements LibraryFactory {

    private @NotNull
    ArrayList<BookModel> library;

    @Inject
    public LibraryFactoryImpl() {
        library = new ArrayList<>();
    }


    @Override
    public ArrayList<BookModel> library(int capacity) {

        initLibrary(capacity);
        return library;
    }
    private void initLibrary(int capacity) {
        for (int i = 0; i < capacity; i++) {
            library.add(null);
        }
    }
}
