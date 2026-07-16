package org.example.repository;

import org.example.entities.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, UUID> {
}
