package personne;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import persons.IPerson;
import persons.Person;

import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by p1509413 on 05/04/2017.
 *
 */
public abstract class AbstractPersonneTest {

    protected static final int BIRTHDAY = 3;
    protected static final int BIRTHMONTH = 12;
    protected static final int BIRTHYEAR = 1993;

    protected IPerson iPerson;

    public AbstractPersonneTest(IPerson person) {
        iPerson = person;
    }

    protected static int theorical_age = 23;

    protected GregorianCalendar testDate;



    @Test(expected = NullPointerException.class)
    public void should_give_null_pointer_on_null_date_wasBorn() {
        // Given
        testDate = null;

        // When
        boolean result = iPerson.wasBorn(testDate);

        // Then
        // assertThat(result).isTrue();
    }

    @Test
    @Ignore
    public void should_give_false_on_previous_date_wasBorn() {
        // Given
        testDate = new GregorianCalendar(1993, 12, 2);

        // When
        boolean wasBorn = iPerson.wasBorn(testDate);

        // Then
        assertThat(wasBorn).isFalse();
    }

    @Test
    public void should_give_true_on_birth_date_wasBorn() {
        // Given
        testDate = new GregorianCalendar(BIRTHYEAR, BIRTHMONTH, BIRTHDAY);

        // When
        boolean wasBorn = iPerson.wasBorn(testDate);

        // Then
        assertThat(wasBorn).isTrue();
    }

    @Test
    public void should_give_true_after_date_wasBorn() {
        // Given
        testDate = new GregorianCalendar(2017, 5, 30);

        // When
        boolean wasBorn = iPerson.wasBorn(testDate);

        // Then
        assertThat(wasBorn).isTrue();
    }


    @Test (expected = NullPointerException.class)
    public void should_give_null_pointer_on_null_date_getAge() {
        // Given
        testDate = null;

        // When
        int age = iPerson.getAge(testDate);

        // Then
        // assertThat(age == THEORIC_AGE).isTrue();
    }

    @Test
    public void should_give_zero_on_previous_date_getAge() {
        // Given
        testDate = new GregorianCalendar(1993, 12, 2);
        theorical_age = 0;

        // When
        int age = iPerson.getAge(testDate);

        // Then
        assertThat(age == theorical_age).isTrue();
    }

    @Test
    public void should_give_23_on_after_date_getAge() {
        // Given
        testDate = new GregorianCalendar(2017, 5, 4);
        theorical_age = 23;

        // When
        int age = iPerson.getAge(testDate);

        // Then
        assertThat(age == theorical_age).isTrue();
    }



    @Test
    public void should_give_zero_on_birth_date_getAge() {
        // Given
        testDate = new GregorianCalendar(BIRTHYEAR, BIRTHMONTH, BIRTHDAY);
        theorical_age = 0;

        // When
        int age = iPerson.getAge(testDate);

        // Then
        assertThat(age == theorical_age).isTrue();
    }

    @Test
    public void should_give_zero_on_birth_date__less_than_1_year_getAge() {
        // Given
        testDate = new GregorianCalendar(1994, 1, 1);
        theorical_age = 0;

        // When
        int age = iPerson.getAge(testDate);

        // Then
        assertThat(age == theorical_age).isTrue();
    }

    @Test
    public void should_give_correct_age_on_bissectile_date_getAge() {
        // Given
        testDate = new GregorianCalendar(2000, 12, 31);
        theorical_age = 7;

        // When
        int age = iPerson.getAge(testDate);

        // Then
        assertThat(age == theorical_age).isTrue();
    }

    public void testGetAge() {
        should_give_zero_on_birth_date__less_than_1_year_getAge();
        should_give_correct_age_on_bissectile_date_getAge();;
        should_give_null_pointer_on_null_date_getAge();
        should_give_zero_on_previous_date_getAge();
        should_give_zero_on_birth_date_getAge();
        should_give_23_on_after_date_getAge();
    }

    public void testWasBorn() {
        should_give_null_pointer_on_null_date_wasBorn();
        should_give_false_on_previous_date_wasBorn();
        should_give_true_on_birth_date_wasBorn();
        should_give_true_after_date_wasBorn();
    }

}
