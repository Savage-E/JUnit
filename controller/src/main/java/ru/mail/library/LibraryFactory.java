package ru.mail.library;

import java.util.ArrayList;

public interface LibraryFactory {
    ArrayList<BookModel> library(int capacity);
}
