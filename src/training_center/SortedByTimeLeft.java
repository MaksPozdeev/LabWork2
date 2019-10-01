package training_center;

import training_center.entities.Student;

import java.io.Serializable;
import java.util.Comparator;

public class SortedByTimeLeft implements Comparator<Student>, Serializable {

    @Override
    public int compare(Student student1, Student student2) {
        int result = student1.getHoursLate() - student2.getHoursLate();
        return Integer.compare(result, 0);
    }
}
