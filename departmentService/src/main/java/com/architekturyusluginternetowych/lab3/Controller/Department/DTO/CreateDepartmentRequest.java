package com.architekturyusluginternetowych.lab3.Controller.Department.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateDepartmentRequest {
    private String departmentName;
    private int departmentBuildingNumber;
}
