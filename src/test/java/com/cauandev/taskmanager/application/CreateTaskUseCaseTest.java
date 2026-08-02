package com.cauandev.taskmanager.application;

import com.cauandev.taskmanager.application.input.CreateTaskInput;
import com.cauandev.taskmanager.application.output.TaskOutPut;
import com.cauandev.taskmanager.domain.Task;
import com.cauandev.taskmanager.domain.TaskRepository;
import com.cauandev.taskmanager.infrastructure.repository.InMemoryTaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CreateTaskUseCaseTest {
    @Mock
    TaskRepository repository;

    @InjectMocks
    CreateTaskUseCase useCase;

    @Test
    void should_create_task_successfully() {
        // given
        var input = new CreateTaskInput("Estudar Java", Optional.of("Finalizar o módulo de records"));

        when(repository.save(any(Task.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // when
        TaskOutPut output = useCase.execute(input);

        // then
        assertNotNull(output);
        assertNotNull(output.id());
        assertEquals("Estudar Java", output.title());
        assertEquals(Optional.of("Finalizar o módulo de records"), output.description());

        verify(repository, times(1)).save(any(Task.class));
    }
}