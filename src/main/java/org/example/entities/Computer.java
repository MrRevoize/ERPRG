package org.example.entities;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Entity
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "RAM")
    private Integer RAM; // Gb

    @Column(name = "space")
    private Integer space; // Gb

    public Computer(UUID id, Integer RAM, Integer space) {
        this.id = id;
        this.RAM = RAM;
        this.space = space;
    }

    public Computer() {

    }

    public void setRAM(Integer RAM) {
        this.RAM = RAM;
    }

    public void setSpace(Integer space) {
        this.space = space;
    }

    public UUID getId() {
        return id;
    }

    public Integer getRAM() {
        return RAM;
    }

    public Integer getSpace() {
        return space;
    }
}
