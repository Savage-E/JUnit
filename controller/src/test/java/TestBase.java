import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import ru.mail.library.LibraryFactory;
import ru.mail.library.LibraryFactoryImpl;

public class TestBase {
    protected Injector injector = Guice.createInjector(new AbstractModule() {
        @Override
        protected void configure() {
            bind(LibraryFactory.class).to(LibraryFactoryImpl.class);
        }
    });

    @Before
    public void setup() {
        injector.injectMembers(this);
    }
}

