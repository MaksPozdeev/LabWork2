package training_center;

import training_center.entities.Student;

import java.util.Comparator;

public class SortedByAverageMark implements Comparator <Student> {

    @Override
    public int compare(Student o1, Student o2) {
        double result = o1.getAverageMark() - o2.getAverageMark();
        System.out.println(result);
        if (result > 0) return 1;
        if (result < 0) return -1;
        return 0;
    }
}
