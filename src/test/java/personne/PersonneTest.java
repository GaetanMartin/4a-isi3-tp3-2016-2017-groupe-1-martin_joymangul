package personne;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.internal.matchers.Null;
import persons.IPerson;
import persons.Person;

import java.util.GregorianCalendar;

public class PersonneTest extends AbstractPersonneTest {

    public PersonneTest(){
        super();
    };

    @Before
    public void setUp() {
        iPerson = new Person("Jensen", "JOYMANGUL", BIRTHYEAR, BIRTHMONTH, BIRTHDAY);
    }
}
