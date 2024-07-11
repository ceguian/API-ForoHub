<h1>Alura ONE Foro Hub Challenge</h1>
<hl></hl>
<h2>Acerca del proyecto</h2>
<p>Alura One Foro Hub Challenge es un proyecto realizado completamente por "Alejandro Orozco" con la intervención y ayuda del programa de cursos de AluraONE. 
Consiste en el desarrollo de una APIRest desde cero, utilizando varias metodologías y paradigmas de programación acordes con las solicitadas requeridas en el campo laboral. 
El proyeto es totalmente producido en el IDE Intelli J, utilizando herramientas como Insomnia (test de requests) y MySQLWorkBench (DBMS). La API acepta request del tipo:</p>
<ul>
  <li>GET</li>
  <li>POST</li>
  <li>PUT</li>
  <li>DELETE</li>
</ul>
<p>Se utlizaron las dependencias:</p>
<ul>
  <li>Spring Data JPA</li>
  <li>MySQL Driver</li>
  <li>OpenAPI Doc</li>
  <li>JWT Auth0</li>
  <li>Spring Security</li>
  <li>Validation</li>
  <li>Flyway Migration</li>
  <li>Spring Boot DevTools</li>
  <li>Lombok</li>
</ul>
<p>La API cuenta con seguridad para todas las request, excepto el login de usuario, por tanto, primero se debera iniciar sesion de usuario, a lo cual, se devolverá como respuesta un BearerToken, esté mismo será utilizado en todas las request, el Token cuenta con un tiempo de expiración de 2hrs.</p>

<h2>Instrucciones de Uso</h2>
<p>La API únicamente sirve dentro de consola al tratarse de una aplicación de Back-End, por tanto se necesita de programas terceros para poder hacer las request dentro de la API, se recomienda POSTMAN o Insomnia. 
Además, la API utiliza una base de datos MySQL debido al Driver instanciado en las propiedades del programa, si desea utilizar otro tipo de base de datos, es necesario cambiar el driver. Independientemente del DBMS que se esté utilizando, el programa no realizar la creación de la base de datos por sí mismo, por lo cual sera necesario crear la base de datos con el nombre utilizado en las propiedades. EL nombre de la propiedad de la base de datos esta resguardado dentro de variables de entorno las cuales deberán ser agregadas y configuradas dentro de la Base de Datos para que se pueda acceder a la misma.</p>
<p>Los Usuario deben ser agregados dentro del DBMS debido a que no existe solicitud para ingresar usuarios a la base de datos. Todos los usuarios gozan de los mismos permisos.</p>
</br>
<p>Para saber más acerca del uso de la API está cuenta con docuementación brindada por OpenAPI con la cual podremos ver las solicitudes del cuerpo del cada request y su funcionamiento.</p>

<hl>
<h1>Agradecimientos</h1>
<p>Agradezco de todo corazón a ALuraONE por su compromiso, trabajo y esfuerzo puesto en sus cursos, así como la oportunidad de seguir creciendo como programador y en el desarrollo de mi carreara profesional. Atte: Alejandro Orozco(ceguian)</p>
