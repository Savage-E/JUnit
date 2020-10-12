package ru.mail.library;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public interface LibraryFactory {
    ArrayList<BookModel> library(int capacity);
}
