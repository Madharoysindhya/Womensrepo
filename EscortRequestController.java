package com.campus.safety.controller;

import com.campus.safety.entity.*;
import com.campus.safety.repository.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin(origins = "http://localhost:5173")
public class EscortRequestController {
    private final EscortRequestRepository requestRepo;
    private final EscortRepository escortRepo;

    public EscortRequestController(EscortRequestRepository requestRepo, EscortRepository escortRepo) {
        this.requestRepo = requestRepo;
        this.escortRepo = escortRepo;
    }

    @GetMapping
    public List<EscortRequest> all() { return requestRepo.findAll(); }

    @GetMapping("/{id}")
    public EscortRequest one(@PathVariable Long id) {
        return requestRepo.findById(id).orElseThrow(() -> new RuntimeException("Request not found"));
    }

    @GetMapping("/search")
    public List<EscortRequest> search(@RequestParam String keyword) {
        return requestRepo.search(keyword);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EscortRequest create(@Valid @RequestBody EscortRequest request) {
        request.setStatus(RequestStatus.PENDING);
        return requestRepo.save(request);
    }

    @PutMapping("/{id}/assign/{escortId}")
    public EscortRequest assign(@PathVariable Long id, @PathVariable Long escortId) {
        EscortRequest request = one(id);
        Escort escort = escortRepo.findById(escortId)
                .orElseThrow(() -> new RuntimeException("Escort not found"));
        if (!escort.isAvailable()) throw new RuntimeException("Escort is not available");
        request.setAssignedEscort(escort);
        request.setStatus(RequestStatus.ASSIGNED);
        escort.setAvailable(false);
        escortRepo.save(escort);
        return requestRepo.save(request);
    }

    @PutMapping("/{id}/status")
    public EscortRequest status(@PathVariable Long id, @RequestParam RequestStatus value) {
        EscortRequest request = one(id);
        request.setStatus(value);
        if (value == RequestStatus.COMPLETED || value == RequestStatus.CANCELLED) {
            if (request.getAssignedEscort() != null) {
                Escort escort = request.getAssignedEscort();
                escort.setAvailable(true);
                escortRepo.save(escort);
            }
        }
        return requestRepo.save(request);
    }
}
