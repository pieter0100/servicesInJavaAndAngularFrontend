package com.architekturyusluginternetowych.lab3.Controller.Scientist.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateScientistRequest {
    private String firstName;
    private String lastName;
    private String degree;
    private int age;
    private String departmentName;
}
