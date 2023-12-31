public class Person {
    private String name;
    private String family;
    private Integer age;
    private Sex sex;
    private Education edu;

    public Person(String name, String family, Integer age, Sex sex, Education edu) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.edu = edu;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return edu;
    }

    @Override
    public String toString() {
        return "Person {" +
                "name = '" + name + "\'" +
                ", family = '" + family + "\'" +
                ", age = " + age +
                ", sex = " + sex +
                ", education = " + edu + '}';

    }
}
