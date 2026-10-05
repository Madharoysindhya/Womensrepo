package com.campus.safety.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "escort_requests")
public class EscortRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Student name is required")
    private String studentName;

    @NotBlank(message = "Student ID is required")
    private String studentId;

    @NotBlank(message = "Pickup/current location is required")
    private String pickupLocation;

    @NotBlank(message = "Destination is required")
    private String destination;

    @NotNull(message = "Requested time is required")
    private LocalDateTime requestedTime;

    @Column(length = 500)
    private String notes;

    @Enumerated(EnumType.STRING)
    private RequestStatus status = RequestStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "assigned_escort_id")
    private Escort assignedEscort;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() { return id; }
    public String getStudentName() { return studentName; }
    public String getStudentId() { return studentId; }
    public String getPickupLocation() { return pickupLocation; }
    public String getDestination() { return destination; }
    public LocalDateTime getRequestedTime() { return requestedTime; }
    public String getNotes() { return notes; }
    public RequestStatus getStatus() { return status; }
    public Escort getAssignedEscort() { return assignedEscort; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setStatus(RequestStatus status) { this.status = status; }
    public void setAssignedEscort(Escort assignedEscort) { this.assignedEscort = assignedEscort; }
}
