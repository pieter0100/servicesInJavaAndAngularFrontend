package com.architekturyusluginternetowych.lab3.Repository;

import com.architekturyusluginternetowych.lab3.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, UUID> {
    List<DepartmentEntity> findDepartmentByDepartmentName(String departmentName);

    DepartmentEntity findDepartmentEntityByUuid(UUID uuid);
}
