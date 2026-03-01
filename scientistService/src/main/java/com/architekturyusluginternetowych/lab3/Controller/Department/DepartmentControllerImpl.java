package com.architekturyusluginternetowych.lab3.Controller.Department;

import com.architekturyusluginternetowych.lab3.Controller.Department.DTO.CreateDepartmentRequest;
import com.architekturyusluginternetowych.lab3.Controller.Department.DTO.DepartmentResponse;
import com.architekturyusluginternetowych.lab3.Controller.Department.DTO.DepartmentsResponse;
import com.architekturyusluginternetowych.lab3.Controller.Scientist.DTO.ScientistResponse;
import com.architekturyusluginternetowych.lab3.Entity.DepartmentEntity;
import com.architekturyusluginternetowych.lab3.Entity.ScientistEntity;
import com.architekturyusluginternetowych.lab3.Service.DepartmentService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Log
public class DepartmentControllerImpl implements DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentControllerImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public DepartmentsResponse getDepartments() {
        log.info("Get departments");

        List<DepartmentEntity> deps = departmentService.findAllDepartments();

        DepartmentsResponse res = DepartmentsResponse.builder()
                .departments(deps.stream().map(departmentEntity -> DepartmentResponse.builder()
                            .id(departmentEntity.getUuid())
                            .departmentName(departmentEntity.getDepartmentName())
                                .scientists(departmentEntity.getDepartmentScientists().stream().map(scientistEntity -> ScientistResponse.builder()
                                        .id(scientistEntity.getUuid())
                                        .age(scientistEntity.getAge())
                                        .firstName(scientistEntity.getName())
                                        .lastName(scientistEntity.getSurname())
                                        .degree(scientistEntity.getDegree())
                                        .departmentName(scientistEntity.getDepartmentName().getDepartmentName())
                                        .build()
                                ).toList())
                            .build())
                        .toList()
                )
                .build();
        return res;
    }

    @Override
    public ResponseEntity<DepartmentResponse> getDepartment(UUID id) {
        var dep = departmentService.findDepartmentById(id);

        if (dep == null) {
            return ResponseEntity.notFound().build();
        }

        DepartmentResponse dto = DepartmentResponse.builder()
                .id(dep.getUuid())
                .departmentName(dep.getDepartmentName())
                .departmentBuildingNumber(dep.getDepartmentBuildingNumber())
                .scientists(dep.getDepartmentScientists().stream().map(scientistEntity -> ScientistResponse.builder()
                            .id(scientistEntity.getUuid())
                            .age(scientistEntity.getAge())
                            .firstName(scientistEntity.getName())
                            .lastName(scientistEntity.getSurname())
                            .degree(scientistEntity.getDegree())
                            .departmentName(scientistEntity.getDepartmentName().getDepartmentName())
                            .build()
                    ).toList())
                .build();

        return ResponseEntity.ok(dto);
    }

    @Override
    public void createDepartment(CreateDepartmentRequest department) {
        var dep = DepartmentEntity.builder()
                .uuid(UUID.nameUUIDFromBytes(department.getDepartmentName().getBytes()))
                .departmentName(department.getDepartmentName())
                .departmentBuildingNumber(department.getDepartmentBuildingNumber())
                .build();

        departmentService.saveDepartment(dep);
    }

    @Override
    public ResponseEntity<Void> deleteDepartment(UUID id) {
        departmentService.deleteDepartment(id);

        return ResponseEntity.noContent().build();
    }

    @Override
    public void updateDepartment(UUID id, CreateDepartmentRequest dep) {
        var department = departmentService.findDepartmentById(id);


        if (dep.getDepartmentName() != null) {
            if (!dep.getDepartmentName().equals(department.getDepartmentName())) {
                department.setDepartmentName(dep.getDepartmentName());
            }
        }

        // Sprawdzamy Building Number
        if (dep.getDepartmentBuildingNumber() > 0) {
            if (dep.getDepartmentBuildingNumber() != department.getDepartmentBuildingNumber()) {
                department.setDepartmentBuildingNumber(dep.getDepartmentBuildingNumber());
            }
        }

        // 3. Zapisz
        departmentService.saveDepartment(department);
    }
}
