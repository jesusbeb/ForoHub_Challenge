package com.alura.ForoHub_Challenge.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Clase para tratar de manera globla los errores y no en cada metodo en especifico
//RestControllerAdvice actua como una especie de proxy para todos los controllers,
//para interceptar las llamadas en caso que suceda un tipo de excepcion
@RestControllerAdvice
public class TratadorDeErrores {


    //Metodo para tratar error 404 que sucede cuando se busca un objeto que no existe en la BD
    //ExceptionHandler en esta anotacion se le dice que tipo de excepcion se quiere tratar, seguido de .class
    //Como se sabe que ResponseEntity es la entidad que tiene mapeados los tipos de error dentro y hace un
    //wrapper de las respuestas y las retorna al cliente, en el controller, entonces se crea un
    //metodo que devuelve ResponseEntity, no se pone dato en el generic <> porque ahora si es generico y no
    //se necesita especificar un objeto a tratar. Retorna ResponseEntity.notFound que significa error 404
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }
}
