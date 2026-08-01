package com.cauandev.taskmanager.infrastructure.repository;

import com.cauandev.taskmanager.domain.Task;
import com.cauandev.taskmanager.domain.TaskRepository;
import com.cauandev.taskmanager.domain.TaskId;

import java.util.*;

public class InMemoryTaskRepository implements TaskRepository {
    private final Map<TaskId, Task> storage = new HashMap<>();
    @Override
    public Task save(Task task) {
        storage.put(task.getId(), task);
        return task;
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(TaskId id) {
        storage.remove(id);
    }

    @Override
    public Optional<Task> findById(com.cauandev.taskmanager.domain.TaskId id) {
        return Optional.ofNullable(storage.get(id));
    }
}
