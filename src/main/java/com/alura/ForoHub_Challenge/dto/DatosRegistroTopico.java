package com.alura.ForoHub_Challenge.dto;

import com.alura.ForoHub_Challenge.model.Curso;

//Clase record para tratar los datos que vienen en json del cliente
public record DatosRegistroTopico(
        Long idUsuario,
        Curso nombreCurso,
        String titulo,
        String mensaje
) {
}
