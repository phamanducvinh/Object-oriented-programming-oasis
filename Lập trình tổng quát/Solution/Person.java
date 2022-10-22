public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String address;

    public Person() {
    }

    /**
     * Constructor.
     */
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return (name.compareTo(o.name) != 0 ? name.compareTo(o.name) : age - o.age);
    }
}
