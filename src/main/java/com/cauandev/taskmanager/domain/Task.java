package com.cauandev.taskmanager.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;
import java.util.Optional;

@Getter
@Setter
public class Task {
    private TaskId id;
    private String title;
    private Optional<String> description;
    private TaskStatus status;

    public Task(String title, Optional<String> description) {
        Assert.notNull(title, "título não pode ser null!");

        this.id = new TaskId();
        this.status = TaskStatus.PENDING;
        this.title = title;
        this.description = description;
    }

    public void update(Optional<String> title, Optional<String> description, Optional<TaskStatus> status) {
        title.ifPresent(this::setTitle);
        description.ifPresent(d -> this.setDescription(Optional.of(d)));
        status.ifPresent(this::setStatus);
    }
}
