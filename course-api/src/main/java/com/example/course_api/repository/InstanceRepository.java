package com.example.course_api.repository;

import com.example.course_api.entity.Instance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstanceRepository extends JpaRepository<Instance, Integer> {
}
