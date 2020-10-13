import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import org.mockito.Mockito;
import ru.mail.library.BookModel;
import ru.mail.library.LibraryFactory;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LibraryFactoryTest extends TestBase {
    @Inject
    private @NotNull LibraryFactory libraryFactory;

    @Test
    public void libraryFactoryInitializeTest() {
        libraryFactory = Mockito.mock(LibraryFactory.class);
        Mockito.when(libraryFactory.library(Mockito.anyInt())).thenReturn((new ArrayList<BookModel>()));
        assertThat(libraryFactory.library(2), is(empty()));
        assertThat(libraryFactory.library(2), hasSize(0));
    }


}
