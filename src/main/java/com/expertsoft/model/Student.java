package com.expertsoft.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Student {
    private int id;
    private String name;
    private String surname;
    private Set<SubjectMark> subjectMarks;
    private LocalDate birthday;

    public Student(int id, String name, String surname, Set<SubjectMark> subjectMarks, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.subjectMarks = subjectMarks;
        this.birthday = birthday;
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

    public Set<SubjectMark> getSubjectMarks() {
        return subjectMarks;
    }

    public void setSubjectMarks(Set<SubjectMark> subjectMarks) {
        this.subjectMarks = subjectMarks;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(subjectMarks, student.subjectMarks) &&
                Objects.equals(birthday, student.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, subjectMarks, birthday);
    }
}
