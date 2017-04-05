import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import persons.IPerson;
import persons.Person;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;

/**
 * Created by p1509413 on 05/04/2017.
 * Question 7
 */
public class OutilsPersonTest {

    public List<IPerson> persons;

    public GregorianCalendar testDate;

    @Before
    public void setUp() {

        this.persons = new ArrayList<>();
        this.testDate = new GregorianCalendar(2000, 10, 5);
        //this.testDate = any(GregorianCalendar.class);

        Person person = Mockito.mock(Person.class);
        Mockito.when(person.getAge(testDate)).thenReturn(10);
        persons.add(person);
        person = Mockito.mock(Person.class);
        Mockito.when(person.getAge(this.testDate)).thenReturn(20);
        persons.add(person);

    }

    @Test
    public void testRangePersons() {
        assertThat(OutilsPerson.getPersonsInRangeAge(this.persons, testDate, 15, 25).size()).isEqualTo(1);
    }

    @Test
    public void testMaxAge() {
        assertThat(OutilsPerson.getMaxAge(this.persons, this.testDate)).isEqualTo(20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_get_illegal_argument_exception() {
        OutilsPerson.getPersonsInRangeAge(this.persons, this.testDate, 25, 15);
    }

    @Test
    public void should_get_minus1_getMaxAge() {
        List<IPerson> personsEmpty = new ArrayList<>();
        int age = OutilsPerson.getMaxAge(personsEmpty, this.testDate);
        assertThat(age == -1).isEqualTo(true);
    }


}
