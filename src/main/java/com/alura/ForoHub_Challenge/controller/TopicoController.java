package com.alura.ForoHub_Challenge.controller;

import com.alura.ForoHub_Challenge.dto.DatosListadoTopico;
import com.alura.ForoHub_Challenge.dto.DatosRegistroTopico;
import com.alura.ForoHub_Challenge.repository.TopicoRepository;
import com.alura.ForoHub_Challenge.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
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

    //Metodo para listar una paginacion de todos los topicos de la BD. Request del tipo GET
    //Metodo que devuelve un ResponseEntity de tipo Page<DatosListadoTopico>
    //Se le envia un parametro que llega del frontend del tipo Pageable, el cual puede ser opcional.
    //Pageable se envia al metodo findAll(), se aplica map a cada elemento para crear un nuevo
    //objeto de tipo DatosListadoTopico
    //El cliente puede enviar query params para mostrar la cantidad de elementos por pagina, p.e.
    //http://localhost:8080/topicos?size=1 ó http://localhost:8080/medicos?size=5 ó
    //http://localhost:8080/topicos?size=2&page=1  retorna la pagina 1 con 2 elementos
    //esto gracias al parametro Pageable.
    //Tambien el cliente puede enviar por query param el orden en que se muestra la lista, segun el nombre
    //del atributo que indique, tal y como esta nombrado en la entidad de la BD, p.e.
    //http://localhost:8080/topicos?size=10&page=0&sort=titulo      "titulo" es el nombre del atributo
    //PageableDefault(size= ) sobreescribe los elementos a mostrar por defecto que ya tiene Pageable
    //Se retorna ResponseEntity con ok y dentro del ok se retorna el DatosListadoTopico que devolvio el repositorio
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 3) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

}