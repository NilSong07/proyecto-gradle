package com.proyectoGrandle.proyectogradle.service;


import com.proyectoGrandle.proyectogradle.models.UsuarioModel;

public interface UsuarioServiceInterface {

    UsuarioModel guardarUsuario(UsuarioModel as_usuario);

    UsuarioModel obtenerUsuario(Long al_id);

    UsuarioModel usuarioAModificar(Long al_id, UsuarioModel as_usuario);

    boolean eliminarUsuario(Long id);
}
