<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<div class="well">
		<h1 class="page-header">
			<tiles:getAsString name="title" />
		</h1>
		<div class="row">
			<spring:url value="" var="urlActual" />
			<form:form id="actividadForm" modelAttribute="actividad" action="${urlActual}" method="post" role="form">
				<form:hidden path="id" />
				<div class="col-lg-6">
					<div class="form-group">
						<form:label path="nombre">Nombre*</form:label>
						<form:input path="nombre" cssClass="form-control" autofocus="autofocus" />
						<form:errors path="nombre" cssClass="error" />
					</div>
					<div class="form-group">
						<form:label path="costo">Costo*</form:label>
						<form:input path="costo" type="number" step="0.01" min="0.00" cssClass="form-control" />
						<form:errors path="costo" cssClass="error" />
					</div>
					
					<div class="form-group">
						<form:label path="profesor">Profesor</form:label>
							<form:select path="profesor" cssClass="form-control">
								<form:option value="-1" label="Seleccione un profesor" />
								<form:options items="${profesores}" itemValue="id" itemLabel="nombre" />
							</form:select>
							<form:errors path="profesor" cssClass="errorMessage" />
					</div>
								
				</div>
				
					<form:button type="submit" class="btn btn-success btn-block"
						style="margin-top:20px;">
						<tiles:getAsString name="titleSubmit" />
					</form:button>
					</form:form>
		</div>
		<!-- Boton de Submit -->
	</div>
</div>

