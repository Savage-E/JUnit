import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import ru.mail.library.LibraryController;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SecondTest {
   private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
   private final PrintStream originalOut = System.out;

   private  @NotNull LibraryController library=new LibraryController(2,"F:\\IntellijIdea\\JUnit\\controller\\src\\test\\resources\\books.txt");

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void createLibraryExceptionReturn(){
        new LibraryController(8, "F:\\IntellijIdea\\JUnit\\controller\\src\\main\\resources\\books.txt");
    }


    @Test
    public  void takeBookReturnBookInfo(){
        System.setOut(new PrintStream(outContent));
        library.takeBook(0);
        assertThat(outContent.toString(),allOf(containsString("Cell 0"), containsString("World and Peace"),containsString("Leo")));
    }

    @Test
    public void takeBookFromEmptyCell(){
        
    }

}
