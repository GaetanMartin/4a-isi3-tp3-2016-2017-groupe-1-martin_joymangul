package people;

import org.junit.Before;

/**
 * Created by Gaetan on 09/04/2017.
 * SmallCodePersonTest
 */
public class SmallCodePersonTest extends AbstractPersonneTest {
    @Before
    public void setUp() {
        this.iPerson = new SmallCodePerson("Brad", "Pitt", BIRTHYEAR, BIRTHMONTH, BIRTHDAY);
    }
}
