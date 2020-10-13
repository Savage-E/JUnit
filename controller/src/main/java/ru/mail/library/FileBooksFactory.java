package ru.mail.library;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

@Singleton
public final class FileBooksFactory implements BooksFactory {
    @NotNull
    private static final Type listBooksType = new TypeToken<ArrayList<BookModel>>() {
    }.getType();


    @Inject
    public FileBooksFactory() {
    }

    @NotNull
    @Override
    public Collection<BookModel> books(@NotNull String fileName) {
        try {
            return new Gson().fromJson(new BufferedReader(new FileReader(fileName)), listBooksType);
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }


}
