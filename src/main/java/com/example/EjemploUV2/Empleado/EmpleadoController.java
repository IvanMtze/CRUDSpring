/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EjemploUV2.Empleado;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wuser
 */
@RestController
public class EmpleadoController {
    @Autowired
    
    EmpleadoRepository er;
    
    @GetMapping(value = "/empleado", produces = "application/json")
    public EmpleadoModel getClient(){
        Optional<EmpleadoModel> dep = er.findById((long)2);
        return dep.get();
    }
    
    @PostMapping(value = "/empleado")
    public EmpleadoModel addEmpleado(@Valid @RequestBody EmpleadoModel empleado){
        return er.save(empleado);
    }
    
    @DeleteMapping(value = "/empleado")
    public EmpleadoModel
}
