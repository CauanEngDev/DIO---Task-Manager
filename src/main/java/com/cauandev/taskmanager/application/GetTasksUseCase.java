package com.cauandev.taskmanager.application;

import com.cauandev.taskmanager.application.output.TaskOutPut;
import com.cauandev.taskmanager.domain.Task;
import com.cauandev.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTasksUseCase {
    private final TaskRepository repository;

    public GetTasksUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public List<TaskOutPut> exceute() {
        return repository.findAll().stream()
                .map(TaskOutPut::from)
                .toList();
    }
}
