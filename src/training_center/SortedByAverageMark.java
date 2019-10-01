package training_center;

import training_center.entities.Student;

import java.io.Serializable;
import java.util.Comparator;

public class SortedByAverageMark implements Comparator <Student>, Serializable {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(Double.compare(o1.getAverageMark(), o2.getAverageMark()), 0);
    }
}
