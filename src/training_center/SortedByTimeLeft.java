package training_center;

import training_center.entities.Student;

import java.util.Comparator;

public class SortedByTimeLeft implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int result = o1.getHourseLate() - o2.getHourseLate();
        return Integer.compare(result, 0);
    }
}
