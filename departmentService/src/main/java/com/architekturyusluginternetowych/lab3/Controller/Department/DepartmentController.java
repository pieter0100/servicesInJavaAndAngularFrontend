package com.architekturyusluginternetowych.lab3.Controller.Department;

import com.architekturyusluginternetowych.lab3.Controller.Department.DTO.CreateDepartmentRequest;
import com.architekturyusluginternetowych.lab3.Controller.Department.DTO.DepartmentResponse;
import com.architekturyusluginternetowych.lab3.Controller.Department.DTO.DepartmentsResponse;
import com.architekturyusluginternetowych.lab3.Entity.DepartmentEntity;
import com.architekturyusluginternetowych.lab3.Service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface DepartmentController {
    @GetMapping("/departments")
    public DepartmentsResponse getDepartments();

    @GetMapping("/departments/{id}")
    public ResponseEntity<DepartmentResponse> getDepartment(@PathVariable UUID id);

    @PostMapping("/departments")
    public void createDepartment(@RequestBody CreateDepartmentRequest department);

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable UUID id);

    @PutMapping("/departments/{id}")
    public void updateDepartment(@PathVariable UUID id, @RequestBody CreateDepartmentRequest department);
}
