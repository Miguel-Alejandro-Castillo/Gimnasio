<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-lg-9">
	<div class="well">
		<h1 class="page-header">
			<tiles:getAsString name="title" />
		</h1>

		<div class="row">
			<spring:url value="" var="urlActual" />
			<form:form id="actividadForm" modelAttribute="actividadBean"
				action="${urlActual}" method="post" role="form">

				<div class="col-lg-6">
					<form:hidden path="id" />
					<div class="form-group">
						<form:label path="nombre">Nombre*</form:label>
						<form:input path="nombre" cssClass="form-control"
							autofocus="autofocus" />
						<form:errors path="nombre" cssClass="error" />
					</div>
					<div class="form-group">
						<label for="costo">Costo*</label> <input type="number" id="costo"
							name="costo" step="0.01" min="1" class="form-control"
							value="${actividadBean.costo}" />
						<form:errors path="costo" cssClass="error" />
					</div>
				</div>
				<!-- Panel de Nombre y Costo -->

				<div class="col-lg-3">
					<div style="padding-top: 5px">
						<form:select path="newDia"
							class="btn btn-primary btn-block dropdown-toggle" type="button"
							data-toggle="dropdown">
							<form:option value="" label="Seleccione un dia" />
							<form:options items="${dias}" />
						</form:select>
					</div>
					<div style="padding-top: 15px">
						<form:select path="newHorario"
							class="btn btn-primary btn-block dropdown-toggle" type="button"
							data-toggle="dropdown">
							<form:option value="${null}" label="Seleccione un horario" />
							<form:options items="${horarios}" itemValue="id" />
						</form:select>
					</div>
					<div style="padding-top: 15px">
						<form:select path="newProfesor"
							class="btn btn-primary btn-block dropdown-toggle" type="button"
							data-toggle="dropdown">
							<form:option value="${null}" label="Seleccione un profesor" />
							<form:options items="${profesores}" itemValue="id" />
						</form:select>
					</div>
					<spring:url value="/actividades/addDiaHorarioProfesor"
						var="urlAddDiaHorarioProfesor" />
				</div>
				<!-- Dropdowns de Dia Horario Profesor -->

				<div class="col-lg-3">
					<button type="button"
						onclick="submitAjax('${urlAddDiaHorarioProfesor}')"
						class="btn btn-info btn-block" type="button"
						style="margin-top: 20px;">Agregar Horario</button>
					<!-- Boton de Agregar a la tabla -->
					<form:button type="submit" class="btn btn-success btn-block"
						style="margin-top:20px;">
						<tiles:getAsString name="titleSubmit" />
					</form:button>
				</div>
			</form:form>
			<!-- Boton de Submit -->
		</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-body">
			<table class="table table-condensed table-bordered"
				id="tabla-actividades">
				<thead>
					<tr>
						<th>dia</th>
						<th>horario</th>
						<th>profesor</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${actividadBean.diasHorariosProfesores}"
						var="diaHorarioProfesor">
						<tr>
							<td><c:out value="${diaHorarioProfesor.dia}"></c:out></td>
							<td><c:out
									value="${diaHorarioProfesor.horario.hora_inicio} hs a ${diaHorarioProfesor.horario.hora_fin} hs"></c:out></td>
							<td><c:out
									value="${diaHorarioProfesor.profesor.nombre} ${diaHorarioProfesor.profesor.apellido}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<!-- Tabla de Actividades a agregar ARREGLAR EL HECHO DE QUE APARECE "SIN DATOS" -->