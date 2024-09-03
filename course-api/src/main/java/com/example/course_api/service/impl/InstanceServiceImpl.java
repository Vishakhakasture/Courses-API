package com.example.course_api.service.impl;

import com.example.course_api.entity.Instance;
import com.example.course_api.repository.InstanceRepository;
import com.example.course_api.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class InstanceServiceImpl implements InstanceService {

    @Autowired
    private InstanceRepository instanceRepository;
    @Override
    public void addInstance(Instance instance) {
        instanceRepository.save(instance);
    }

    @Override
    public List<Instance> getInstance() {
        return instanceRepository.findAll();
    }

    @Override
    public Instance getInstance(Integer id) {
        Instance instance = instanceRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invaid instance course id "+id));

        return instance;
    }

    @Override
    public void updateInstance(Integer id, Instance instance) {
        //check the course instance is in database or not
        instanceRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid course instance id " +id));
        //instance.setId(id);
        instanceRepository.save(instance);
    }

    @Override
    public void deleteInstance(Integer id) {
        Instance instance = instanceRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid course instance id " +id));
    }
}
