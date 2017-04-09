package people;

import org.junit.Before;

/**
 * Created by Gaetan on 09/04/2017.
 * SimplePersonTest
 */
public class SimplePersonTest extends AbstractPersonneTest {
    @Before
    public void setUp() {
        this.iPerson = new people.SimplePerson("Tom", "Hardy", BIRTHYEAR, BIRTHMONTH, BIRTHDAY);
    }
}
