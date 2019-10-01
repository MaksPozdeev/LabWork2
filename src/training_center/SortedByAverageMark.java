package training_center;

import training_center.entities.Student;

import java.io.Serializable;
import java.util.Comparator;

public class SortedByAverageMark implements Comparator<Student>, Serializable {

    @Override
    public int compare(Student student1, Student student2) {
        return Integer.compare(Double.compare(student1.getAverageMark(), student2.getAverageMark()), 0);
    }
}
