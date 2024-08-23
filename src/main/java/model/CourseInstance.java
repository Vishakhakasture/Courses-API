package model;

public class CourseInstance {

    private Long id;          
    private Long courseId;    
    private int year;         
    private String semester;  

    
    public CourseInstance() {
    }

    public CourseInstance(Long courseId, int year, String semester) {
        this.courseId = courseId;
        this.year = year;
        this.semester = semester;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "CourseInstance{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", year=" + year +
                ", semester='" + semester + '\'' +
                '}';
    }
}
