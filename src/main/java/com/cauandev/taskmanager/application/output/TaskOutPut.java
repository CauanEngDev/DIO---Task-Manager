package com.cauandev.taskmanager.application.output;

import com.cauandev.taskmanager.domain.Task;

import java.util.Optional;

public record TaskOutPut(String id, String title, Optional<String> description, String status) {
    public static TaskOutPut from(Task task) {
        return new TaskOutPut(
                task.getId().toString(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus().name()
        );
    }
}
