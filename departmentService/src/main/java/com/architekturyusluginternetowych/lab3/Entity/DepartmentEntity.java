package com.architekturyusluginternetowych.lab3.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "departments")
public class DepartmentEntity implements Serializable {
    @Id
    private UUID uuid;

    @Column(unique = true, name = "department_name")
    private String departmentName;

    @Column(unique = true, name = "department_building_number")
    private int departmentBuildingNumber;

//    @ToString.Exclude
//    @Builder.Default
//    @OneToMany(mappedBy = "departmentName", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<ScientistEntity> departmentScientists = new ArrayList<>();

}
