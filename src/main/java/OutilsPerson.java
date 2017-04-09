import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import persons.IPerson;
import persons.Person;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by p1509413 on 05/04/2017.
 * TP - part 2
 */
public class OutilsPerson {

    private static OutilsPerson instance;

    private OutilsPerson() {}

    public static OutilsPerson getInstance() {
        if (instance == null) {
            instance = new OutilsPerson();
        }
        return instance;
    }


    /**
     * Question 6
     * @param persons persons
     * @param date testDate to test
     * @param ageMin min age
     * @param ageMax max age
     * @return list of persons in range
     */
    public List<IPerson> getPersonsInRangeAge(List<IPerson> persons, GregorianCalendar date, int ageMin, int ageMax) {
        List<IPerson> returnPersons = new ArrayList<>();

        if (ageMin > ageMax) throw new IllegalArgumentException("Age min > age max");

        for (IPerson person : persons) {
            if (person.getAge(date) >= ageMin && person.getAge(date) <= ageMax) {
                returnPersons.add(person);
            }
        }

        return returnPersons;
    }

    /**
     * Question 7
     * Browse the list to find the max age
     * @param persons list of persons to test
     * @return max Age
     */
    public int getMaxAge(List<IPerson> persons, GregorianCalendar date) {
        int maxAge = -1;
        for (IPerson person : persons) {
            if (person.getAge(date) > maxAge) {
                maxAge = person.getAge(date);
            }
        }
        return maxAge;
    }

}
