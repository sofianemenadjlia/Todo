package todo.list;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Task {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_todo"
    )
    @SequenceGenerator(
            name = "seq_todo",
            sequenceName = "seq_todo",
            allocationSize = 1
    )
    private Integer id;
    private String task;
    private String description;
    private Integer done;

    public Task() {
    }

    public Task(Integer id, String task, String description, Integer done) {
        this.id = id;
        this.task = task;
        this.description = description;
        this.done = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task1 = (Task) o;
        return Objects.equals(id, task1.id) && Objects.equals(task, task1.task) && Objects.equals(description, task1.description) && Objects.equals(done, task1.done);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, task, description, done);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(Integer done) {
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDone() {
        return done;
    }
}
