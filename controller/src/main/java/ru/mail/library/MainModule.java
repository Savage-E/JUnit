package ru.mail.library;

import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(BooksFactory.class).to(FileBooksFactory.class);
        bind(LibraryFactory.class).to(LibraryFactoryImpl.class);
    }
}
