package org.example.controller;

import org.example.entities.Computer;
import org.example.service.ComputerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/computers")
public class ComputerController {
    private final ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @PostMapping
    public ResponseEntity<Computer> save(@RequestBody Computer computer){
        return ResponseEntity.ok(
            computerService.save(computer)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Computer> findById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(computerService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Computer>> getAll(){
        return ResponseEntity.ok(computerService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Computer> update(@RequestBody Computer computer, @PathVariable("id") UUID id){
        return ResponseEntity.ok(computerService.update(computer, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id){
        computerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
