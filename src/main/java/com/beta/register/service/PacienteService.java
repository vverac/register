package com.beta.register.service;

import com.beta.register.model.PacienteEntity;

import java.util.List;

public interface PacienteService {

    boolean savePaciente(PacienteEntity pacienteEntity);

    List<PacienteEntity> getPaciente();
}
