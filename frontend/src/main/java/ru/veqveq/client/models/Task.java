package ru.veqveq.client.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.veqveq.client.gui.nodes.TaskNode;

import javax.persistence.*;
import java.time.LocalDate;
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
    //    @ManyToOne
//    @JoinColumn(name = "owner_id_fld")
//    private User user;
//    @ManyToOne
//    @JoinColumn(name = "task_list_id_fld")
//    private TaskList taskList;
//    @Column(name = "priority_fld")
//    private Priority priority;
//    @Column(name = "status_fld")
//    private Status status;
    @Column(name = "deadline_fld")
    private LocalDate deadline;
    @Column(name = "title_fld")
    private String title;
    @Column(name = "text_fld")
    private String text;
    @Column(name = "quickly_fld")
    private Boolean quickly;
    @Column(name = "important_fld")
    private Boolean important;
    @CreationTimestamp
    @Column(name = "created_at_fld")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at_fld")
    private LocalDateTime updatedAt;

    public void update(TaskNode taskNode) {
        this.title = taskNode.getTitle();
        this.text = taskNode.getText();
        this.quickly = taskNode.isQuickly();
        this.important = taskNode.isImportant();
        this.deadline = taskNode.getDeadline();
    }
}
