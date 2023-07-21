import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.*;

class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]));
        }
        //System.out.println(persons);
        //System.out.println("\n");

        System.out.println("\nНЕСОВЕРШЕННОЛЕНТНИЕ");
        Collection<Person> minorPersons = persons.stream()
                .filter(pers -> pers.getAge() < 18)
                .collect(Collectors.toList());
        minorPersons.forEach(System.out::println);

        System.out.println("\nВОЕННООБЯЗАННЫЕ");
        Collection<Person> combatantCitizens = persons.stream()
                .filter(pers -> pers.getSex() == Sex.MAN)
                .filter(pers -> pers.getAge() >= 18 && pers.getAge() <= 27)
                .collect(Collectors.toList());
        combatantCitizens.forEach(System.out::println);

        System.out.println("\nРАБОТОСПОСОБНЫЕ МУЖЧИНЫ");
        List<Person> productiveMen = persons.stream()
                .filter(pers -> pers.getEducation() == Education.HIGHER)
                .filter(pers -> pers.getAge() >= 18 && pers.getAge() <= 65)
                .filter(pers -> pers.getSex() == Sex.MAN)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        productiveMen.forEach(System.out::println);

        System.out.println("\nРАБОТОСПОСОБНЫЕ ЖЕНЩИНЫ");
        List<Person> productiveWomen = persons.stream()
                .filter(pers -> pers.getEducation() == Education.HIGHER)
                .filter(pers -> pers.getAge() >= 18 && pers.getAge() <= 60)
                .filter(pers -> pers.getSex() == Sex.WOMAN)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        productiveWomen.forEach(System.out::println);

        System.out.println("\nРАБОТОСПОСОБНЫЕ МУЖЧИНЫ и ЖЕНЩИНЫ");
        List<Person> productivePeople = persons.stream()
                .filter(pers -> pers.getAge() >= 18)
                .filter(pers -> pers.getEducation() == Education.HIGHER)
                .filter(pers -> pers.getSex() == Sex.MAN ? pers.getAge() <= 65 : pers.getAge() <= 60)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        productivePeople.forEach(System.out::println);
    }
}