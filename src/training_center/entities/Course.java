package training_center.entities;

import java.util.Objects;

public class Course {
    private static int idCourseTotal;
    private int idCourse;
    private String nameCourse;
    private int durationCourse;

    static {
        idCourseTotal = 0;
    }

    private static void setIdCourseTotal(){
        ++Course.idCourseTotal;
    }

    public Course(String nameCourse, int durationCourse) {
        setIdCourseTotal();
        idCourse = idCourseTotal;
        this.nameCourse = nameCourse;
        this.durationCourse = durationCourse;
    }

    public int getId() {
        return idCourse;
    }


    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    int getDurationCourse() {
        return durationCourse;
    }

    public void setDurationCourse(int durationCourse) {
        this.durationCourse = durationCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return idCourse == course.idCourse &&
                durationCourse == course.durationCourse &&
                Objects.equals(nameCourse, course.nameCourse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCourse, nameCourse, durationCourse);
    }

    @Override
    public String toString() {
        return "Course{" +
                " id=" + idCourse +
                ", name='" + nameCourse + '\'' +
                ", duration=" + durationCourse +
                '}';
    }
}
