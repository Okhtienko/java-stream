package com.expertsoft.model;

import java.util.Objects;
import java.util.Set;

public class Teacher {
    private int id;
    private String name;
    private String surname;
    private Set<Subject> taughtSubjects;

    public Teacher(int id, String name, String surname, Set<Subject> taughtSubjects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.taughtSubjects = taughtSubjects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Subject> getTaughtSubjects() {
        return taughtSubjects;
    }

    public void setTaughtSubjects(Set<Subject> taughtSubjects) {
        this.taughtSubjects = taughtSubjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id &&
                Objects.equals(name, teacher.name) &&
                Objects.equals(surname, teacher.surname) &&
                Objects.equals(taughtSubjects, teacher.taughtSubjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, taughtSubjects);
    }
}
