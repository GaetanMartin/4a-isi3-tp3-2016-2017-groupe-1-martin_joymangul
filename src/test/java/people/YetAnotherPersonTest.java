package people;

import org.junit.Before;
import people.YetAnotherPerson;

/**
 * Created by Gaetan on 09/04/2017.
 * Yet Another Person Test
 */
public class YetAnotherPersonTest extends AbstractPersonneTest {

    @Before
    public void setUp() {
        this.iPerson = new YetAnotherPerson("Gaetan", "MARTIN", BIRTHYEAR, BIRTHMONTH, BIRTHDAY);
    }

}
