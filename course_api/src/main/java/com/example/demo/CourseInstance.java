package com.example.demo;

public class CourseInstance {

	private String id;
    private String title;
    private String courseId;
    private String year;
    private String semester;

    
    public CourseInstance() {
    }

    public CourseInstance(String courseId, String year, String semester) {
        this.courseId = courseId;
        this.year = year;
        this.semester = semester;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

   
    public void setTitle(String title) {
        this.title = title;
    }

    
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

 
}

