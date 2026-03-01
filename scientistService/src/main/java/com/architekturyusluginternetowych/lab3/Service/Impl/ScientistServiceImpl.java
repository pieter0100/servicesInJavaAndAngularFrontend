package com.architekturyusluginternetowych.lab3.Service.Impl;

import com.architekturyusluginternetowych.lab3.Entity.DepartmentEntity;
import com.architekturyusluginternetowych.lab3.Entity.ScientistEntity;
import com.architekturyusluginternetowych.lab3.Repository.ScientistRepository;
import com.architekturyusluginternetowych.lab3.Service.ScientistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScientistServiceImpl implements ScientistService {

    ScientistRepository scientistRepository;

    @Autowired
    public ScientistServiceImpl(ScientistRepository scientistRepository) {
        this.scientistRepository = scientistRepository;
    }

    @Override
    public List<ScientistEntity> findAllScientist() {
        return scientistRepository.findAll();
    }

    @Override
    public ScientistEntity findScientistEntityById(UUID id) {
        return scientistRepository.findByUuid(id);
    }


    @Override
    public List<ScientistEntity> findScientistByDepartment(DepartmentEntity department) {
        return scientistRepository.findScientistEntityByDepartmentName(department);
    }

    @Override
    public void saveScientist(ScientistEntity scientistEntity) {
        scientistRepository.save(scientistEntity);
    }

    @Override
    public void deleteScientist(UUID id) {
        scientistRepository.findById(id).ifPresent(scientistRepository::delete);
    }
}
