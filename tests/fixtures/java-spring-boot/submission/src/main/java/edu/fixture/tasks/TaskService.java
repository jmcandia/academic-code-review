package edu.fixture.tasks;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {
    private final Map<Long, Task> tasks = new ConcurrentHashMap<>();
    private final AtomicLong ids = new AtomicLong();
    public Task create(String title) {
        Task task = new Task(ids.incrementAndGet(), title);
        tasks.put(task.id(), task);
        return task;
    }
    public Optional<Task> find(long id) { return Optional.ofNullable(tasks.get(id)); }
}
