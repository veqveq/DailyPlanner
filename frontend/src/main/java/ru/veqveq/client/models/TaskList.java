package ru.veqveq.client.models;

import javax.persistence.*;

@Entity
@Table(name = "task_lists_tbl")
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fld")
    private Long id;
}
