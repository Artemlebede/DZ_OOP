package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Класс, представляющий семейное древо
public class FamilyTree implements Serializable, Iterable<Person> {
    private static final long serialVersionUID = 1L;
    private List<Person> people;

    // Конструктор
    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    // Добавление человека в семейное древо
    public void addPerson(Person person) {
        this.people.add(person);
    }

    // Поиск детей
    public List<Person> getChildren(Person parent) {
        return parent.getChildren();
    }

    // Поиск человека по имени
    public Person findPersonByName(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    // Получение списка всех людей
    public List<Person> getPeople() {
        return people;
    }

    // Реализация метода iterator() для поддержки цикла for-each
    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }

    // Сортировка по имени
    public void sortByName() {
        Collections.sort(people, (p1, p2) -> p1.getName().compareTo(p2.getName()));
    }

    // Сортировка по году рождения
    public void sortByBirthYear() {
        Collections.sort(people, (p1, p2) -> Integer.compare(p1.getBirthYear(), p2.getBirthYear()));
    }
}