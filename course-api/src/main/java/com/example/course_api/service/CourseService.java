package com.example.course_api.service;

import com.example.course_api.entity.Course;

import java.util.List;

public interface CourseService {

    void addCourse(Course course);

    List<Course> getCourse();

    Course getCourse(Integer id);

    void updateCourse(Integer id, Course course);

    void deleteCourse(Integer id);

    List<String> getAllCourseTitles();
}
