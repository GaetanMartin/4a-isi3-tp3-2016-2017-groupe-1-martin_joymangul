import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import persons.IPerson;
import persons.Person;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

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

        if (ageMin > ageMax) throw new IllegalArgumentException("Age min > age max");

        /* Iterative way
        List<IPerson> returnPersons = new ArrayList<>();
        for (IPerson person : persons) {
            int age = person.getAge(date);
            if (age >= ageMin && age <= ageMax) {
                returnPersons.add(person);
            }
        }
        */

        /* Stream method */
        return persons.stream()
                .filter(person-> ageInRange(person.getAge(date), ageMin, ageMax))
                .collect(Collectors.toList());
    }

    /**
     * Test if  the given age is in the range [minAge, maxAge] given
     * @param age Age to test
     * @param ageMin lower bound included
     * @param ageMax higher bound included
     * @return true if in range, false else
     */
    private static boolean ageInRange(int age, int ageMin, int ageMax) {
        return age >= ageMin && age <= ageMax;
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
