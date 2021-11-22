package me.iit.w8springdb.repository;

import me.iit.w8springdb.service.People;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PeopleModal {
    @Id
    @GeneratedValue
    private Long id;

    private int age;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PeopleModal() {}

    public PeopleModal(Long id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public PeopleModal(People people) {
        this.age = people.getAge();
        this.name = people.getName();
    }
}
