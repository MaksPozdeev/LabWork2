package training_center.entities;

import java.util.Set;

public class Curriculum {
    private static int idCurriculumTotal;
    private int idCurriculum;
    private String nameCurriculum;
    private Set<Course> listCourses;
    private int timeCurriculum;

    static {
        idCurriculumTotal = 0;
    }

    private static void setIdCurriculumTotal() {
        ++Curriculum.idCurriculumTotal;
    }

    public Curriculum(String nameCurriculum, Set<Course> listCourses) {
        setIdCurriculumTotal();
        idCurriculum = idCurriculumTotal;
        this.nameCurriculum = nameCurriculum;
        int timeCourses = 0;
        if (listCourses != null) {
            this.listCourses = listCourses;
            for (Course course : listCourses) {
                timeCourses += course.getDurationCourse();
            }
        }
        timeCurriculum = timeCourses;
    }

    public int getId() {
        return idCurriculum;
    }

    public String getNameCurriculum() {
        return nameCurriculum;
    }

    public int getTimeCurriculum() {
        return timeCurriculum;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "id=" + idCurriculum +
                ", name='" + nameCurriculum + '\'' +
                ", listCourses=" + listCourses +
                '}';
    }

}