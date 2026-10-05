package com.campus.safety.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "escorts")
public class Escort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String employeeId;

    @Column(nullable = false)
    private String phone;

    private boolean available;

    public Escort() {}
    public Escort(Long id, String name, String employeeId, String phone, boolean available) {
        this.id = id; this.name = name; this.employeeId = employeeId;
        this.phone = phone; this.available = available;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmployeeId() { return employeeId; }
    public String getPhone() { return phone; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
