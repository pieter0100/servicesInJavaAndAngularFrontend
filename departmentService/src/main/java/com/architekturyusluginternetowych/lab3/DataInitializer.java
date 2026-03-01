package com.architekturyusluginternetowych.lab3;

import com.architekturyusluginternetowych.lab3.Entity.DepartmentEntity;
import com.architekturyusluginternetowych.lab3.Service.Impl.DepartmentServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class DataInitializer {
    private DepartmentServiceImpl departmentService;

    @Autowired
    public DataInitializer(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("Inicjalizator danych uruchomiony department service");

        DepartmentEntity weti = DepartmentEntity.builder()
                .uuid(UUID.nameUUIDFromBytes("weti".getBytes()))
                .departmentName("Wydzial Elektroniki Teleinformatyki i Informatyki")
                .departmentBuildingNumber(41)
                .build();

        DepartmentEntity wimio = DepartmentEntity.builder()
                .uuid(UUID.nameUUIDFromBytes("wimio".getBytes()))
                .departmentName("Wydzial Inżynierii Mechanicznej i Okrętownictwa")
                .departmentBuildingNumber(30)
                .build();

        DepartmentEntity weia = DepartmentEntity.builder()
                .uuid(UUID.nameUUIDFromBytes("weia".getBytes()))
                .departmentName("Wydzial Eletkroni i Automatyki")
                .departmentBuildingNumber(26)
                .build();

        DepartmentEntity wa = DepartmentEntity.builder()
                .uuid(UUID.nameUUIDFromBytes("wa".getBytes()))
                .departmentName("Wydzial Architektury")
                .departmentBuildingNumber(14)
                .build();
        DepartmentEntity[] departmentsTable = {weti, wimio, weia, wa};

        Arrays.stream(departmentsTable).forEach(department -> departmentService.saveDepartment(department));

        System.out.println("Inicjalizator danych department service");
    }
}
