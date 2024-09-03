package com.example.course_api.controller;

import com.example.course_api.entity.Course;
import com.example.course_api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public String addCourse(@RequestBody Course course) {
        courseService.addCourse(course);

        return "success course added";
    }

    @GetMapping()
    public List<Course> getCourse(){
        return courseService.getCourse();
    }

    @GetMapping("/get")
    public Course getCourse(@RequestParam Integer id) {
        return courseService.getCourse(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable Integer id, @RequestBody Course course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

}
