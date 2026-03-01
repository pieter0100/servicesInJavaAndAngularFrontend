package com.architekturyusluginternetowych.lab3.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = {"name", "surname"})
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@Entity
@Table(name = "scientists")
public class ScientistEntity implements Serializable {
    @Id
    private UUID uuid;

    @Column()
    private String name;

    @Column()
    private String surname;

    @Column()
    private int age;

    @Column()
    private String degree;

    @ManyToOne
    @JoinColumn(name = "department_name")
    private DepartmentEntity departmentName;
}
