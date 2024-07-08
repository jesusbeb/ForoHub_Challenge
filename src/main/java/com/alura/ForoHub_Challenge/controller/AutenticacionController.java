package com.alura.ForoHub_Challenge.controller;

import com.alura.ForoHub_Challenge.dto.DatosAutenticarUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//AuthenticationManager se necesita inyectar pero Spring no lo tiene en su contexto, por lo
//que se crea en la clase SecurityConfigurations
@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;


    //AuthenticationManager es la clase que dispara el proceso de autenticacion en Spring,
    //usamos su metodo authenticate y le enviamos el token que es el nombre de usuario y su contraseña
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticarUsuario datosAutenticarUsuario){
        Authentication token = new UsernamePasswordAuthenticationToken(datosAutenticarUsuario.nombre(),
                datosAutenticarUsuario.password());
        authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
