package com.cauandev.taskmanager.application;

import com.cauandev.taskmanager.application.input.UpdateTaskInput;
import com.cauandev.taskmanager.application.output.TaskOutPut;
import com.cauandev.taskmanager.domain.TaskId;
import com.cauandev.taskmanager.domain.TaskNotFoundException;
import com.cauandev.taskmanager.domain.TaskRepository;

public class UpdateTaskUseCase {
    private final TaskRepository repository;

    public UpdateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutPut execute(TaskId id, UpdateTaskInput input) {
        var task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        task.update(input.title(), input.description(), input.status());
        var updated = repository.save(task);
        return TaskOutPut.from(updated);
    }
}
