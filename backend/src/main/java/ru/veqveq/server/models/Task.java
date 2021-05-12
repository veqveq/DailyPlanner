package ru.veqveq.server.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tasks_tbl")
@NoArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fld")
    private Long id;

    @OneToOne
    @JoinColumn(name = "owner_id_fld")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "task_list_id_fld")
    private TaskList taskList;

    @Column(name = "priority_fld")
    private Priority priority;

    @Column(name = "status_fld")
    private Status status;

    @Column(name = "text_fld")
    private String text;

    @Column(name = "deadline_fld")
    private LocalDateTime deadline;

    @CreationTimestamp
    @Column(name = "created_at_fld")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at_fld")
    private LocalDateTime updatedAt;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(name = "delegated_tasks_tbl",
            joinColumns = @JoinColumn(name = "task_id_fld"),
            inverseJoinColumns = @JoinColumn(name = "executor_id_fld"))
    private List<User> executors = new ArrayList<>();

    @PrePersist
    public void init() {
        if (status == null) status = Status.EXPIRED;
        if (priority == null) priority = Priority.NOT_IMPORTANT_NOT_URGENT;
        if (executors.size() == 0) addExecutor(owner);
    }

    public Task addExecutor(User executor) {
        executors.add(executor);
        return this;
    }
}
