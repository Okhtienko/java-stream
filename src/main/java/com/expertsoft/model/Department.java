package com.expertsoft.model;

import java.util.Objects;
import java.util.Set;

public class Department {
    private int id;
    private Set<Student> students;
    private Set<Subject> subjects;
    private Teacher head;

    public Department(int id, Set<Student> students, Set<Subject> subjects, Teacher head) {
        this.id = id;
        this.students = students;
        this.subjects = subjects;
        this.head = head;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Teacher getHead() {
        return head;
    }

    public void setHead(Teacher head) {
        this.head = head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                Objects.equals(students, that.students) &&
                Objects.equals(subjects, that.subjects) &&
                Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, students, subjects, head);
    }
}
