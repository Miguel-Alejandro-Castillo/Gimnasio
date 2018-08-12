<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="col-lg-9">
	<div class="well">
			<h1 class="page-header">
				Agregar Clase
			</h1>
	
	<spring:url value="" var="urlActual" />
	<form:form id="leccionForm" modelAttribute="leccion"
		action="${urlActual}" method="post" role="form"
		novalidate="novalidate" accept-charset="UTF-8">
			
			<div class="form-group">
			<form:select path="dia"
				class="btn btn-primary btn-block dropdown-toggle" type="button"
				data-toggle="dropdown">
				<form:option value="" label="Seleccione un dia" />
				<form:options items="${dias}" />
			</form:select>
			<form:errors path="dia" cssClass="errorMessage" />
			</div>
									
			<div class="form-group">
			<form:label path="horaInicio">hora inicio</form:label>
			<form:input path="horaInicio" type="time" cssClass="form-control"/>
			<form:errors path="horaInicio" cssClass="errorMessage" />
			</div>
			
			<div class="form-group">
			<form:label path="horaFin">hora fin</form:label>
			<form:input path="horaFin" type="time" cssClass="form-control" />
			<form:errors path="horaFin" cssClass="errorMessage" />
			</div>
			<form:button type="submit" class="btn btn-default">
			<tiles:getAsString name="titleSubmit" />
			</form:button>
	</form:form>			
</div>
</div>