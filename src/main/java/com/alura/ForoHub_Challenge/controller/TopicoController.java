package com.alura.ForoHub_Challenge.controller;

import com.alura.ForoHub_Challenge.dto.DatosDetalleTopico;
import com.alura.ForoHub_Challenge.dto.DatosListadoTopico;
import com.alura.ForoHub_Challenge.dto.DatosRegistroTopico;
import com.alura.ForoHub_Challenge.model.Topico;
import com.alura.ForoHub_Challenge.repository.TopicoRepository;
import com.alura.ForoHub_Challenge.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

//RestController para indicar a Spring que es un controller
//RequestMapping para mapear la ruta o path topicos
@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private TopicoService topicoService;

    //Metodo para registrar topico. Request de tipo POST. Retorna codigo 201 de objeto creado
    //El metodo retorna un ResponseEntity que acepta un parametro generico por lo que se le indica que
    //sera del tipo DatosDetalleTopico. Recibe el json DatosRegistroTopico del cliente
    //Se crea el topico en la BD usando el metodo crearTopico de topicoService
    //Se mapea un nuevo objeto de tipo DatosDetalleTopico con el Topico creado, para retornar al cliente
    //Se retorna un ResponseEntity.created que es un codigo 201, created pide la url donde el objeto
    //creado sera encontrado. Por lo que se crea una URI llamada url usando una clase auxiliar (helper) llamada
    //UriComponentsBuilder para obtener los datos del servidor y se invoca en los parametros del metodo.
    //Se usa el metodo path y se le envia dicho path con el id dinamico. Para hacer el id dinamico se
    //usa el metodo buildAndExpand y se le envia el id del topico, finalmente se convierte a Uri
    //En el retorno tambien pide un body que es el datosDetalleTopico
    @PostMapping
    public ResponseEntity<DatosDetalleTopico> RegistrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                              UriComponentsBuilder uriComponentsBuilder){
        var topico = topicoService.crearTopico(datosRegistroTopico);
        DatosDetalleTopico datosDetalleTopico = new DatosDetalleTopico(topico.getId(), topico.getNombreCurso(),
                topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getEstado() ? "Abierto" : "Cerrado");
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosDetalleTopico);
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