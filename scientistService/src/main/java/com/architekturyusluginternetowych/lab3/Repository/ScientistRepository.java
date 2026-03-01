package com.architekturyusluginternetowych.lab3.Repository;

import com.architekturyusluginternetowych.lab3.Entity.DepartmentEntity;
import com.architekturyusluginternetowych.lab3.Entity.ScientistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ScientistRepository extends JpaRepository<ScientistEntity, UUID> {
    List<ScientistEntity> findAll();

    List<ScientistEntity> findScientistByName(String name);

    List<ScientistEntity> findByDepartmentName(DepartmentEntity departmentName);

    List<ScientistEntity> findByNameAndDepartmentName(String name, DepartmentEntity departmentName);

    ScientistEntity findByUuid(UUID uuid);

    List<ScientistEntity> findScientistEntityByDepartmentName(DepartmentEntity departmentName);
}
