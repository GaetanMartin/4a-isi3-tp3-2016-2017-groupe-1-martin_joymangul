import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import persons.IPerson;
import persons.Person;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by p1509413 on 05/04/2017.
 * Question 7
 */
public class OutilsPersonTest {

    private List<IPerson> persons;

    private GregorianCalendar testDate;

    @Before
    public void setUp() {

        this.persons = new ArrayList<>();
        this.testDate = new GregorianCalendar(2000, 10, 5);
        //this.testDate = any(GregorianCalendar.class);

        Person person = mock(Person.class);
        when(person.getAge(testDate)).thenReturn(10);
        persons.add(person);
        person = mock(Person.class);
        when(person.getAge(this.testDate)).thenReturn(20);
        persons.add(person);

    }

    @Test
    public void testRangePersons() {
        assertThat(OutilsPerson.getInstance().getPersonsInRangeAge(this.persons, testDate, 15, 25).size()).isEqualTo(1);
        // verifyDataAreAnonymouslyCalled();
    }

    @Test
    public void testMaxAge() {
        assertThat(OutilsPerson.getInstance().getMaxAge(this.persons, this.testDate)).isEqualTo(20);
        // verifyDataAreAnonymouslyCalled();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_get_illegal_argument_exception() {
        OutilsPerson.getInstance().getPersonsInRangeAge(this.persons, this.testDate, 25, 15);
    }

    @Test
    public void should_get_minus1_getMaxAge() {
        List<IPerson> personsEmpty = new ArrayList<>();
        int age = OutilsPerson.getInstance().getMaxAge(personsEmpty, this.testDate);
        assertThat(age == -1).isEqualTo(true);
//        // verifyDataAreAnonymouslyCalled();
    }

    @Test
    public void should_get_empty_list() {
        assertThat(OutilsPerson.getInstance().getPersonsInRangeAge(
                this.persons, testDate, 70, 90).size()).isEqualTo(0);
        // verifyDataAreAnonymouslyCalled();
    }

    /**
     * Check that the mocks are anonymously filling the persons
     */
    @After
    public void verifyDataAreAnonymouslyCalled() {
        for (IPerson person : this.persons) {
            verify(person, never()).getFirstName();
            verify(person, never()).getName();
            verify(person, atLeastOnce()).getAge(any(GregorianCalendar.class));
        }
    }

}
