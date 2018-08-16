<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:url value="/resources/css/navbar.css" var="navbarCss"/>
<link href="${navbarCss}" rel="stylesheet"/>

<spring:url value="/resources/css/all.css" var="fontAwesomeMin"/>
    <link href="${fontAwesomeMin}" rel="stylesheet"/>

<div class="col-lg-2" style="margin-left: 10px;">

	<ul class="navi">
		<spring:url value="/home" var="home"></spring:url>
		<li><a href="${home}"
			style="height: 80px; color: white; background-color: cornflowerblue; font-size: 20px;">El
				Deposito</a></li>

		<spring:url value="/home" var="home"></spring:url>
		<li><a href="${home}"><i class="fas fa-home gly"></i>Inicio</a></li>
		 
		<spring:url value="/resumen" var="resumen" />
		<li><a href="${resumen}"><i class="fas fa-chart-bar gly"></i>Resumen</a></li>
		
		<spring:url value="/clientes" var="listaDeClientes" />
		<li><a href="${listaDeClientes}"><i class="fas fa-users gly"></i>Clientes</a></li>
 	
		<spring:url value="/cobros" var="cobros" />
		<li><a href="${cobros}"><i class="fas fa-file-invoice-dollar gly"></i>Cobros</a></li>

		<spring:url value="/actividades" var="listadoActividades" />
		<li><a href="${listadoActividades}"><i class="fas fa-heartbeat gly"></i>Actividades</a></li>		

		<spring:url value="/profesores" var="listadoProfesores" />
		<li><a href="${listadoProfesores}"><i class="fas fa-child gly"></i>Profesores</a></li>

		<spring:url value="/horarios" var="listadoHorarios" />
		<li><a href="${listadoHorarios}"><i class="fas fa-calendar-alt gly"></i>Horarios</a></li>

		
		<li>
		<spring:url value="/logout" var="logout"/>
		<form action="${logout}" method="post">
        	<a><button type="submit" class="navibtn" style="background-color: cornflowerblue;color:white;margin-top:0px" >
        	<i class="fas fa-sign-out-alt gly"></i> 
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
        if (path === href) {
            $(this).closest('li').addClass('active');
      }
        
    });
}
</script>
