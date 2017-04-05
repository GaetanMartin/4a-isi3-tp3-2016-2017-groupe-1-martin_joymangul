package personne;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Null;
import persons.Person;

import java.util.GregorianCalendar;

public class PersonneTest {

    protected static final int THEORIC_AGE = 23;

    protected static final int BIRTHDAY = 3;
    protected static final int BIRTHMONTH = 12;
    protected static final int BIRTHYEAR = 1993;

    protected Person person;
    protected GregorianCalendar testDate;

    @Before
    public void setUp() {
        person = new Person("Jensen", "JOYMANGUL", BIRTHYEAR, BIRTHMONTH, BIRTHDAY);
    }


    @Test(expected = NullPointerException.class)
    public void should_give_null_pointer_on_null_date_wasBorn() {
        // Given
        testDate = null;

        // When
        boolean result = person.wasBorn(testDate);

        // Then
        // assertThat(result).isTrue();
    }

    @Test (expected = NullPointerException.class)
    public void should_give_null_pointer_on_null_date_getAge() {
        // Given
        testDate = null;

        // When
        int age = person.getAge(testDate);

        // Then
        // assertThat(age == THEORIC_AGE).isTrue();
    }

    @Test
    public void should_give_true_on_date_after_wasBorn()  {
        // Given
        testDate = new GregorianCalendar(2017, 5,30);

        // When
        boolean result = person.wasBorn(testDate);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    public void should_give_23_on_date_after_getAge()  {
        // Given
        testDate = new GregorianCalendar(2017, 5,4);

        // When
        int age = person.getAge(testDate);

        // Then
        assertThat(age == 23).isTrue();
    }

    @Test
    public void should_give_0_on_date_less_than_1_year_getAge()  {
        // Given
        testDate = new GregorianCalendar(1994, 1,1);

        // When
        int age = person.getAge(testDate);

        // Then
        assertThat(age == 0).isTrue();
    }

}
