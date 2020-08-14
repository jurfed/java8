package interfaceFactory;

/**
 * интерфейс фабрики
 * @param <Person>
 */
public interface PersonFactory<Person> {

    Person create(String firstName, String lastName);
}
