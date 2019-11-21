/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EjemploUV2.Empleado;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<List<EmpleadoModel>> getClient(){
       return ResponseEntity.ok(er.findAll());
    }
    
    @GetMapping(value = "/empleado/{id}", produces = "application/json")
    public ResponseEntity<EmpleadoModel> getClientById(@PathVariable Long id){
        if(!er.findById(id).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        Optional<EmpleadoModel> emp = er.findById(id);
        return ResponseEntity.ok(emp.get());
    }
    
    @PostMapping(value = "/empleado", produces = "application/json")
    public ResponseEntity<EmpleadoModel> addEmpleado(@Valid @RequestBody EmpleadoModel empleado){
        return ResponseEntity.ok(er.save(empleado));
    }
    
    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<EmpleadoModel> deleteEmpleado(@PathVariable Long id){
        if(!er.findById(id).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        er.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/empleado/{id}")
    public ResponseEntity<EmpleadoModel> update(@PathVariable Long id, @Valid @RequestBody EmpleadoModel empleado){
        if(!er.findById(id).isPresent()){
            return  ResponseEntity.badRequest().build();
        }
        er.deleteById(id);
        er.save(empleado);
        return ResponseEntity.ok().build();
    }
}
