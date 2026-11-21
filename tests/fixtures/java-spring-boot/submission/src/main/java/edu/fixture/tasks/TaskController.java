package edu.fixture.tasks;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;
    public TaskController(TaskService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody CreateTask request) {
        return ResponseEntity.status(201).body(service.create(request.title()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> get(@PathVariable long id) {
        return ResponseEntity.ok(service.find(id).orElse(null));
    }

    public record CreateTask(String title) {}
}
