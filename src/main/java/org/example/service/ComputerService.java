package org.example.service;

import org.example.entities.Computer;
import org.example.repository.ComputerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ComputerService {
    private final ComputerRepository computerRepository;

    public ComputerService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    public List<Computer> getAll(){
       return computerRepository.findAll();
    }

    public Computer save(Computer comp){
        return computerRepository.save(comp);
    }

    public Computer findById(UUID id){
        return computerRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void delete(UUID id){
        computerRepository.delete(findById(id));
    }
}
