package com.cauandev.taskmanager.infrastructure.repository;

import com.cauandev.taskmanager.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskRepositoryTest extends TaskRepositoryTest {
    @Override
    protected TaskRepository createRepository() {
        return new InMemoryTaskRepository();
    }
}