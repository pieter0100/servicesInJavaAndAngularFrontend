package com.architekturyusluginternetowych.lab3.Controller.Department.DTO;

import com.architekturyusluginternetowych.lab3.Controller.Scientist.DTO.ScientistResponse;
import com.architekturyusluginternetowych.lab3.Controller.Scientist.DTO.ScientistsResponse;
import com.architekturyusluginternetowych.lab3.Entity.ScientistEntity;
import com.architekturyusluginternetowych.lab3.Repository.ScientistRepository;
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
    private List<ScientistResponse> scientists;
}
