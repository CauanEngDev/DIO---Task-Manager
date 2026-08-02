package com.cauandev.taskmanager.application;

import com.cauandev.taskmanager.application.input.CreateTaskInput;
import com.cauandev.taskmanager.application.output.TaskOutPut;
import com.cauandev.taskmanager.domain.Task;
import com.cauandev.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskUseCase {
    private final TaskRepository repository;

    public CreateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutPut execute(CreateTaskInput input) {
        var task = new Task(input.title(), input.description());
        var saved = repository.save(task);
        return TaskOutPut.from(saved);
    }
}
