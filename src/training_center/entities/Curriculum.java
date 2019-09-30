package training_center.entities;

import java.util.Set;

public class Curriculum {
    private static int idCurriculumTotal;
    private int idCurriculum;
    private String name;
    private Set<Course> listCourses;
    private int timeCurriculum;

    static {
        idCurriculumTotal =0;
    }

    public Curriculum(String name, Set<Course> listCourses) {
        idCurriculum = ++idCurriculumTotal;
        this.name = name;
        if (listCourses != null) {
            this.listCourses = listCourses;
        }
        int timeCourses = 0;
        for (Course course: listCourses){
            timeCourses += course.getDurationCourse();
        }
        timeCurriculum = timeCourses;
    }

    public int getId() {
        return idCurriculum;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getListCourses() {
        return listCourses;
    }

    public void setListCourses(Set<Course> listCourses) {
        this.listCourses = listCourses;
    }

    public void getAllInfo(){
        System.out.println("Curriculum ID: " + getId());
        System.out.println("Curriculum name: " + getName());
        for (Course course: listCourses){
            System.out.println(course.toString());
        }
        System.out.println("Total time: " + getTimeCurriculum());
    }

    public int getTimeCurriculum (){
        return timeCurriculum;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "id=" + idCurriculum +
                ", name='" + name + '\'' +
                ", listCourses=" + listCourses +
                '}';
    }


}
