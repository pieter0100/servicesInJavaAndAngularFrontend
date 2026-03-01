package com.architekturyusluginternetowych.lab3;

import com.architekturyusluginternetowych.lab3.Entity.DepartmentEntity;
import com.architekturyusluginternetowych.lab3.Entity.ScientistEntity;
import com.architekturyusluginternetowych.lab3.Service.Impl.DepartmentServiceImpl;
import com.architekturyusluginternetowych.lab3.Service.Impl.ScientistServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class DataInitializer {
    private ScientistServiceImpl scientistService;
    private DepartmentServiceImpl departmentService;

    @Autowired
    public DataInitializer(ScientistServiceImpl scientistService, DepartmentServiceImpl departmentService) {
        this.scientistService = scientistService;
        this.departmentService = departmentService;
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("Inicjalizator danych uruchomiony scientist service");

        String[] imionaMeskie = {
                "Piotr", "Krzysztof", "Andrzej", "Tomasz", "Jan", "Paweł", "Marcin", "Michał", "Marek", "Grzegorz",
                "Jakub", "Adam", "Łukasz", "Kamil", "Stanisław"
        };
        String[] nazwiskaMeskie = {
                "Nowak", "Kowalski", "Wiśniewski", "Wójcik", "Kowalczyk", "Kamiński", "Lewandowski", "Zieliński", "Szymański", "Woźniak",
                "Dąbrowski", "Kozłowski", "Jankowski", "Mazur", "Kwiatkowski"
        };
        String[] imionaZenskie = {
                "Anna", "Katarzyna", "Maria", "Małgorzata", "Agnieszka", "Barbara", "Ewa", "Magdalena", "Elżbieta", "Krystyna",
                "Joanna", "Aleksandra", "Monika", "Zofia", "Natalia"
        };
        String[] nazwiskaZenskie = {
                "Nowak", "Kowalska", "Wiśniewska", "Wójcik", "Kowalczyk", "Kamińska", "Lewandowska", "Zielińska", "Szymańska", "Woźniak",
                "Dąbrowska", "Kozłowska", "Jankowska", "Mazur", "Kwiatkowska"
        };

        String[] stopnieNaukowe = {"Master", "Doctor", "Professor"};

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

        // generowanie scientists
        List<String> departments = List.of("weti", "wimio", "weia", "wa");
        List<Integer> buildingNumber = List.of(41, 30, 26, 14);
        Random r = new Random();
        for(int i=0;i<30;i++){
            int plec = r.nextInt(2);
            int departmentNameAndNumber = r.nextInt(departments.size());

            if(plec == 0) {
                ScientistEntity s = ScientistEntity.builder()
                        .uuid(UUID.randomUUID())
                        .name(imionaMeskie[r.nextInt(15)])
                        .surname(nazwiskaMeskie[r.nextInt(15)])
                        .age(r.nextInt(30, 75))
                        .degree(stopnieNaukowe[r.nextInt(3)])
                        .departmentName(DepartmentEntity.builder()
                                .uuid(UUID.nameUUIDFromBytes(departments.get(departmentNameAndNumber).getBytes()))
                                .departmentName(departments.get(departmentNameAndNumber))
                                .departmentBuildingNumber(departmentNameAndNumber)
                                .build())
                        .build();

                scientistService.saveScientist(s);
            }
            else {
                ScientistEntity s = ScientistEntity.builder()
                        .uuid(UUID.randomUUID())
                        .name(imionaZenskie[r.nextInt(15)])
                        .surname(nazwiskaZenskie[r.nextInt(15)])
                        .age(r.nextInt(30, 75))
                        .degree(stopnieNaukowe[r.nextInt(3)])
                        .departmentName(DepartmentEntity.builder()
                                .uuid(UUID.nameUUIDFromBytes(departments.get(departmentNameAndNumber).getBytes()))
                                .departmentName(departments.get(departmentNameAndNumber))
                                .departmentBuildingNumber(departmentNameAndNumber)
                                .build())
                        .build();

                scientistService.saveScientist(s);
            }
        }

        System.out.println("Inicjalizator danych zakonczony scientist service");
    }
}
