/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EjemploUV2.Empleado;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("This is The Hello Swagger API Documentation")
public class EmpleadoController {
    
    @Autowired
    EmpleadoRepository er;
    
    @ApiOperation("Return the list of employeds")
    @GetMapping(value = "/empleado", produces = "application/json")
    public ResponseEntity<List<EmpleadoModel>> getClient(){
       return ResponseEntity.ok(er.findAll());
    }
    
    @GetMapping(value = "/empleado/{id}", produces = "application/json")
    @ApiOperation("Returns the given employed if exits")
    public ResponseEntity<EmpleadoModel> getClientById(@PathVariable Long id){
        if(!er.findById(id).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        Optional<EmpleadoModel> emp = er.findById(id);
        return ResponseEntity.ok(emp.get());
    }
    
    @PostMapping(value = "/empleado", produces = "application/json")
    @ApiOperation("This is the POST request")
    public ResponseEntity<EmpleadoModel> addEmpleado(@Valid @RequestBody EmpleadoModel empleado){
        return ResponseEntity.ok(er.save(empleado));
    }
    
    @DeleteMapping("/empleado/{id}")
    @ApiOperation("Deletes the employed")
    public ResponseEntity<EmpleadoModel> deleteEmpleado(@PathVariable Long id){
        if(!er.findById(id).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        er.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/empleado/{id}")
    @ApiOperation("This is the PUT request")
    public ResponseEntity<EmpleadoModel> update(@PathVariable Long id, @Valid @RequestBody EmpleadoModel empleado){
        if(!er.findById(id).isPresent()){
            return  ResponseEntity.badRequest().build();
        }
       
        er.deleteById(id);
        er.save(empleado);
        return ResponseEntity.ok().build();
    }
}
