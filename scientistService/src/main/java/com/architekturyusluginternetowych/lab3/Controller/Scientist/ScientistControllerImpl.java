package com.architekturyusluginternetowych.lab3.Controller.Scientist;

import com.architekturyusluginternetowych.lab3.Controller.Scientist.DTO.CreateScientistRequest;
import com.architekturyusluginternetowych.lab3.Controller.Scientist.DTO.ScientistResponse;
import com.architekturyusluginternetowych.lab3.Controller.Scientist.DTO.ScientistsResponse;
import com.architekturyusluginternetowych.lab3.Entity.DepartmentEntity;
import com.architekturyusluginternetowych.lab3.Entity.ScientistEntity;
import com.architekturyusluginternetowych.lab3.Service.DepartmentService;
import com.architekturyusluginternetowych.lab3.Service.ScientistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
public class ScientistControllerImpl implements ScientistController {
    private ScientistService scientistService;
    private DepartmentService departmentService;

    @Autowired
    public ScientistControllerImpl(ScientistService scientistService) {
        this.scientistService = scientistService;
    }

    @Autowired
    public DepartmentService departmentService(DepartmentService departmentService) {
        return this.departmentService = departmentService;
    }

    @Override
    public ScientistsResponse getScientists() {
        var sci = scientistService.findAllScientist();

        var resp = ScientistsResponse.builder()
                .scientists(sci.stream().map(scientistEntity -> ScientistResponse.builder()
                        .id(scientistEntity.getUuid())
                        .degree(scientistEntity.getDegree())
                        .age(scientistEntity.getAge())
                        .firstName(scientistEntity.getName())
                        .lastName(scientistEntity.getSurname())
                                .departmentName(scientistEntity.getDepartmentName().getDepartmentName())
                        .build())
                        .toList())
                .build();
        return resp;
    }

    @Override
    public ResponseEntity<ScientistResponse> getScientist(UUID id) {
        var sci = scientistService.findScientistEntityById(id);

        if (sci == null) {
            return ResponseEntity.notFound().build();
        }

        var sciDTO = ScientistResponse.builder()
                .id(sci.getUuid())
                .firstName(sci.getName())
                .age(sci.getAge())
                .lastName(sci.getSurname())
                .degree(sci.getDegree())
                .departmentName(sci.getDepartmentName().getDepartmentName())
                .build();

        return ResponseEntity.ok(sciDTO);
    }

    @Override
    public void createScientist(CreateScientistRequest scientist) {
        scientistService.saveScientist(ScientistEntity.builder()
                .uuid(UUID.randomUUID())
                .name(scientist.getFirstName())
                .surname(scientist.getLastName())
                .age(scientist.getAge())
                .degree(scientist.getDegree())
                .departmentName(departmentService.findDepartmentByName(scientist.getDepartmentName()).get(0))
                .build());
    }

    @Override
    public ResponseEntity<Void> deleteScientist(UUID id) {
        scientistService.deleteScientist(id);

        return ResponseEntity.noContent().build();
    }

    @Override
    public ScientistsResponse getDepartmentScientists(UUID id) {
        var department = departmentService.findDepartmentById(id);

        return ScientistsResponse.builder()
                .scientists(department.getDepartmentScientists().stream().map( scientistEntity -> {
                     return ScientistResponse.builder()
                            .age(scientistEntity.getAge())
                            .departmentName(scientistEntity.getDepartmentName().getDepartmentName())
                            .lastName(scientistEntity.getSurname())
                            .firstName(scientistEntity.getName())
                            .id(scientistEntity.getUuid())
                            .degree(scientistEntity.getDegree())
                            .build();
                }).toList())
                .build();
    }

    @Override
    public void updateScientist(UUID id, CreateScientistRequest scientist) {
        var sci = scientistService.findScientistEntityById(id);

        if (scientist.getFirstName() != null) {
            if (!scientist.getFirstName().equals(sci.getName())) sci.setName(scientist.getFirstName());
        }

        if (scientist.getLastName() != null) {
            if (!scientist.getLastName().equals(sci.getSurname())) sci.setSurname(scientist.getLastName());
        }

        if (scientist.getAge() > 0) {
            sci.setAge(scientist.getAge());
        }

        if (scientist.getDegree() != null) {
            sci.setDegree(scientist.getDegree());
        }

        scientistService.saveScientist(sci);
    }
}
