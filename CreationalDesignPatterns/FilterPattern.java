import java.util.ArrayList;
import java.util.List;

interface Criteria {
    List<Person> meetCriteria(List<Person> persons);
}

class Person {
    String name;
    String gender;

    Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }
}

class MaleCriteria implements Criteria {
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> males = new ArrayList<>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("Male")) {
                males.add(person);
            }
        }
        return males;
    }
}

class FemaleCriteria implements Criteria {
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> females = new ArrayList<>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("Female")) {
                females.add(person);
            }
        }
        return females;
    }
}

class AndCriteria implements Criteria {
    private Criteria criteria1;
    private Criteria criteria2;

    AndCriteria(Criteria criteria1, Criteria criteria2) {
        this.criteria1 = criteria1;
        this.criteria2 = criteria2;
    }

    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPersons = criteria1.meetCriteria(persons);
        return criteria2.meetCriteria(firstCriteriaPersons);
    }
}

public class FilterPatternDemo {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", "Male"));
        persons.add(new Person("Jane", "Female"));
        persons.add(new Person("Michael", "Male"));
        persons.add(new Person("Emily", "Female"));

        Criteria male = new MaleCriteria();
        Criteria female = new FemaleCriteria();
        Criteria maleAndFemale = new AndCriteria(male, female);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));

        System.out.println("\nFemales: ");
        printPersons(female.meetCriteria(persons));

        System.out.println("\nMale and Female: ");
        printPersons(maleAndFemale.meetCriteria(persons));
    }

    public static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println("Person: " + person.getName() + ", Gender: " + person.getGender());
        }
    }
}
