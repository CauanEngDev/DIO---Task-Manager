package com.cauandev.taskmanager.infrastructure.http.response;

import com.cauandev.taskmanager.application.output.TaskOutPut;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public record TaskResponse(String id, String title, String description, String status) {
    public static TaskResponse from(TaskOutPut output) {
        return new TaskResponse(output.id(),
                                output.title(),
                                output.description().orElse(null),
                                output.status());
    }
}
