package com.proyectoGrandle.proyectogradle.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoGrandle.proyectogradle.models.UsuarioModel;
import com.proyectoGrandle.proyectogradle.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController 
{
    private final UsuarioService  usuarioService;

    @PostMapping("/")
    public ResponseEntity guardarUsuario(@RequestBody UsuarioModel as_usuario)
    {
        return new ResponseEntity(usuarioService.guardarUsuario(as_usuario), HttpStatus.CREATED);
    }

    @GetMapping("/id")
    public ResponseEntity obtenerUsuario(@PathVariable ("id") Long as_id)
    {
        return new ResponseEntity(usuarioService.obtenerUsuario(as_id), HttpStatus.OK);

    }

    @PutMapping("/id")
    public ResponseEntity usuarioModificar(@PathVariable ("id") Long as_id, UsuarioModel as_usuario)
    {
        return new ResponseEntity(usuarioService.usuarioAModificar(as_id, as_usuario), HttpStatus.OK);

    }

    @DeleteMapping("/id")
    public ResponseEntity eliminarUsuario(@PathVariable ("id") Long as_id)
    {
        boolean respuesta = usuarioService.eliminarUsuario(as_id);
        if(respuesta == true)
        {
            return new ResponseEntity(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
}
