package com.architekturyusluginternetowych.lab3.Controller.Scientist.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Builder
public class ScientistResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private String degree;
    private String departmentName;
}
