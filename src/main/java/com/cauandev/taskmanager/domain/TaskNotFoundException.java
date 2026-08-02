package com.cauandev.taskmanager.domain;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(TaskId id) {
        super("Task com id " + id + " não encontrada!");
    }
}
