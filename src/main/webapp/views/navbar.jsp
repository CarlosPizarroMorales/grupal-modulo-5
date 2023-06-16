<nav class="navbar navbar-expand-lg bg-body-tertiary bg-dark" data-bs-theme="dark">
  	<div class="container-fluid">
    	<a class="navbar-brand" href="/grupal-modulo-5/index.jsp">${saludo}</a>
    	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      		<span class="navbar-toggler-icon"></span>
    	</button>
    	<div class="collapse navbar-collapse" id="navbarSupportedContent">
      		<ul class="navbar-nav ms-auto me-5 mb-2 mb-lg-0">
        		<li class="nav-item dropdown">
          			<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            			Opciones
          			</a>
	          		<ul class="dropdown-menu">
	            		<li><a class="dropdown-item" href="/grupal-modulo-5/views/contacto.jsp">Contacto</a></li>
	            		<li><hr class="dropdown-divider"></li>
	            		<li><a class="dropdown-item" href="/grupal-modulo-5/views/crearCapacitacion.jsp">Crear Capacitacion</a></li>
	            		<li><hr class="dropdown-divider"></li>
	            		<li><a class="dropdown-item" href="/grupal-modulo-5/capacitaciones">Listar Capacitaciones</a></li>
	            		<li><hr class="dropdown-divider"></li>
	            		<li><a class="dropdown-item" href="/grupal-modulo-5/views/crearUsuario.jsp">Crear Usuario</a></li>
	            		<li><hr class="dropdown-divider"></li>
	            		<li><a class="dropdown-item" href="/grupal-modulo-5/usuarios">Listar Usuarios</a></li>
	          		</ul>
        		</li>
        		<li class="nav-item">
          			<a class="nav-link " aria-current="page" href="/grupal-modulo-5/views/login.jsp">iniciar sesi�n</a>
        		</li>
        		<li class="nav-item">
         			<a class="nav-link" href="/grupal-modulo-5/iniciar-sesion">cerrar sesi�n</a>
        		</li>
      		</ul>
    	</div> <!-- Ends navbar-collapse -->
  	</div> <!-- Ends navbar > container-fluid  -->
</nav>