package com.linux.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author guru.a.kulkarni
 */
public class StreamsTest {

    enum Gender {
        MALE,
        FEMALE,
        TRANSGENDER
    }

    private static class Person {

        private String firstName;
        private String lastName;
        private int age;
        private Gender gender;

        Person(String firstName, String lastName, int age, Gender gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.gender = gender;
        }

        String getFirstName() {
            return firstName;
        }

        void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        String getLastName() {
            return lastName;
        }

        void setLastName(String lastName) {
            this.lastName = lastName;
        }

        int getAge() {
            return age;
        }

        void setAge(int age) {
            this.age = age;
        }

        Gender getGender() {
            return gender;
        }

        void setGender(Gender gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender + '}';
        }
        
        
        
    }

    List<Person> persons;
    
    @Before
    public void setUp() {
        
        persons = Arrays.asList(
               new Person("John", "Doe", 20, Gender.MALE),
               new Person("Johnny", "Goode", 80, Gender.MALE),
               new Person("Jane", "Doe", 18, Gender.FEMALE),
               new Person("Kevin", "Minion", 100, Gender.MALE),
               new Person("Kevin", "Ross", 100, Gender.MALE),
               new Person("Bob", "Minion", 90, Gender.MALE),
               new Person("Sharen", "Valek", 25, Gender.FEMALE),
               new Person("Nicole", "Kidman", 45, Gender.FEMALE),
               new Person("Nicole", "Kidman", 40, Gender.FEMALE)
        );
    }
    
    
    /**
     * Destructive test, the comparator and Collections.sort change the input list!
     */
    @Test
    public void CollectionsTest() {
        Collections.sort(persons, (Person p1, Person p2) -> {return p1.firstName.compareTo(p2.firstName);});
        assertThat(persons.get(0).getFirstName(), is("Bob"));
    }

    @Test
    public void streamsTest() {
        Optional<Person> firstPerson = persons.stream()
                .sorted((Person p1, Person p2) -> {return p1.firstName.compareTo(p2.firstName);})
                .findFirst();
        
        assertTrue(firstPerson.isPresent());
        assertThat(persons.get(0).getFirstName(), is(not("Bob")));
        assertThat(firstPerson.get().getFirstName(), is("Bob"));
    }
}