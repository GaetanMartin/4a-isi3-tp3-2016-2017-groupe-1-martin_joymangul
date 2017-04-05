package personne;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.internal.matchers.Null;
import persons.Person;

import java.util.GregorianCalendar;

public class PersonneTest {

    protected static int theorical_age = 23;

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
    @Ignore
    public void should_give_false_on_previous_date_wasBorn() {
        // Given
        testDate = new GregorianCalendar(1993, 12, 2);

        // When
        boolean wasBorn = person.wasBorn(testDate);

        // Then
        assertThat(wasBorn).isFalse();
    }

    @Test
    public void should_give_zero_on_previous_date_getAge() {
        // Given
        testDate = new GregorianCalendar(1993, 12, 2);

        // When
        int age = person.getAge(testDate);
        theorical_age = 0;

        // Then
        assertThat(age == theorical_age).isTrue();
    }

    @Test
    public void should_give_true_on_birth_date_wasBorn() {
        // Given
        testDate = new GregorianCalendar(BIRTHYEAR, BIRTHMONTH, BIRTHDAY);

        // When
        boolean wasBorn = person.wasBorn(testDate);

        // Then
        assertThat(wasBorn).isTrue();
    }

    @Test
    public void should_give_zero_on_birth_date_getAge() {
        // Given
        testDate = new GregorianCalendar(BIRTHYEAR, BIRTHMONTH, BIRTHDAY);

        // When
        int age = person.getAge(testDate);
        theorical_age = 0;

        // Then
        assertThat(age == theorical_age).isTrue();
    }

    @Test
    public void should_give_correct_age_on_bissectile_date_getAge() {
        // Given
        testDate = new GregorianCalendar(2000, 12, 31);

        // When
        int age = person.getAge(testDate);
        theorical_age = 7;

        // Then
        assertThat(age == theorical_age).isTrue();
    }

    public void testGetAge() {
        should_give_correct_age_on_bissectile_date_getAge();;
        should_give_null_pointer_on_null_date_getAge();
        should_give_zero_on_previous_date_getAge();
        should_give_zero_on_birth_date_getAge();
    }

    public void testWasBorn() {
        should_give_false_on_previous_date_wasBorn();
        should_give_null_pointer_on_null_date_wasBorn();
        should_give_true_on_birth_date_wasBorn();
    }

}
