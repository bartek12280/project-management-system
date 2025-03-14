package com.projectmanagement.spring.infrastructure.output.persistence.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "Tasks")
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private PriorityEnum priorityEnum;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @Nullable
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    @ManyToMany(mappedBy = "tasks", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<UserEntity> users;
}

