import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import net.lamberto.junit.GuiceJUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import ru.mail.library.BooksFactory;
import ru.mail.library.FileBooksFactory;

import java.io.FileNotFoundException;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

@RunWith(GuiceJUnitRunner.class)
public class BooksFactoryTest {

    @Inject
    public BooksFactory booksFactory;

    @Test
    @GuiceJUnitRunner.GuiceModules(TestModule.class)
    public void testBooksFactory() {
        booksFactory = Mockito.mock(BooksFactory.class);
        Mockito.when(booksFactory.books(Mockito.anyString())).thenReturn(Collections.EMPTY_LIST);
        assertThat(booksFactory.books("F:\\IntellijIdea\\JUnit\\controller\\src\\test\\resources\\Books1.txt"), is(empty()));
    }

    @Test(expected = IllegalStateException.class)
    @GuiceJUnitRunner.GuiceModules(TestModule.class)
    public void FileNotFoundBooksFactoryTest() {
        booksFactory = Mockito.mock(BooksFactory.class);
        Mockito.when(booksFactory.books(Mockito.anyString())).thenThrow(IllegalStateException.class);
        booksFactory.books("src\\test\\resources\\Books1.txt");
    }

    public static class TestModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(BooksFactory.class).to(FileBooksFactory.class);
        }
    }
}

