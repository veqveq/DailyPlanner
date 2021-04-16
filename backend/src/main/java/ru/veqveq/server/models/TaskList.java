package ru.veqveq.server.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task_lists_tbl")
@Data
@NoArgsConstructor
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fld")
    private Long id;

    @Column(name = "title_fld")
    private String title;

    @OneToMany(mappedBy = "taskList", orphanRemoval = true)
    private List<Task> tasks;

    public TaskList(String title) {
        this.title = title;
    }
}
