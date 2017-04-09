package people;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import persons.Person;

public class PersonTest extends AbstractPersonneTest {

    public PersonTest(){
        super();
    };

    @Before
    public void setUp() {
        iPerson = new Person("Jensen", "JOYMANGUL", BIRTHYEAR, BIRTHMONTH, BIRTHDAY);
    }
}
