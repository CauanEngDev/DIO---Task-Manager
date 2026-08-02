package com.cauandev.taskmanager.application;

import com.cauandev.taskmanager.application.output.TaskOutPut;
import com.cauandev.taskmanager.domain.TaskId;
import com.cauandev.taskmanager.domain.TaskNotFoundException;
import com.cauandev.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class GetByIdTaskUseCase {
    private final TaskRepository repository;

    public GetByIdTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutPut exceute(TaskId id) {
        return repository.findById(id)
                .map(TaskOutPut::from)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }
}
