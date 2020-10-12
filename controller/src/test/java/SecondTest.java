import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.library.AuthorModel;
import ru.mail.library.BookModel;
import ru.mail.library.LibraryController;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertTrue;

public class SecondTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private @NotNull
    LibraryController library = new LibraryController(6, "F:\\IntellijIdea\\JUnit\\controller\\src\\test\\resources\\books.txt");

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void createLibraryExceptionReturnTest() {
        new LibraryController(8, "F:\\IntellijIdea\\JUnit\\controller\\src\\main\\resources\\books.txt");
    }


    @Test
    public void takeBookReturnBookInfoTest() {
        library.takeBook(0);
        assertThat(outContent.toString(), allOf(containsString("Cell 0"), containsString("World and Peace"), containsString("Leo")));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void takeBookFromEmptyCellTest() {
        library.takeBook(0);
        library.takeBook(0);
    }

    @Test
    public void TakeNeededAndGetSameBookTest() {
        String[] expected = {"Cell 0", "Leo", "World and Peace"};
        library.takeBook(0);
        String actual = outContent.toString();
        assertTrue(actual.contains(expected[0]));
        assertTrue(actual.contains(expected[1]));
        assertTrue(actual.contains(expected[2]));


    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void putBookIntoFirstEmptyCellTest() {
        library.takeBook(2);
        library.takeBook(4);
        String[] expected = {"Cell 2", "TestAuthor", "TestBook"};
        library.addBook(new BookModel(new AuthorModel("TestAuthor"),"TestBook"));
        library.takeBook(4);
        String actual = outContent.toString();
        assertTrue(actual.contains(expected[0]));
        assertTrue(actual.contains(expected[1]));
        assertTrue(actual.contains(expected[2]));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addBookToFullLibraryTest(){
        library.addBook(new BookModel(new AuthorModel("TestAuthor"),"TestBook"));

    }

}
