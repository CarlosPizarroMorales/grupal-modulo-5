<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% if (request.getSession().getAttribute("usuario") == null) {
		request.getRequestDispatcher("login.jsp").forward(request, response);	
	} else {
		System.out.println("la sesión si existe");
	}
%>

<% String id = request.getSession().getAttribute("id") == null ? "" : (String) request.getSession().getAttribute("id"); %>

<!DOCTYPE html>
<html lang="en">
<head>

<%@ include file='/views/headMetaLink.jsp'%>

<title>Crear usuario</title>
</head>

<body class="text-light">

	<%@ include file='/views/navbar.jsp'%>

	<main class="container">
		<h1 class="text-center">Crear usuario</h1>
		<div class="row justify-content-center">
			<div class="col-6">
				<form action="/grupal-modulo-5/crear-usuario" method="post" class="form">
					<fieldset>
						<legend>Datos básicos</legend>
						<input hidden type="text" name="id" value="${id}">
						<label class="form-label" for="">Rut: 
							<input type="text" class="form-control" name="rut"  pattern="\d{6,8}-[kK\d]" placeholder="12345678-0" required/>
						</label> 
						<label class="form-label" for="">Nombres: 
							<input type="text" class="form-control" name="nombres" maxlength="50" required/>
						</label> 
						<label class="form-label" for="">Apellidos: 
							<input type="text" class="form-control" name="apellidos" maxlength="50" required/>
						</label> 
						<label for="" class="form-label">Fecha de Nacimiento: 
							<input type="date" class="form-control" name="fechaNacimiento" required/>
						</label>
					</fieldset>
					<select name="tipoUsuario" id="" class="form-select">
						<option value="administrativo" disabled selected>Seleccione:</option>
						<option value="administrativo">Administrativo</option>
						<option value="profesional">Profesional</option>
						<option value="cliente">Cliente</option>
					</select> <br>
					<!-- tipo de usuario específico -->
					<fieldset id="especifico"></fieldset>
				</form>
			</div>
		</div>
	</main>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
	<!-- <script src="../js/index.js"></script> -->
	<script>
	

	const select = document.querySelector('select');
	const especifico = document.querySelector('#especifico');

	select.addEventListener('change', handler);

	function handler(e) {
	  especifico.innerHTML = tipoUsuario(e.target.value);
	}

	function tipoUsuario(tipo) {
	  const usuarios = {
	    cliente: `<legend>Cliente</legend>
	    				<label class="form-label">Teléfono: <input type="text" class="form-control" name="telefono" required></label>
	    				<label class="form-label">Dirección: <input type="text" class="form-control ms-2" name="direccion" required/></label>
	    				<label class="form-label">Comuna <input type="text" class="form-control" name="comuna" required/></label>
	    				<label class="form-label">Sistema de Salud: <input type="text" class="form-control" name="salud" required/></label>
	    				<label class="form-label">AFP: <input type="text" class="form-control" name="afp" required></label>
	    				<label class="form-label">Edad: <input type="number" class="form-control" name="edad" min="1" max="150" step="1" required/></label>
	    				<input type="submit" class="form-control" value="Crear">`,
	    profesional: `<legend>Profesional</legend><label class="form-label">Título: <input type="text" class="form-control" name="titulo" required></label><label class="form-label">Fecha ingreso: <input type="date" class="form-control ms-2" name="fechaIngreso" required></label><input type="submit" class="form-control" value="Crear">`,
	    administrativo: `<legend>Administrativo</legend><label class="form-label">Area: <input type="text" class="form-control" name="area" required></label><label class="form-label">Exp. previa: <input type="text" class="form-control " name="expPrevia" required></label><input type="submit" class="form-control" value="Crear">`
	  	
	  }
	  return usuarios[tipo];
	}
	</script>
</body>
</html>