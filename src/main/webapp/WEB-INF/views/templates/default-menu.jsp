<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
a {
	color: #000;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

a:visited {
	color: #000;
}

.navi {
	list-style-type: none;
	margin: 0;
	padding: 0;
	background-color: #f1f1f1;
	position: fixed;
	height: 100%;
	overflow: auto;
}

.navi li {
	list-style-type: none;
	margin: 0 10px;
}

.navi li a{
	display: block;
	color: #000;
	padding: 8px 16px;
	text-decoration: none;
}

button{
	display: block;
	color: #000;
	padding: 8px 16px;
	text-decoration: none;
}


.navi li.active {
	background-color: cornflowerblue;
	color: white;
}

.navi li.active a {
	color: #fff;
	font-weight: bold;
}

</style>


<div class="col-lg-2" style="margin-left: 10px;">

	<ul class="navi">
		<spring:url value="/home" var="home"></spring:url>
		<li><a href="${home}"
			style="height: 80px; color: white; background-color: cornflowerblue; font-size: 20px;">El
				Deposito</a></li>

		<spring:url value="/home" var="home"></spring:url>
		<li><a href="${home}">Inicio</a></li>
		
		<spring:url value="/resumen" var="resumen" />
		<li><a href="${resumen}"><i class="fa fa-bar-chart-o fa-fw"></i>Resumen</a></li>
		
		<spring:url value="/clientes" var="listaDeClientes" />
		<li><a href="${listaDeClientes}">Lista de Clientes</a></li>

		<spring:url value="/clientes/crear" var="crearCliente" />
		<li><a href="${crearCliente}">Nuevo Cliente</a></li>

		<spring:url value="/actividades/crearActividad" var="crearActividad" />
		<li><a href="${crearActividad}">Nueva Actividad</a></li>

		<spring:url value="/actividades" var="listadoActividades" />
		<li><a href="${listadoActividades}">Actividades</a></li>

		<spring:url value="/profesores/crearProfesor" var="crearProfesor" />
		<li><a href="${crearProfesor}">Nuevo Profesor</a></li>

		<spring:url value="/profesores" var="listadoProfesores" />
		<li><a href="${listadoProfesores}">Profesores</a></li>

		<spring:url value="/horarios/crearHorario" var="crearHorario" />
		<li><a href="${crearHorario}">Nuevo Horario</a></li>

		<spring:url value="/horarios" var="listadoHorarios" />
		<li><a href="${listadoHorarios}">Horarios</a></li>

		
		<li>
		<spring:url value="/logout" var="logout"/>
		<form action="${logout}" method="post">
        	<a><button type="submit" class="btn" style="background-color: cornflowerblue;" >
        	<i class="fa fa-sign-out fa-fw"></i> 
        	Logout</button></a>
        </form>
		</li>			
	</ul>

</div>

		



<spring:url value="/resources/js/jquery.min.js" var="jqueryMin" />
<script src="${jqueryMin}"></script>

<script>

$(function () {
    setNavigation();
});

function setNavigation() {
    var path = window.location.pathname;
    path = path.replace(/\/$/, "");
    path = decodeURIComponent(path);

    $(".navi a").each(function () {
        var href = $(this).attr('href');
        //if (path.substring(0, href.length) === href) {
//            $(this).closest('li').addClass('active');
//      }
        if (path === href) {
            $(this).closest('li').addClass('active');
      }
        
    });
}
</script>
