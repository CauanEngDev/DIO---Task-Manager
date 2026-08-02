package com.cauandev.taskmanager.infrastructure.repository;

import com.cauandev.taskmanager.domain.*;

class InMemoryTaskRepositoryTest extends TaskRepositoryTest {
    @Override
    protected TaskRepository createRepository() {
        return new InMemoryTaskRepository();
    }
}