package com.beta.register.controller;

import com.beta.register.model.PacienteEntity;
import com.beta.register.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/paciente")
public class PacienteController {


    @Autowired
    PacienteService pacienteService;


    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity<String> savePaciente( @RequestBody PacienteEntity pacienteEntity){
        if(pacienteService.savePaciente(pacienteEntity)){
            return new ResponseEntity<>("Paciente Save", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Paciente Failed to Save", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //localhost:8080/paciente/save para guardar en el fetch


    @CrossOrigin
    @GetMapping("/getPacientes")
    public ResponseEntity<List<PacienteEntity>> getPaciente() {
        return new ResponseEntity<>(pacienteService.getPaciente(), HttpStatus.OK);
    }
    //localhost:8080/paciente/getPacientes para mostrar pacientes con fetch



    @CrossOrigin
  //eliminamos por el id
    @DeleteMapping ("/getPacientes/{id}")
    //el valor {id } lo recibimos aqui abajo
    public void eliminar(@PathVariable Integer id) {
       pacienteService.eliminar(id);
    }
}
