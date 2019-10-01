package training_center;

import training_center.entities.Course;
import training_center.entities.Curriculum;
import training_center.entities.Student;

import java.time.LocalDate;
import java.util.*;

public class CreateData {
    //------------Объявление курсов------------------
    private static final String COURSE_NAME_1 = "Технология Java Servlets";
    private static final int COURSE_DURATION_1 = 16;

    private static final String COURSE_NAME_2 = "Struts Framework";
    private static final int COURSE_DURATION_2 = 24;

    private static final String COURSE_NAME_3 = "Spring Framework";
    private static final int COURSE_DURATION_3 = 48;

    private static final String COURSE_NAME_4 = "Hibernate";
    private static final int COURSE_DURATION_4 = 20;

    private static final String COURSE_NAME_5 = "Обзор технологий Java";
    private static final int COURSE_DURATION_5 = 8;

    private static final String COURSE_NAME_6 = "Библиотека JFC/Swing";
    private static final int COURSE_DURATION_6 = 16;

    private static final String COURSE_NAME_7 = "Технология JDBC";
    private static final int COURSE_DURATION_7 = 16;

    private static final String COURSE_NAME_8 = "Технология JAX";
    private static final int COURSE_DURATION_8 = 52;

    private static final String COURSE_NAME_9 = "Библиотеки commons";
    private static final int COURSE_DURATION_9 = 44;

    private static Course course_1 = new Course(COURSE_NAME_1, COURSE_DURATION_1);
    private static Course course_2 = new Course(COURSE_NAME_2, COURSE_DURATION_2);
    private static Course course_3 = new Course(COURSE_NAME_3, COURSE_DURATION_3);
    private static Course course_4 = new Course(COURSE_NAME_4, COURSE_DURATION_4);
    private static Course course_5 = new Course(COURSE_NAME_5, COURSE_DURATION_5);
    private static Course course_6 = new Course(COURSE_NAME_6, COURSE_DURATION_6);
    private static Course course_7 = new Course(COURSE_NAME_7, COURSE_DURATION_7);
    private static Course course_8 = new Course(COURSE_NAME_8, COURSE_DURATION_8);
    private static Course course_9 = new Course(COURSE_NAME_9, COURSE_DURATION_9);

    //------------Объявление учебной программы------------------
    private static final String CURRICULUM_NAME_1 = "J2EE Developer";
    private static final String CURRICULUM_NAME_2 = "Java Developer";

    //------------Объявление студентов------------------
    private static final String STUDENT_NAME_1 = "Ivanov Ivan";
    private static final LocalDate START_DATE_1 = LocalDate.of(2019, 9, 25);

    private static final String STUDENT_NAME_2 = "Petrov Petr";
    private static final LocalDate START_DATE_2 = LocalDate.of(2019, 9, 23);

    private static Student student1;
    private static Student student2;

    private static List<Curriculum> curriculumList;

    public static String getCurriculumName(int id) {
        String result = "";
        for (Curriculum curriculum : curriculumList) {
            if (curriculum.getId() == id)
                result = curriculum.getNameCurriculum();
        }
        return result;
    }

    public static int getCurriculumTotalTime(int id) {
        int time = 0;
        for (Curriculum curriculum : curriculumList) {
            if (curriculum.getId() == id)
                time = curriculum.getTimeCurriculum();
        }
        return time;
    }

    static void generate() {
        Set<Course> listCoursesCur_1 = new LinkedHashSet<>();
        listCoursesCur_1.add(course_1);
        listCoursesCur_1.add(course_2);
        listCoursesCur_1.add(course_3);
        listCoursesCur_1.add(course_4);

        Set<Course> listCoursesCur_2 = new LinkedHashSet<>();
        listCoursesCur_2.add(course_5);
        listCoursesCur_2.add(course_6);
        listCoursesCur_2.add(course_7);
        listCoursesCur_2.add(course_8);
        listCoursesCur_2.add(course_9);

        Curriculum curriculum1 = new Curriculum(CURRICULUM_NAME_1, listCoursesCur_1);
        Curriculum curriculum2 = new Curriculum(CURRICULUM_NAME_2, listCoursesCur_2);

        curriculumList = new ArrayList<>();
        curriculumList.add(curriculum1);
        curriculumList.add(curriculum2);

        student1 = new Student(STUDENT_NAME_1, 1, START_DATE_1);
        student1.addMark(3);
        student1.addMark(4);
        student1.addMark(2);
        student1.addMark(5);
        student1.addMark(3);
        student1.addMark(3);

        student2 = new Student(STUDENT_NAME_2, 2, START_DATE_2);
        student2.addMark(4);
        student2.addMark(5);
        student2.addMark(3);
        student2.addMark(2);
        student2.addMark(3);
        student2.addMark(3);
        student2.addMark(5);
        student2.addMark(5);
    }

    static void listStudentsSortedByAverageMarks() {
        Set<Student> students = new TreeSet<>(new SortedByAverageMark());
        students.add(student1);
        students.add(student2);
        for (Student student : students) {
            System.out.println(student.getAllStudentInfo());
        }
    }

    static void listStudentsSortedByTimeLeft() {
        Set<Student> students = new TreeSet<>(new SortedByTimeLeft());
        students.add(student1);
        students.add(student2);
        for (Student student : students) {
            System.out.println(student.getAllStudentInfo());
        }
    }

    static void listStatusStudents() {
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        for (Student student : students) {
            System.out.print(student.getNameStudent() +
                    " - До окончания обучения по программе " + getCurriculumName(student.getIdStudent()) +
                    " осталось " + student.getHoursLate() + " ч." +
                    " Средний балл " + String.format("%.2f", student.getAverageMark()) + ". ");
            boolean averageMarkBad = student.getAverageMark() < 4.5;
            boolean hoursLateLittle = student.getHoursLate() < 24;
            if (averageMarkBad & hoursLateLittle) {
                System.out.print("Отчислить");
            } else {
                System.out.println("Оставить");
            }
        }
    }

}