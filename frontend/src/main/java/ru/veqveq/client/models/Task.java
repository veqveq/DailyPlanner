package ru.veqveq.client.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fld")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "owner_id_fld")
    private User user;
    @ManyToOne
    @JoinColumn(name = "task_list_id_fld")
    private TaskList taskList;
    @Column(name = "priority_fld")
    private Priority priority;
    @Column(name = "status_fld")
    private Status status;
    @Column(name = "deadline_fld")
    private LocalDateTime deadline;
    @Column(name = "text_fld")
    private String text;
    @CreationTimestamp
    @Column(name = "created_at_fld")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at_fld")
    private LocalDateTime updatedAt;
}
