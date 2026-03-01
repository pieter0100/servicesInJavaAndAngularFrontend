package com.architekturyusluginternetowych.lab3.Service;

import com.architekturyusluginternetowych.lab3.Entity.DepartmentEntity;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {
    List<DepartmentEntity> findDepartmentByName(String departmentName);

    List<DepartmentEntity> findAllDepartments();

    DepartmentEntity findDepartmentById(UUID id);

    void saveDepartment(DepartmentEntity entity);

    void deleteDepartment(UUID id);
}
