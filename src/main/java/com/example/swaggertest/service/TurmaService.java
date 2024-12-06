package com.example.swaggertest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swaggertest.entity.TurmaEntity;
import com.example.swaggertest.repository.TurmaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    
    public List<TurmaEntity> getAll() {
        return turmaRepository.findAll();
    }

    
    public TurmaEntity getById(Integer id) {
        Optional<TurmaEntity> turma = turmaRepository.findById(id);
        return turma.orElse(null);
    }

    
    public TurmaEntity saveTurma(TurmaEntity turma) {
        return turmaRepository.save(turma);
    }

    
    public TurmaEntity updateTurma(Integer id, TurmaEntity turma) {
        if (turmaRepository.existsById(id)) {
            turma.setIdturma(id);
            return turmaRepository.save(turma);
        }
        return null;
    }

    
    public boolean deleteTurma(Integer id) {
        if (turmaRepository.existsById(id)) {
        	turmaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
