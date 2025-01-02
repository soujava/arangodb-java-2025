package org.soujava.demos.arangodb.graph;


import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.Objects;


@Entity
public class Person {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String occupation;

    @Column
    private Double salary;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    /**
     * @deprecated default constructor
     */
    Person() {
    }

    Person(String name, int age, String occupation, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.occupation = occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person person)) {
            return false;
        }
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {

        private String name;

        private int age;

        private String occupation;

        private Double salary;


        public PersonBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder withOccupation(String occupation) {
            this.occupation = occupation;
            return this;
        }

        public PersonBuilder withSalary(Double salary) {
            this.salary = salary;
            return this;
        }

        public Person build() {
            return new Person(name, age, occupation, salary);
        }
    }

}