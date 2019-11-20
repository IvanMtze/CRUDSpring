/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EjemploUV2.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author wuser
 */
public interface EmpleadoRepository extends JpaRepository<EmpleadoModel, Long>{
    
}
