package com.cauandev.taskmanager.application.input;

import com.cauandev.taskmanager.domain.TaskStatus;
import jdk.jshell.Snippet;

import java.util.Optional;

public record UpdateTaskInput(Optional<String> title,
                              Optional<String> description,
                              Optional<TaskStatus> status) {
}
