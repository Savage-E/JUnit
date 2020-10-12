import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import ru.mail.library.BookModel;
import ru.mail.library.LibraryFactory;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestFirst extends TestBase{
    @Inject
    private @NotNull LibraryFactory  libraryFactory;

     @Test
    public void libraryFactoryInitializeTest(){
        ArrayList<BookModel> expected = new ArrayList<>();
        int capacity=10;
        for (int i = 0; i < capacity; i++) {
            expected.add(null);
        }
        ArrayList<BookModel> actual = libraryFactory.library(10);
        assertTrue(actual.contains(null));
        assertEquals(expected.size(),actual.size());
    }



}
