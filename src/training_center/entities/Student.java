package training_center.entities;

import training_center.CreateData;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private static int countStudents;
    private int idStudent;
    private String nameStudent;
    private int selectedCurriculumId;
    private LocalDate curriculumStartDate;
    private List<Integer> listMarks;
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

    public Student(String nameStudent, int selectedCurriculumId, LocalDate curriculumStartDate) {
        setIdStudent();
        idStudent = countStudents;
        this.nameStudent = nameStudent;
        this.selectedCurriculumId = selectedCurriculumId;
        this.curriculumStartDate = curriculumStartDate;
        listMarks = new ArrayList<>();
    }

    public int getIdStudent() {
        return idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    private int getSelectedCurriculumId() {
        return selectedCurriculumId;
    }

    private LocalDate getCurriculumStartDate() {
        return curriculumStartDate;
    }

    public int getHoursLate() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(getCurriculumStartDate(), now);
        int daysPassed = period.getDays();
        int hours = daysPassed * 8;
        int programHours = CreateData.getCurriculumTotalTime(getSelectedCurriculumId());
        return programHours - hours;
    }

    public void addMark(int mark) {
        if (listMarks == null) {
            System.out.println("Not exist: " + getClass());
            return;
        }
        boolean markMaxValueOk = (mark <= 5);
        boolean markMinValueOk = (mark >= 1);
        if (markMaxValueOk && markMinValueOk) {
            listMarks.add(mark);
            averageMark = (double) getSumMarks() / (double) listMarks.size();
        } else {
            System.out.println("Оценка не входит в диапазон от 1 до 5");
        }
    }

    private int getSumMarks() {
        if (listMarks == null) {
            System.out.println("Not exist" + getClass());
            return -1;
        }
        int sumMark = 0;
        for (Integer mark : listMarks) {
            sumMark += mark;
        }
        return sumMark;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public String getAllStudentInfo() {
        return "Students id: " + getIdStudent() + "\n" +
                "Name: " + getNameStudent() + "\n" +
                "SelectedCurriculumId: " + CreateData.getCurriculumName(getIdStudent()) + "\n" +
                "StartDate: " + getCurriculumStartDate() + "\n" +
                "Marks: " + listMarks + "\n" +
                "AverageMark: " + String.format("%.2f", getAverageMark()) + "\n" +
                "Time left: " + getHoursLate() + "\n";

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + nameStudent + '\'' +
                ", selectedCurriculumId=" + selectedCurriculumId +
                ", startDate=" + curriculumStartDate +
                ", marks=" + listMarks +
                ", averageMark=" + String.format("%.2f", averageMark) +
                '}';
    }

}
