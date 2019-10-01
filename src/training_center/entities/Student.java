package training_center.entities;

import training_center.CreateData;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Student  {
    private static int countStudents;
    private int idStudent;
    private String name;
    private int selectedCurriculumId;
    private LocalDate startDate; //Дата получения задания
    private List<Integer> marks; //Список оценок
    private double averageMark;

    static {
        countStudents = 0;
    }

    {
        averageMark = 0.0;
    }

    private static void setIdStudent() {
        ++Student.countStudents;
    }

    public Student(String name, int selectedCurriculumId, LocalDate startDate) {
        setIdStudent();
        idStudent = countStudents;
        this.name = name;
        this.selectedCurriculumId = selectedCurriculumId;
        this.startDate = startDate;
        marks = new ArrayList<>();
    }

//    class TestClass {
//
//        static int testInt = 0 ;
//
//        public static setTestInt ( int a ) {
//            TestClass.testInt = a ;
//        }
//
//        public void setInt ( int a1 ) {
//            setTestInt ( a1 );
//        }
//    }

    public int getId() {
        return idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSelectedCurriculumId() {
        return selectedCurriculumId;
    }

    public void setSelectedCurriculumId(int selectedCurriculumId) {
        this.selectedCurriculumId = selectedCurriculumId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getHourseLate() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(getStartDate(), now);
        int daysPassed = period.getDays();
        int hours = daysPassed*8;
        int programHours = CreateData.getCurriculumTotalTime(getSelectedCurriculumId());
        return programHours - hours;
    }

    public void getMarks() {
        if (marks == null) {
            System.out.println("Оценок ещё нет, либо их просто не за что ставить )");
        }
        else {
            System.out.println(marks.toString());
        }
    }

    public void addMark(int mark){
        if (marks == null) {
            System.out.println("Not exist: " + getClass());
            return;
        }
        if (mark <=5 && mark >=1) {
            marks.add(mark);
            averageMark = (double) getSumMarks()/(double) marks.size();
        } else {
            System.out.println("Оценка не входит в диапазон от 1 до 5");
        }
    }

    private int getSumMarks(){
        if (marks == null) {
            System.out.println("Not exist" + getClass());
            return -1;
        }
        int sumMark = 0;
        for (Integer mark : marks) {
            sumMark += mark;
        }
        return sumMark;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void getAll(){
        System.out.println("Students id: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("SelectedCurriculumId: " + CreateData.getCurriculumName(getId()));
        System.out.println("StartDate: " + getStartDate());
        System.out.println("Marks: " + marks);
        System.out.println("AverageMark: " + getAverageMark());
        System.out.println("Time left: " + getHourseLate());

        System.out.println();
    }

    @Override
    public String toString() {
        return"Student{" +
                "name='" + name + '\'' +
                ", selectedCurriculumId=" + selectedCurriculumId +
                ", startDate=" + startDate +
                ", marks=" + marks +
                ", averageMark=" + String.format("%.2f", averageMark) +
                '}';
    }

}
