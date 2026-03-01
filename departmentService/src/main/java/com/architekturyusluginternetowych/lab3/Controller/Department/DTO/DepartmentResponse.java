package com.architekturyusluginternetowych.lab3.Controller.Department.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class DepartmentResponse {
    private UUID id;
    private String departmentName;
    private int departmentBuildingNumber;
}
