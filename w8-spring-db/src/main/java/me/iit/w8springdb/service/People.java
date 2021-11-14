package me.iit.w8springdb.service;


import me.iit.w8springdb.repository.PeopleModal;

public class People {

    private Long id;
    private String name;
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public People(PeopleModal people) {
        this.id = people.getId();
        this.age = people.getAge();
        this.name = people.getName();
    }

    public People(Long id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public PeopleModal toEntity() {
        return new PeopleModal(id, age, name);
    }
}
