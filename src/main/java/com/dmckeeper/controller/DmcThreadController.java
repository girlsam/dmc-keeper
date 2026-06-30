package com.dmckeeper.controller;

import com.dmckeeper.model.DmcThread;
import com.dmckeeper.repository.DmcThreadRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/threads")
public class DmcThreadController {

    private final DmcThreadRepository repository;

    public DmcThreadController(DmcThreadRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<DmcThread> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DmcThread> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // TODO: Replace with DTO
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DmcThread create(@RequestBody DmcThread thread) {
        return repository.save(thread);
    }
}
