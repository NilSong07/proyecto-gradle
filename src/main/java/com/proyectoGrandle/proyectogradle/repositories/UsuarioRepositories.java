package com.proyectoGrandle.proyectogradle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoGrandle.proyectogradle.models.UsuarioModel;

public interface UsuarioRepositories extends JpaRepository<UsuarioModel, Long>
{
    
}
