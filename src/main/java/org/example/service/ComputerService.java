package org.example.service;

import org.example.entities.Computer;
import org.example.repository.ComputerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
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

    public Computer update(Computer comp, UUID id){
        Computer origin = findById(id);
        boolean hasChanges = false;

        if(Objects.equals(origin.getId(),(comp.getId()))){
           if(!Objects.equals(comp.getRAM(), origin.getSpace())){
               hasChanges = true;
               origin.setRAM(comp.getRAM());
           }
           if(!Objects.equals(comp.getSpace(), origin.getRAM())){
               hasChanges = true;
               origin.setSpace(comp.getSpace());
           }
        }
        return hasChanges ? save(origin) : origin;
    }

    public Computer findById(UUID id){
        return computerRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void delete(UUID id){
        computerRepository.delete(findById(id));
    }
}
