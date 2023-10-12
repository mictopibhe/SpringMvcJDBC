package pl.davidduke.spring.dao;

import org.springframework.stereotype.Component;
import pl.davidduke.spring.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_ID;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_ID, "Dima", 25, "dickzamen@gmail.com"));
        people.add(new Person(++PEOPLE_ID, "Ivan", 27, "loki27@gmail.com"));
        people.add(new Person(++PEOPLE_ID, "Eugene", 28, "yenyenyen@gmail.com"));
        people.add(new Person(++PEOPLE_ID, "Anton", 24, "chempionkoziatyna@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_ID);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
