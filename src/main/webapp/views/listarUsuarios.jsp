<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% if (request.getSession().getAttribute("usuario") == null) {
		request.getRequestDispatcher("login.jsp").forward(request, response);	
	} else {
		System.out.println("la sesión si existe");
	}
%>

<!DOCTYPE html>
<html>
<head>
<%@ include file='/views/headMetaLink.jsp'%>
<title>BeSafe Listar Usuarios</title>
</head>
<body>
	<%@ include file='/views/navbar.jsp'%>
	<%@ page import="modelo.*" %>
	<%@ page import="java.util.*" %>
	<main class="container-fluid py-5">
		<h1 class="text-center">Listado de Usuarios</h1>
		<div class="row">
		<div class="col table-responsive">
		 <table class="table table-striped table-hover" ><!--style="white-space: nowrap; overflow-x: auto;"  -->
                <thead>
                    <tr class="">
                        <th scope="col">Rut</th>
                        <th scope="col">Nombres</th>
                        <th scope="col">Apellidos</th>
                        <th scope="col">F. Nac.</th><!-- Fecha de Nacimiento -->
                        <th scope="col">Telefono</th>
                        <th scope="col">Dirección</th>
                        <th scope="col">Comuna</th>
                        <th scope="col">AFP</th>
                        <th scope="col">Salud</th><!-- Sistema de Salud -->
                        <th scope="col">Edad</th>
                        <th scope="col">Area</th>
                        <th scope="col">Experiencia</th><!-- Experiencia Previa -->
                        <th scope="col">Titulo</th>
                        <th scope="col">Ingreso</th><!-- Fecha de Ingreso -->
                        <th scope="col">Acción</th>
                    </tr>
                </thead>
                <!-- >Rut	Nombres	Apellidos	Fecha de Nacimiento	Telefono	Dirección	Comuna	AFP	Sistema de Salud	Edad	Area	Experiencia Previa	Titulo	Fecha de Ingreso -->
                <tbody>
                    <% List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios"); %>
				        <% if (usuarios != null && !usuarios.isEmpty()) { %>
				            <% for (Usuario u : usuarios) { %>
                				<% String tipo = u.getClass().getSimpleName(); %>
                				<% System.out.println(u.getId()); %>
				          
				                <tr>
				                    <td><%= u.getRut()%></td> <!-- Rut -->
				                    <td><%= u.getNombres()%></td> <!-- Nombres -->
				                    <td><%= u.getApellidos()%></td> <!-- Apellidos -->
				                    <td><%= u.getFechaNacimiento()%></td> <!-- FechaNacimiento -->
				                    <% if (u instanceof Cliente) {%> <!-- Valida tipo de cliente COPIAR DESDE ACÁ--> 
									<% Cliente c = (Cliente) u; %> 
				                    <td><%= c.getTelefono()%></td> <!-- Telefono -->
				                    <td><%= c.getDireccion() %></td> <!-- Direccion -->
				                    <td><%= c.getComuna() %></td> <!-- Comuna -->
				                    <td><%= c.getAfp() %></td> <!-- Afp -->
				                    <td><%= c.getSistemaSalud() %></td> <!-- Sistema Salud -->
				                    <td><%= c.getEdad() %></td> <!-- Edad -->
				                    <%} else {%>
				                    <td>--</td> <!-- Telefono -->
				                    <td>--</td> <!-- Direccion -->
				                    <td>--</td> <!-- Comuna -->
				                    <td>--</td> <!-- Afp -->
				                    <td>--</td> <!-- Sistema Salud -->
				                    <td>--</td> <!-- Edad -->
				                    <% }%>
				                    <% if (u instanceof Administrativo){ %>
				                    <% Administrativo a = (Administrativo ) u; %>
				                    <td><%= a.getArea()%></td>
				                    <td><%= a.getExpPrevia() %></td>
				                    <%} else { %>
				                    <td>--</td>
				                    <td>--</td>
				                    <% }%>
				                    <% if (u instanceof Profesional) {%>
				                    <% Profesional p = (Profesional) u; %>
				                    <td><%=  p.getTitulo()%></td>
				                    <td><%=  p.getFechaIngreso()%></td>
				                	<%} else{%>
				                	<td>--</td>
				                    <td>--</td>
				                	<%} %>
				                	<td>
									<form action="/grupal-modulo-5/ModificarUsuario" method="GET" style="display:inline">
									<input type="hidden" name="id" value="<%= u.getId() %>">
									    <input type="submit" class="btn btn-outline-primary btn-sm" value="Editar">
									</form>
									<span>|</span>
									<form action="/grupal-modulo-5/EliminarUsuario" method="GET" style="display:inline">
									<input type="hidden" name="id" value="<%= u.getId() %>">
									    <input type="submit" class="btn btn-outline-danger btn-sm" value="Eliminar">
									</form>
				                    </td>
				                </tr>
				            <% } %>
				        <% } else { %>
			            <tr>
			                <td colspan="14">No se encontraron capacitaciones.</td>
			            </tr>
			        <% } %>
                </tbody>
            </table>
		</div>
		</div>
	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
	<script src="/grupal-modulo-5/js/index.js"></script>
</body>
</html>