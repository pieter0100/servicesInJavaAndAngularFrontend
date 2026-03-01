package com.architekturyusluginternetowych.lab3.Service;

import com.architekturyusluginternetowych.lab3.Entity.DepartmentEntity;
import com.architekturyusluginternetowych.lab3.Entity.ScientistEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ScientistService {

    List<ScientistEntity> findAllScientist();

    ScientistEntity findScientistEntityById(UUID id);

    List<ScientistEntity> findScientistByDepartment(DepartmentEntity department);

    void saveScientist(ScientistEntity scientistEntity);

    void deleteScientist(UUID id);
}
