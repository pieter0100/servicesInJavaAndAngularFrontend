package com.architekturyusluginternetowych.lab3.Controller.Scientist;

import com.architekturyusluginternetowych.lab3.Controller.Department.DTO.CreateDepartmentRequest;
import com.architekturyusluginternetowych.lab3.Controller.Scientist.DTO.CreateScientistRequest;
import com.architekturyusluginternetowych.lab3.Controller.Scientist.DTO.ScientistResponse;
import com.architekturyusluginternetowych.lab3.Controller.Scientist.DTO.ScientistsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ScientistController {
    @GetMapping("/scientists")
    public ScientistsResponse getScientists();

    @GetMapping("/scientists/{id}")
    public ResponseEntity<ScientistResponse> getScientist(@PathVariable UUID id);

    @PostMapping("/scientists")
    public void createScientist(@RequestBody CreateScientistRequest scientist);

    @DeleteMapping("/scientists/{id}")
    public ResponseEntity<Void> deleteScientist(@PathVariable UUID id);

    @GetMapping("scientists/dep/{id}")
    public ScientistsResponse getDepartmentScientists(@PathVariable UUID id);

    @PutMapping("scientists/{id}")
    public void updateScientist(@PathVariable UUID id, @RequestBody CreateScientistRequest scientist);
}
