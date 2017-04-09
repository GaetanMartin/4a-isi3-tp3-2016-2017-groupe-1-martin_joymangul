package people;

import org.junit.Before;
import people.EfficientPerson;

/**
 * Created by Gaetan on 09/04/2017.
 * Efficient Person Test
 */
public class EfficientPersonTest extends AbstractPersonneTest {

    @Before
    public void setUp() {
        this.iPerson = new EfficientPerson("Gaetan", "MARTIN", 23);
    }

}
