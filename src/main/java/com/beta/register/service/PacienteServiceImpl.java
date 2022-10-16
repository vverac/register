package com.beta.register.service;

import com.beta.register.dao.PacienteRepository;
import com.beta.register.model.PacienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService{
    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public boolean savePaciente(PacienteEntity pacienteEntity) {
        try {
            PacienteEntity savedPaciente = pacienteRepository.save(pacienteEntity);
            if (savedPaciente != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            //Todo handle exception
        }
        return false;
    }

    @Override
    public List<PacienteEntity> getPaciente() {
        return pacienteRepository.findAll();
    }
}