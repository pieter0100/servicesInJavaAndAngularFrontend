package com.architekturyusluginternetowych.lab3.Service.Impl;

import com.architekturyusluginternetowych.lab3.Entity.DepartmentEntity;
import com.architekturyusluginternetowych.lab3.Repository.DepartmentRepository;
import com.architekturyusluginternetowych.lab3.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentEntity> findDepartmentByName(String departmentName) {
        return departmentRepository.findDepartmentByDepartmentName(departmentName);
    }

    @Override
    public List<DepartmentEntity> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentEntity findDepartmentById(UUID id) {
        return departmentRepository.findDepartmentEntityByUuid(id);
    }

    @Override
    public void saveDepartment(DepartmentEntity entity) {
        departmentRepository.save(entity);
    }

    @Override
    public void deleteDepartment(UUID id) {
        departmentRepository.findById(id).ifPresent(departmentRepository::delete);
    }
}
