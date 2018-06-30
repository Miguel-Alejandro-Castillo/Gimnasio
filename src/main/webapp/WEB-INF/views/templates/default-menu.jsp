<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-fluid col-lg-2" style="margin:0px;padding:0px">			
		
		<div class="list-group" style="width:251px">
			
					<spring:url value="/home" var="home"></spring:url>
    				<a class="list-group-item active" href="${home}" style="height:80px;color:white;background-color:cornflowerblue;font-size:20px;">El Deposito</a>
			        
			        <spring:url value="/clientes/crear" var="crearCliente"/>
                	<a class="list-group-item" href="${home}"><i class="fa fa-dashboard fa-fw"></i>Inicio</a>
			        
					<a data-toggle="collapse" href="#collapseCliente" class="list-group-item">Cliente</a>
						<div id="collapseCliente" class="collapse">
							<spring:url value="/clientes/crear" var="crearCliente"/>
	                   		<a class="list-group-item collapse" href="${crearCliente}">Alta de cliente</a>
	                    
	                    	<spring:url value="/clientes" var="listadoClientes"/>
	                    	<a class="list-group-item collapse" href="${listadoClientes}">Listado de clientes</a>
	                    </div>
					<!-- collapse Cliente-->
			
					<a data-toggle="collapse" href="#collapseActividad" class="list-group-item">Actividad</a>
						<div id="collapseActividad" class="collapse">
							<spring:url value="/actividades/crearActividad" var="crearActividad"/>
							<a class="list-group-item collapse" href="${crearActividad}">Alta de Actividad</a>
												
							<spring:url value="/actividades" var="listadoActividades"/>
			                <a class="list-group-item collapse" href="${listadoActividades}">Lista de Actividades</a>						
						</div>
					<!-- collapse Actividad -->
					
					<a data-toggle="collapse" href="#collapseProfesor" class="list-group-item">Profesor</a>
						<div id="collapseProfesor" class="collapse">							
                        	<spring:url value="/profesores/crearProfesor" var="crearProfesor"/>
                       		<a class="list-group-item" href="${crearProfesor}">Alta de Profesor</a>

                        	<spring:url value="/profesores" var="listadoProfesores"/>
                        	<a class="list-group-item" href="${listadoProfesores}">Listado de Profesores</a>
						</div>
					<!-- collapse Profesor -->
					
					<a data-toggle="collapse" href="#collapseHorario" class="list-group-item">Horarios</a>
						<div id="collapseHorario" class="collapse">
							<spring:url value="/horarios/crearHorario" var="crearHorario"/>
                    	    <a class="list-group-item" href="${crearHorario}">Alta de Horario</a>
                    	    
                        	<spring:url value="/horarios" var="listadoHorarios"/>
                        	<a class="list-group-item" href="${listadoHorarios}">Listado de Horarios</a>
						</div>
					<!-- collapse Horario -->
		
    		    	<spring:url value="/resumen" var="resumen"/>
                	<a class="list-group-item" href="${resumen}"><i class="fa fa-bar-chart-o fa-fw"></i>Resumen</a>                                                 
            
                	<spring:url value="/logout" var="logout"/>
                	<form action="${logout}" method="post">
                   		<button type="submit" class="list-group-item"><i class="fa fa-sign-out fa-fw"></i> Logout</button>
                	</form>
                	
                	
           </div>
           
</div>

