package com.campus.safety.controller;

import com.campus.safety.entity.Escort;
import com.campus.safety.repository.EscortRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/escorts")
@CrossOrigin(origins = "http://localhost:5173")
public class EscortController {
    private final EscortRepository repository;
    public EscortController(EscortRepository repository) { this.repository = repository; }

    @GetMapping("/available")
    public List<Escort> available() { return repository.findByAvailableTrue(); }

    @GetMapping
    public List<Escort> all() { return repository.findAll(); }
}
