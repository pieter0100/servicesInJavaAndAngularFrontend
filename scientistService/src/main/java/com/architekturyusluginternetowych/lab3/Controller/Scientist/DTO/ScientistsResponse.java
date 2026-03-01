package com.architekturyusluginternetowych.lab3.Controller.Scientist.DTO;

import com.architekturyusluginternetowych.lab3.Entity.ScientistEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class ScientistsResponse {
    private List<ScientistResponse> scientists;
}
