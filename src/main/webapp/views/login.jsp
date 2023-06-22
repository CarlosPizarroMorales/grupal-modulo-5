<!DOCTYPE html>
<html>
<head>
	<%@ include file='/views/headMetaLink.jsp' %>
	<title>BeSafe Login</title>
</head>

<body class="container py-5 ">
<div class="row justify-content-center">
<div class="col-6">
	<!-- <form action="/grupal-modulo-5/iniciar-sesion" method="post" id="formLogin"> -->
	<form action="/grupal-modulo-5/iniciar-sesion" method="post" id="formLogin">
  		<div class="mb-3">
  		<h1 class="text-center">Inicio de Sesión</h1>
  			<label for="rutCliente" class="form-label">Usuario:</label>
  			<input type="text" class="form-control" id="rut" name="rut" pattern="[\w]{5}" placeholder="nombre de usuario 5 caracteres" required>
  			<!-- <input type="text" class="form-control" id="rut" name="rut" pattern="[\w]{5}" placeholder="nombre de usuario 5 caracteres" required> -->
  		</div>
  		<div class="mb-3">
	    	<label for="clave" class="form-label">Password:</label>
	    	<input type="password" class="form-control" id="password" name="password" placeholder="clave de usuario" required>
  		</div>
  		
  		<button class="btn btn-outline-light" type="submit" id="submitBtnLogin">Iniciar</button>
	</form>
</div>
</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
	<script src="../js/index.js"></script>
</body>
</html>