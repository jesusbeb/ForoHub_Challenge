package com.alura.ForoHub_Challenge.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


//Las clases anotadas como Configuration son cargadas primero al correr la app
//EnableWebSecurity habilita el modulo WebSecurity con el que indico que el metodo que se crea esta siendo
//implementado para sobreescribir el comportamiento de autenticacion que se quiere
@Configuration
@EnableWebSecurity
public class SecurityConfigurations {


    //Metodo para implementar una autenticacion Stateless (tipo de autenticacion donde el servidor no sabe
    //quien se encuentra logeado) y se retorna un objeto SecurityFilterChain y recibe un objeto del tipo HttpSecurity
    //csrf es para evitar suplantacion de identidad pero como no se usa autenticacion Statefull no se
    //necesita y se deshabilita. En sessionCreationPolicy se le indica que la poliza de creacion de la
    //sesion sea stateless. Finalmente con esto el cliente tiene nuevamente acceso a los recursos de la app
    /*Deprecated
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.csrf().disable().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().build();
    }*/
    //Metodo generado con ChatGPT ya que el anterior aparece como Deprecated
    //En lugar de usar .csrf().disable(), usamos una lambda para deshabilitar CSRF:
    //csrf(csrf -> csrf.disable()). Esta es la forma recomendada en las versiones más
    //recientes de Spring Security.
    //En lugar de usar .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS),
    //usamos una lambda para configurar la política de creación de sesiones:
    //sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return httpSecurity.build();
    }


}