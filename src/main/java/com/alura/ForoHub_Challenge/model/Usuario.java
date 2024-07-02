package com.alura.ForoHub_Challenge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

//Clase para mapear en la entidad Usuario
//mappedBy, se mapea a la clase Topico por medio del atributo autor
//JoinColumn da el nombre al campo que se creara en la tabla Usuario de la BD que relacionara con
//el topico

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String password;
    //@OneToMany(fetch = FetchType.LAZY)//, mappedBy = "autor")
    //@JoinColumn(name = "id_topico")
    //private List<Topico> topicos;
}
