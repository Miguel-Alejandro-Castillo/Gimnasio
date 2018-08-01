<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="col-lg-9">
	<div class="well">
		<h1 class="page-header">
			<tiles:getAsString name="title" />
		</h1>
			
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="col-lg-6">
					<spring:url value="" var="urlActual" />
					<form:form id="cobroForm" modelAttribute="cobro"
						action="${urlActual}" method="post" role="form"
						novalidate="novalidate">
						<form:hidden path="id" />
						<div class="form-group">
							<form:label path="fechaDesde">Fecha Desde</form:label>
							<form:input type="date" id="dateDefault" path="fechaDesde"
								cssClass="form-control" />
							<form:errors path="fechaDesde" cssClass="errorMessage" />
						</div>
						<div class="form-group">
							<form:label path="fechaHasta">Fecha Hasta</form:label>
							<form:input type="date" path="fechaHasta" cssClass="form-control" />
							<form:errors path="fechaHasta" cssClass="errorMessage" />
						</div>
						<div class="form-group">
							<form:label path="actividad.id">Actividad</form:label>
							<form:select path="actividad.id" cssClass="form-control">
								<form:option value="" label="Seleccione una actividad" />
								<form:options items="${actividades}" itemValue="id"
									itemLabel="nombre" />
							</form:select>
							<form:errors path="actividad" cssClass="errorMessage" />
						</div>
						<div class="form-group">
							<form:label path="monto">Monto</form:label>
							<form:input type="number" path="monto" cssClass="form-control"
								min="0" step="0.01" />
							<form:errors path="monto" cssClass="errorMessage" />
						</div>
						<div class="form-group">
							<form:label path="comentario">Comentario</form:label>
							<form:input type="textarea" rows="16" path="comentario" cssClass="form-control"
								min="0" step="0.01" />
							<form:errors path="comentario" cssClass="errorMessage" />
						</div>						
						<form:button type="submit" class="btn btn-default">
							<tiles:getAsString name="titleSubmit" />
						</form:button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<spring:url value="/resources/js/jquery.min.js" var="jqueryMin" />
<script src="${jqueryMin}"></script>
<script>
	$(document).ready( function(){
 		document.getElementById('dateDefault').valueAsDate = new Date();
 	});
</script>
<!-- para que se setee fechaDesde en hoy por default-->

