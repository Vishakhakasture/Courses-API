package repository;

import model.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
    List<CourseInstance> findByYearAndSemester(int year, String semester);
    Optional<CourseInstance> findByYearAndSemesterAndCourseId(int year, String semester, Long courseId);
    void deleteByYearAndSemesterAndCourseId(int year, String semester, Long courseId);
}

