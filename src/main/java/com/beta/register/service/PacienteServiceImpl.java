package com.beta.register.service;

import com.beta.register.dao.PacienteRepository;
import com.beta.register.model.PacienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
@Service
public class PacienteServiceImpl implements PacienteService{
    @PersistenceContext
    EntityManager entityManager;
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

    //implementacion del metodo eliminar
    @Override
    public void eliminar(Integer id) {
PacienteEntity pacienteEntity = entityManager.find(PacienteEntity.class ,id);
entityManager.remove(pacienteEntity);
//ahora en js cuando hagan eliminar tenemos que eliminar el usuario
    }
}