package com.example.swaggertest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swaggertest.entity.InstrutorEntity;
import com.example.swaggertest.repository.InstrutorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    
    public List<InstrutorEntity> getAll() {
        return instrutorRepository.findAll();
    }

    
    public InstrutorEntity getById(Integer id) {
        Optional<InstrutorEntity> instrutor = instrutorRepository.findById(id);
        return instrutor.orElse(null);
    }

    
    public InstrutorEntity saveInstrutor(InstrutorEntity instrutor) {
        return instrutorRepository.save(instrutor);
    }

    
    public InstrutorEntity updateInstrutor(Integer id, InstrutorEntity instrutor) {
        if (instrutorRepository.existsById(id)) {
            instrutor.setIdinstrutor(id);
            return instrutorRepository.save(instrutor);
        }
        return null;
    }

    
    public boolean deleteInstrutor(Integer id) {
        if (instrutorRepository.existsById(id)) {
            instrutorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

