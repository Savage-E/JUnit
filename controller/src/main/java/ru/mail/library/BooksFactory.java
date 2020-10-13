package ru.mail.library;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface BooksFactory {
    Collection<BookModel> books(@NotNull String fileName);
}
