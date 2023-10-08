package com.proyectoGrandle.proyectogradle.service;


import org.springframework.stereotype.Service;

import com.proyectoGrandle.proyectogradle.models.UsuarioModel;
import com.proyectoGrandle.proyectogradle.repositories.UsuarioRepositories;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService implements UsuarioServiceInterface
{
    private final UsuarioRepositories usuarioRepositories;

    @Override
    public UsuarioModel guardarUsuario(UsuarioModel as_usuario) 
    {
        return usuarioRepositories.save(as_usuario);
    }

    @Override
    public UsuarioModel obtenerUsuario(Long as_id) 
    {
        return usuarioRepositories.findById(as_id).orElseThrow(() -> {throw new RuntimeException();});
    }

    @Override
    public UsuarioModel usuarioAModificar(Long as_id, UsuarioModel as_usuario) 
    {
        UsuarioModel usuarioModificado = usuarioRepositories.findById(as_id).get();

        usuarioModificado.setDireccion(as_usuario.getDireccion());
        usuarioModificado.setTelefono(as_usuario.getTelefono());


        return usuarioRepositories.save(usuarioModificado);

    }

    @Override
    public boolean eliminarUsuario(Long id) {
        
        try
        {
            usuarioRepositories.deleteById(id);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
}
