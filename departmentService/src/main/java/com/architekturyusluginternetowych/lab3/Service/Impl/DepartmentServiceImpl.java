package com.architekturyusluginternetowych.lab3.Service.Impl;

import com.architekturyusluginternetowych.lab3.Entity.DepartmentEntity;
import com.architekturyusluginternetowych.lab3.Repository.DepartmentRepository;
import com.architekturyusluginternetowych.lab3.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private RestTemplate restTemplate;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, RestTemplate restTemplate) {
        this.departmentRepository = departmentRepository;
        this.restTemplate = restTemplate;
    }

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
        // zapsiz lokalnie
        departmentRepository.save(entity);

        // zapisz w serwisie scientis
        String url = "http://backend-scientist:8082/departments";

        try {
            // Wysyłamy ten sam obiekt request do drugiego serwisu
            restTemplate.postForObject(url, entity, Void.class);
        } catch (Exception e) {
            // W labach wystarczy printstacktrace, w produkcji logujemy błąd,
            // że spójność danych została naruszona
            System.err.println("Błąd komunikacji z scientist-service: " + e.getMessage());
        }
    }

    @Override
    public void deleteDepartment(UUID id) {
        departmentRepository.findById(id).ifPresent(departmentRepository::delete);

        // usun serwisie scientis
        String url = "http://localhost:8082/departments/"+id;

        try {
            restTemplate.delete(url);
        } catch (Exception e) {
            // W labach wystarczy printstacktrace, w produkcji logujemy błąd,
            // że spójność danych została naruszona
            System.err.println("Błąd komunikacji z scientist-service: " + e.getMessage());
        }
    }
}
