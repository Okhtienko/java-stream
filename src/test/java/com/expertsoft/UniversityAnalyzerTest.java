package com.expertsoft;

import com.expertsoft.model.*;
import org.assertj.core.util.Sets;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

public class UniversityAnalyzerTest {
    private final static UniversityAnalyzer universityAnalyzer = new UniversityAnalyzer();

    private List<Student> students;

    private List<Teacher> teachers;

    private List<Department> departments;

    private Department mathDep;

    @Test
    public void getMinSubjectMark() {
        OptionalInt minSubjectMark = universityAnalyzer.getMinSubjectMark(students.stream(), 1);

        Assert.assertEquals(7, minSubjectMark.getAsInt());
    }

    @Test
    public void getAverageTeacherMark() {
        OptionalDouble averageTeacherMark = universityAnalyzer.getAverageTeacherMark(students.stream(), 2);

        Assert.assertEquals(8.4, averageTeacherMark.getAsDouble(), 0.001);
    }

    @Test
    public void getAverageStudentAgeInYears() {
        int minStudentAge = universityAnalyzer.getMinStudentAgeInYears(students.stream());

        Assert.assertEquals(19, minStudentAge);
    }

    @Test
    public void getStudentWithHighestAverageMark() {
        Student student = universityAnalyzer.getStudentWithHighestAverageMark(students.stream());

        Assert.assertEquals(2, student.getId());
    }

    @Test
    public void sortStudentsByCountOfMarks() {
        List<Student> sortedStudents = universityAnalyzer.sortStudentsByCountOfMarks(students.stream());

        Assert.assertEquals(2, sortedStudents.get(0).getId());
        Assert.assertEquals(3, sortedStudents.get(1).getId());
        Assert.assertEquals(1, sortedStudents.get(2).getId());
        Assert.assertEquals(4, sortedStudents.get(3).getId());
    }

    @Test
    public void getSubjectsByAcademicPerformance() {
        List<Integer> subjectsByAcademicPerformance = universityAnalyzer.getSubjectsByAcademicPerformance(students.stream());

        Assert.assertEquals(5, subjectsByAcademicPerformance.get(0).intValue());
        Assert.assertEquals(3, subjectsByAcademicPerformance.get(1).intValue());
        Assert.assertEquals(2, subjectsByAcademicPerformance.get(2).intValue());
        Assert.assertEquals(1, subjectsByAcademicPerformance.get(3).intValue());
        Assert.assertEquals(4, subjectsByAcademicPerformance.get(4).intValue());
    }

    @Test
    public void getSubjectWhichLeadsMostOfAllTeachers() {
        Subject subjectThatMostTeachersLead = universityAnalyzer.getSubjectThatMostTeachersLead(teachers.stream());

        Assert.assertEquals(3, subjectThatMostTeachersLead.getId());
    }

    @Test
    public void getGraduatedExcellentStudents() {
        List<Student> graduatedExcellentStudents = universityAnalyzer.getGraduatedExcellentStudents(students.stream());

        Assert.assertEquals(1, graduatedExcellentStudents.size());
        Assert.assertEquals(2, graduatedExcellentStudents.get(0).getId());
    }

    @Test
    public void getHeadOfTheMostSuccessfulDepartment() {
        Teacher headOfTheMostSuccessfulDepartment = universityAnalyzer.getHeadOfTheMostSuccessfulDepartment(departments.stream());

        Assert.assertEquals(3, headOfTheMostSuccessfulDepartment.getId());
    }

    @Test
    public void getSubjectsThatHeadTeachesInHisDepartment() {
        List<Subject> subjectsThatHeadTeachesInHisDepartment = universityAnalyzer.getSubjectsThatHeadTeachesInHisDepartment(mathDep);

        Assert.assertEquals(1, subjectsThatHeadTeachesInHisDepartment.size());
        Assert.assertEquals(1, subjectsThatHeadTeachesInHisDepartment.get(0).getId());
    }

    @Before
    public void setUp() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        departments = new ArrayList<>();
        int currentYear = LocalDate.now().getYear();
        Student studentVlad = new Student(1, "Vlad", "Waltanov", new HashSet<>(), LocalDate.of(currentYear - 22, 1, 1));
        Student studentIgor = new Student(2, "Igor", "Yaremchuk", new HashSet<>(), LocalDate.of(currentYear - 21, 1, 1));
        Student studentAlex = new Student(3, "Alex", "Potapov", new HashSet<>(), LocalDate.of(currentYear - 19, 1, 1));
        Student studentDima = new Student(4, "Dima", "Kiselev", new HashSet<>(), LocalDate.of(currentYear - 23, 1, 1));

