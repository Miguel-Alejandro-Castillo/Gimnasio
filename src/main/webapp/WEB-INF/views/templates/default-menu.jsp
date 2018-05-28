<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-fluid" style="margin:0px;padding:0px">
<div class="navbar-default sidebar" role="navigation">
		
		<div class="container-fluid" style="background-color:cornflowerblue">
			<spring:url value="/home" var="home"></spring:url>
    		<a class="navbar-brand" href="${home}" style="color:white">El Deposito</a>
		</div>		
    		    	
        <ul class="nav" id="side-menu">  	       
            <li>
                <spring:url value="/clientes/crear" var="crearCliente"/>
                <a href="${home}"><i class="fa fa-dashboard fa-fw"></i>Inicio</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Clientes<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <spring:url value="/clientes/crear" var="crearCliente"/>
                        <a href="${crearCliente}">Alta de cliente</a>
                    </li>
                    <li>
                        <spring:url value="/clientes" var="listadoClientes"/>
                        <a href="${listadoClientes}">Listado de clientes</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Actividades<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
	                <li>
						<spring:url value="/actividades/crearActividad" var="crearActividad"/>
						<a href="${crearActividad}">Alta de Actividad</a>
					</li>
					<li>
						<spring:url value="/actividades" var="listadoActividades"/>
		                <a href="${listadoActividades}">Lista de Actividades</a>
					</li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Profesores<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <spring:url value="/profesores/crearProfesor" var="crearProfesor"/>
                        <a href="${crearProfesor}">Alta de Profesor</a>
                    </li>
                    <li>
                        <spring:url value="/profesores" var="listadoProfesores"/>
                        <a href="${listadoProfesores}">Listado de Profesores</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Horarios<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <spring:url value="/horarios/crearHorario" var="crearHorario"/>
                        <a href="${crearHorario}">Alta de Horario</a>
                    </li>
                    <li>
                        <spring:url value="/horarios" var="listadoHorarios"/>
                        <a href="${listadoHorarios}">Listado de Horarios</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
				<spring:url value="/resumen" var="resumen"/>
                <a href="${resumen}"><i class="fa fa-bar-chart-o fa-fw"></i>Resumen</a>                                                 
            </li>
            <li><a>
                <spring:url value="/logout" var="logout"/>
                <form action="${logout}" method="post">
                   <button type="submit" class="btn-link"><i class="fa fa-sign-out fa-fw"></i> Logout</button>
                </form>
            </a></li>
        </ul>
      
    <!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->
</div>    