package com.example.course_api.service;

import com.example.course_api.entity.Instance;

import java.util.List;

public interface InstanceService {

    void addInstance(Instance instance);

    List<Instance> getInstance();

    Instance getInstance(Integer id);

    void updateInstance(Integer id, Instance instance);

    void deleteInstance(Integer id);

    Instance getInstanceByYearNID(Integer year, Integer id);
}
