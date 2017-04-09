package people;

import org.junit.Before;
import people.OneMorePerson;

/**
 * Created by Gaetan on 09/04/2017.
 * OneMorePersonTest
 */
public class OneMorePersonTest extends AbstractPersonneTest {
    @Before
    public void setUp()  {
        this.iPerson = new OneMorePerson("Tom", "Hanks", BIRTHYEAR, BIRTHMONTH, BIRTHDAY);
    }
}
