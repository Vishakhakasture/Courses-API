package com.example.course_api.controller;


import com.example.course_api.entity.Course;
import com.example.course_api.entity.Instance;
import com.example.course_api.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
