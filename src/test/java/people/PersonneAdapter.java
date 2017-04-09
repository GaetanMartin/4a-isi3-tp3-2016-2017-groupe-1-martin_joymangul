package people;

import persons.IPerson;

import java.util.GregorianCalendar;

/**
 * Created by Gaetan on 09/04/2017.
 * Personne Adapter - Question 5
 */
public class PersonneAdapter extends Personne implements IPerson {

    public PersonneAdapter(String s, String s1, int i, int i1, int i2) {
        super(s, s1, i, i1, i2);
    }

    @Override
    public int getAge(GregorianCalendar date) {
        int age = super.getAge(date);
        if (age == -1) {
            throw new IllegalArgumentException("Can not compute age before birth");
        }
        return age;
    }

    @Override
    public boolean wasBorn(GregorianCalendar gregorianCalendar) {
        return gregorianCalendar.before(this.dateNaissance);
    }
}
