package controller;

import model.CourseInstance;
import repository.CourseInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @PostMapping
    public CourseInstance createCourseInstance(@RequestBody CourseInstance courseInstance) {
        return courseInstanceRepository.save(courseInstance);
    }

    @GetMapping("/{year}/{semester}")
    public List<CourseInstance> getCoursesByYearAndSemester(@PathVariable int year, @PathVariable String semester) {
        return courseInstanceRepository.findByYearAndSemester(year, semester);
    }

    @GetMapping("/{year}/{semester}/{id}")
    public ResponseEntity<CourseInstance> getCourseInstanceByYearSemesterAndId(@PathVariable int year, @PathVariable String semester, @PathVariable Long id) {
        return courseInstanceRepository.findByYearAndSemesterAndCourseId(year, semester, id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{year}/{semester}/{id}")
    public ResponseEntity<Void> deleteCourseInstanceByYearSemesterAndId(@PathVariable int year, @PathVariable String semester, @PathVariable Long id) {
        if (courseInstanceRepository.findByYearAndSemesterAndCourseId(year, semester, id).isPresent()) {
            courseInstanceRepository.deleteByYearAndSemesterAndCourseId(year, semester, id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

