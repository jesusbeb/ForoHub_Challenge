<h1> Challengue: ForoHub </h1>


<h2>Descripción</h2>
<p>
  Este proyecto es un Challenge o Desafío para crear una API REST usando Spring para un foro. Un foro es un espacio donde todos los participantes de una plataforma pueden plantear sus preguntas sobre determinados tópicos. Aqui se replica
  ese proceso a nivel de Backend. Esto como parte del programa de Oracle Next Education y Alura Latam.
</p>


<h2>Funciones disponibles</h2>
<p>
  Las funciones disponibles en relación a los tópicos, se describen a continuación:
</p>

<ol>
  <li>
    <h2>Registrar Usuario</h2>
    <p>
      Para poder hacer uso de la API Rest es necesario registrarse como nuevo usuario, enviando en formato json el nombre, email y password.
      El HTTP Request de tipo POST se hace en http://localhost:8080/usuarios
    </p>
    ![image](https://github.com/user-attachments/assets/554931e0-f878-4196-89ed-c74a58a700cb)

  </li>

  <li>
    <h2>Login de usuario</h2>
    <p>
      Despues de haberse resistrado como nuevo usuario, es necesario hacer login con su nombre y contraseña, los cuales son enviados en formato json. Esto es indispensable para hacer uso de las demas funciones, ya que al logearse la 
      aplicacion devuelve un token de autorizacion que tendra que ser enviado en el header de los request para tener acceso a los recursos y funciones del foro. El token recibido tiene una validez de dos horas, despues es necesario volver a 
      logearse para obtener uno nuevo. 
      El HTTP Request de tipo POST se hace en http://localhost:8080/login
    </p>
    ![image](https://github.com/jesusbeb/ForoHub_Challenge/assets/99098993/5732deb7-44f1-4f2b-b376-c3244756f411)

  </li>

  <li>
    <h2>Registrar topico</h2>
    <p>
      Esta es la funcion encargada para crear un topico, el cual es recibido en formato json con el id del usuario, nombre del curso, titulo del topico y mensaje del topico. Todos los datos mencionados que deben ir en el json, son obligatorios.
      Tambien es obligatorio enviar el token recibido de la app al momento de que hizo login el usuario. 
      El HTTP Request de tipo POST se hace en http://localhost:8080/topicos
    </p>
    <p>Envio de los datos para crear un tópico</p>
    ![image](https://github.com/jesusbeb/ForoHub_Challenge/assets/99098993/c55f45a4-9026-4220-a6cb-4e5f6ae62800)
    <p>Envio del token</p>
    ![image](https://github.com/jesusbeb/ForoHub_Challenge/assets/99098993/8ebdbfbf-8209-4857-b761-c36cf19ccd82)

  </li>

  <li>
    <h2>Obtener datos topico</h2>
    <p>
      Esta funcion permite mostrar informacion sobre un topico en especifico ya almacenado en la BD con solo enviar el id del topico en la URL y el token para tener acceso a los recursos. 
      Ejemplo de HTTP Request de tipo GET para mostrar el topico con id 6:
      http://localhost:8080/topicos/6
    </p>
    ![image](https://github.com/jesusbeb/ForoHub_Challenge/assets/99098993/6a588cf6-76bd-404e-9ebf-37c9e65c0455)

  </li>

  <li>
    <h2>Actualizar topico</h2>
    <p>
      Con esta función se puede editar la información de un topico ya almacenado en la BD. Se permite editar el titulo y/o el mensaje del topico, se envia tambien el id del usuario, al igual que el token de autorizacion.
      Ejemplo de HTTP Request de tipo PUT para actualizar el topico con id 6:
      http://localhost:8080/topicos/6
    </p>
    ![image](https://github.com/jesusbeb/ForoHub_Challenge/assets/99098993/67f50380-7df5-4925-bfdb-89d23b2baf02)

  </li>

  <li>
    <h2>Eliminar topico</h2>
    <p>
      Esta funcion sirve para eliminar un topico almacenado en la BD, simplemente se envia el id del topico en la URL, al igual que el Bearer Token.
      Ejemplo de HTTP Request de tipo DELETE para eliminar el topico con el id 6:
      http://localhost:8080/topicos/6
    </p>
    
    
  </li>

  <li>
    <h2>Listar topicos</h2>
    <p>
      Con esta funcion se muestran todos los topicos almacenados en la BD, basta con enviar el token de autorizacion y el request de tipo GET:
      http://localhost:8080/topicos
    </p>
    ![image](https://github.com/jesusbeb/ForoHub_Challenge/assets/99098993/1b0391da-e59d-492a-a3f8-1738d3638ea8)

  </li>

</ol>


<h2>Cómo usarlo</h2>
<p>
  Para hacer uso del API Rest, se aconseja seguir los siguientes pasos: 
</p>

<ol>
  <li>
    <p>Descargar el repositorio y descomprimirlo en alguna carpeta.</p>
  </li>
  
  <li>
    <p>Se recomienda usar IntelliJ para abrir como proyecto la carpeta descargada.</p>
  </li>
    
  <li>
    <p>Una vez abierto el proyecto en IntelliJ, actualizar las dependencias de Maven que se encuentran en el archivo pom.xml para que se carguen en el proyecto.</p>
  </li>
    
  <li>
    <p>Se recomienda usar MySQL Workbench y crear una Base de Datos sin tablas.
    </p>
  </li>
    
  <li>
    <p>Configurar el archivo application.properties del proyecto para indicar la url de la BD, username y password.
     Ejemplo de configuracion necesaria para agregar:</p>
    
    spring.datasource.url=jdbc:mysql://localhost/topicos_challenge
    spring.datasource.username=root
    spring.datasource.password=P4ssword
    
  </li>

  <li>
    <p>Despues ejecutar la aplicacion para hacer uso de la API REST mediante un programa para consumir APIS, en este caso se recomienda Insomnia para ejecutar los HTTP Request,
    tal y como se mostro en las capturas de pantalla en el apartado de "Funciones Disponibles"</p>
  </li>
  
</ol>


<h3>Tecnologias usadas</h3>
<ul>
  <li>Java</li>
  <li>Springboot</li>
  <li>Lombok</li>
  <li>Flyway</li>
  <li>MySQL</li>
  <li>JPA</li>
  <li>Spring Security</li>
  <li>JWT</li>
</ul>


<h3>Notas adicionales</h3>
<p>
  La API REST en este punto es funcional y resuelve los requisitos solicitados del Challenge, sin embargo se iran mejorando las funcionalidades y agregando mas, para una completa mejor experiencia.
</p>


<h3>Desarrollador del proyecto</h3>
<p>Jesús Beltrán B</p>
