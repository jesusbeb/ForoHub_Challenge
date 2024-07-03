package com.alura.ForoHub_Challenge.controller;

import com.alura.ForoHub_Challenge.dto.DatosRegistroTopico;
import com.alura.ForoHub_Challenge.repository.TopicoRepository;
import com.alura.ForoHub_Challenge.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

//RestController para indicar a Spring que es un controller
//RequestMapping para mapear la ruta o path topicos
@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private TopicoService topicoService;

    //Metodo para registrar topico. Request de tipo POST
    @PostMapping
    public void RegistrarTopico(@RequestBody  @Valid DatosRegistroTopico datosRegistroTopico){
        var topico = topicoService.crearTopico(datosRegistroTopico);
    }
}