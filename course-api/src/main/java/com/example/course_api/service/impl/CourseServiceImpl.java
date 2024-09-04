package com.example.course_api.service.impl;
import java.util.stream.Collectors;


import com.example.course_api.entity.Course;
import com.example.course_api.repository.CourseRepository;
import com.example.course_api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public List<Course> getCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourse(Integer id) {
        Course course = courseRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invaid course id "+id));

        return course;
    }

    @Override
    public void updateCourse(Integer id, Course course) {
        //check the course is in database or not
        courseRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid course id " +id));
        //course.setId(id);
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Integer id) {
        // check whether the course is present in database or not
        Course course = courseRepository
                        .findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid course id " +id));

    }

    @Override
    public List<String> getAllCourseTitles() {
        return courseRepository.findAll()
                .stream()
                .map(Course::getTitle)
                .collect(Collectors.toList());
    }


}
