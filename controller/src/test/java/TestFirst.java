import com.google.inject.Inject;
import net.lamberto.junit.GuiceJUnitRunner;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import ru.mail.library.BookModel;
import ru.mail.library.BooksFactory;
import ru.mail.library.LibraryFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class TestFirst extends TestBase{
    @Inject
    private @NotNull LibraryFactory  libraryFactory;

     @Test
    public void libraryFactoryInitializeTest(){
        libraryFactory= Mockito.mock(LibraryFactory.class);
        Mockito.when(libraryFactory.library(Mockito.anyInt())).thenReturn((new ArrayList<BookModel>()));
         assertThat(libraryFactory.library(2) ,is(empty()));
         assertThat(libraryFactory.library(2) ,hasSize(0));
     }


}