        Subject mathematics = new Subject(1, "mathematics");
        Subject chemistry = new Subject(2, "chemistry");
        Subject physics = new Subject(3, "physics");
        Subject computerScience = new Subject(4, "computer science");
        Subject literature = new Subject(5, "literature");

        Teacher teacherAndrei = new Teacher(1, "Andrei", "Ivanov", Sets.newLinkedHashSet(mathematics, chemistry, physics));
        Teacher teacherMax = new Teacher(2, "Max", "Zhilin", Sets.newLinkedHashSet(computerScience, literature, physics));
        Teacher teacherDima = new Teacher(3, "Dima", "Petrov", Sets.newLinkedHashSet(mathematics, physics, literature));

        mathDep = new Department(1, new HashSet<>(), new HashSet<>(), teacherAndrei);
        mathDep.getStudents().addAll(Arrays.asList(studentVlad, studentDima));
        mathDep.getSubjects().addAll(Arrays.asList(mathematics, computerScience));
        Department physDep = new Department(1, new HashSet<>(), new HashSet<>(), teacherDima);
        physDep.getStudents().addAll(Arrays.asList(studentIgor, studentAlex));

        SubjectMark markVladMathematics = new SubjectMark(studentVlad.getId(), mathematics.getId(), teacherAndrei.getId(), 9);
        SubjectMark markVladPhysics = new SubjectMark(studentVlad.getId(), physics.getId(), teacherAndrei.getId(), 6);
        SubjectMark markVladComputerScience = new SubjectMark(studentVlad.getId(), computerScience.getId(), teacherMax.getId(), 9);
        SubjectMark markVladLiterature = new SubjectMark(studentVlad.getId(), literature.getId(), teacherDima.getId(), 4);

        SubjectMark markIgorMathematics = new SubjectMark(studentIgor.getId(), mathematics.getId(), teacherDima.getId(), 8);
        SubjectMark markIgorPhysics = new SubjectMark(studentIgor.getId(), physics.getId(), teacherMax.getId(), 9);
        SubjectMark markIgorComputerScience = new SubjectMark(studentIgor.getId(), computerScience.getId(), teacherMax.getId(), 10);
        SubjectMark markIgorChemistry = new SubjectMark(studentIgor.getId(), chemistry.getId(), teacherAndrei.getId(), 5);
        SubjectMark markIgorLiterature = new SubjectMark(studentIgor.getId(), literature.getId(), teacherDima.getId(), 10);

        SubjectMark markAlexMathematics = new SubjectMark(studentAlex.getId(), mathematics.getId(), teacherDima.getId(), 7);
        SubjectMark markAlexLiterature = new SubjectMark(studentAlex.getId(), literature.getId(), teacherDima.getId(), 6);
        SubjectMark markAlexComputerScience = new SubjectMark(studentAlex.getId(), computerScience.getId(), teacherMax.getId(), 9);
        SubjectMark markAlexChemistry = new SubjectMark(studentAlex.getId(), chemistry.getId(), teacherAndrei.getId(), 9);

        SubjectMark markDimaPhysics = new SubjectMark(studentDima.getId(), physics.getId(), teacherAndrei.getId(), 6);
        SubjectMark markDimaComputerScience = new SubjectMark(studentDima.getId(), computerScience.getId(), teacherMax.getId(), 5);
        SubjectMark markDimaChemistry = new SubjectMark(studentDima.getId(), chemistry.getId(), teacherAndrei.getId(), 9);

        studentVlad.getSubjectMarks().addAll(Arrays.asList(markVladPhysics,
                markVladComputerScience,
                markVladLiterature,
                markVladMathematics));

        studentIgor.getSubjectMarks().addAll(Arrays.asList(markIgorChemistry,
                markIgorComputerScience,
                markIgorMathematics,
                markIgorPhysics,
                markIgorLiterature));

        studentAlex.getSubjectMarks().addAll(Arrays.asList(markAlexChemistry,
                markAlexComputerScience,
                markAlexLiterature,
                markAlexMathematics));

        studentDima.getSubjectMarks().addAll(Arrays.asList(markDimaChemistry,
                markDimaComputerScience,
                markDimaPhysics));

        students.addAll(Arrays.asList(studentVlad, studentIgor, studentAlex, studentDima));
        teachers.addAll(Arrays.asList(teacherDima, teacherAndrei, teacherMax));
        departments.addAll(Arrays.asList(mathDep, physDep));
    }
}