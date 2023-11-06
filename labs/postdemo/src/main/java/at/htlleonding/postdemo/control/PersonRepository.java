package at.htlleonding.postdemo.control;


import at.htlleonding.postdemo.entity.Person;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonRepository {

    private List<Person> persons = new ArrayList<>(25);

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void add(Person person) {
        persons.add(person);
    }
}
