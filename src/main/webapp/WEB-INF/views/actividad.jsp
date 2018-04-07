<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header"><tiles:getAsString name="title"/></h1>
		</div>
	</div>
	
	<spring:url value="" var="urlActual"/>
	<form:form id="actividadForm" modelAttribute="actividadBean" action="${urlActual}" method="post" role="form">
	<div  class="row" >
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form:hidden path="id"/>
								<div class="form-group">
									<form:label path="nombre">Nombre*</form:label>
                                        <form:input path="nombre" cssClass="form-control" autofocus="autofocus"/>
                                        <form:errors path="nombre" cssClass="error"/>
								</div>
								<div class="form-group">
									<label for="costo">Costo*</label>
										<input type="number" id="costo" name="costo" step="0.01" min="1" class="form-control" value="${actividadBean.costo}"/>
										<form:errors path="costo" cssClass="error"/>
								</div>
						</div>
          				
          				<div class="col-lg-6">                  
							<form:select path="newDia" class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
								<form:option value="" label="Seleccione un dia"/>
								<form:options items="${dias}"  />
							</form:select>
							<form:select path="newHorario" class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
								<form:option value="${null}" label="Seleccione un horario"/>
								<form:options items="${horarios}" itemValue="id" />
							</form:select>
							<form:select path="newProfesor" class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
								<form:option value="${null}" label="Seleccione un profesor"/>
								<form:options items="${profesores}" itemValue="id" />
							</form:select>
							<spring:url value="/actividades/addDiaHorarioProfesor" var="urlAddDiaHorarioProfesor"/>
							<button type="button" onclick="submitAjax('${urlAddDiaHorarioProfesor}')" class="btn btn-primary" type="button">Agregar</button>
						</div>
					</div>	
				</div>
			</div>
		</div>
	</div>
		<!-- Panel de Nombre y Costo -->
	
	
	<!-- Dropdowns de Dia Horario Profesor -->        

	<div class="panel panel-default">
		<div class="panel-body">
			<table width="100%" class="table table-condensed table-bordered" id="dataTables-example">
				<thead>
					<tr>
						<th>dia</th>
						<th>horario</th>
						<th>profesor</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${actividadBean.diasHorariosProfesores}" var="diaHorarioProfesor">
						<tr class="odd gradeX">
							<td><c:out value="${diaHorarioProfesor.dia}"></c:out></td>
							<td><c:out value="${diaHorarioProfesor.horario.hora_inicio} hs a ${diaHorarioProfesor.horario.hora_fin} hs"></c:out></td>
							<td><c:out value="${diaHorarioProfesor.profesor.nombre} ${diaHorarioProfesor.profesor.apellido}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- Tabla de Actividades a agregar ARREGLAR EL HECHO DE QUE APARECE "SIN DATOS" -->
        
	<form:button type="submit" class="btn btn-default"><tiles:getAsString name="titleSubmit"/></form:button>
	</form:form>
	<!-- Boton de Submit -->
	
</div>