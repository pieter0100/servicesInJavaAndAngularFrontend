package com.architekturyusluginternetowych.lab3.Controller.Department.DTO;

import com.architekturyusluginternetowych.lab3.Entity.DepartmentEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class DepartmentsResponse {
    private List<DepartmentResponse> departments;
}
