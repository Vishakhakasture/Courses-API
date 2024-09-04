package com.example.course_api.controller;


import com.example.course_api.entity.Course;
import com.example.course_api.entity.Instance;
import com.example.course_api.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/instance")
public class InstanceController {
    @Autowired
    private InstanceService instanceService;

    @PostMapping("/add")
    public String addInstance(@RequestBody Instance instance) {
        instanceService.addInstance(instance);
        return "success instance added";
    }

    @GetMapping()
    public List<Instance> getInstance(){
        return instanceService.getInstance();
    }

    @GetMapping("/get")
    public Instance getInstance(@RequestParam Integer id) {

        return instanceService.getInstance(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateInstance(@PathVariable Integer id, @RequestBody Instance instance) {
        instanceService.updateInstance(id, instance);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteInstance(@PathVariable Integer id) {
        instanceService.deleteInstance(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/years")
    public ResponseEntity<List<Integer>> getYears() {
        List<Integer> years = Arrays.asList(2024, 2023, 2022, 2021, 2020,2019,2018,1017,2016,2015,2014,2013,2012); // Example years
        return ResponseEntity.ok(years);
    }

    @GetMapping("/semesters")
    public ResponseEntity<List<Integer>> getSemesters() {
        List<Integer> semesters = Arrays.asList(1,2,3,4,5,6,7,8); // Example semesters
        return ResponseEntity.ok(semesters);
    }

    @GetMapping("/{year}/{id}")
    public Instance getInstanceByYearNID(@RequestParam Integer year, Integer id) {

        return instanceService.getInstanceByYearNID(year,id);
    }

}
