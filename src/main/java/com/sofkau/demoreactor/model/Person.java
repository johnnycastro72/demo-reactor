package com.sofkau.demoreactor.model;

import java.util.Objects;

public class Person {

    private Integer idPersona;
    private String name;
    private Integer age;

    public Person(Integer idPersona, String name, Integer age) {
        this.idPersona = idPersona;
        this.name = name;
        this.age = age;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPersona=" + idPersona +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return idPersona.equals(person.idPersona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersona);
    }
}
