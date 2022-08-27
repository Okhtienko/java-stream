package com.expertsoft.model;

import java.util.Objects;

public class SubjectMark {
    private int studentId;
    private int subjectId;
    private int teacherId;
    private int mark;

    public SubjectMark(int studentId, int subjectId, int teacherId, int mark) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.mark = mark;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectMark that = (SubjectMark) o;
        return studentId == that.studentId &&
                subjectId == that.subjectId &&
                teacherId == that.teacherId &&
                mark == that.mark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, subjectId, teacherId, mark);
    }
}
