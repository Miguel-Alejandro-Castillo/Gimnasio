<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
	.submitButton{
		width:270px;
		height:60px;
		margin-top:30px;
		background-color:cornflowerblue;
		color:white;
		font-size:20px;
	}
</style>
<div class="well">
	<div class="headerWrapper">
		<h1 class="page-header">
			<tiles:getAsString name="title" />
		</h1>
		<spring:url value="/cobros" var="atras"/>
		<a href="${atras}">
			<button class="btn backButton"><i class="fas fa-arrow-left"></i> Atras</button>
		</a>
	</div>

	<div class="panel panel-default">
		<div class="panel-body">
			<div class="col-lg-6">
				<spring:url value="" var="urlActual" />
				<form:form id="cobroForm" modelAttribute="cobro" action="${urlActual}" method="post" role="form" novalidate="novalidate">
					<form:hidden path="id" />
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<form:label path="fechaDesde">Fecha Desde</form:label>
								<form:input type="date" id="dateDefault" path="fechaDesde"
									cssClass="form-control" />
								<form:errors path="fechaDesde" cssClass="errorMessage" />
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<form:label path="fechaHasta">Fecha Hasta</form:label>
								<form:input type="date" path="fechaHasta" cssClass="form-control" />
								<form:errors path="fechaHasta" cssClass="errorMessage" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<form:label path="actividad">Actividad</form:label>
						<form:select id="actividad_cobro" path="actividad" cssClass="form-control" onchange="changeActividad()">
							<form:option value="-1" label="Seleccione una actividad" />
							<form:options items="${actividades}" itemValue="id" itemLabel="actividadProfesor" />
						</form:select>
						<form:errors path="actividad" cssClass="errorMessage" />
					</div>
					<div class="form-group">
						<form:label path="monto">Monto</form:label>
						<form:input type="number" path="monto" cssClass="form-control" min="0" step="0.01" />
						<form:errors path="monto" cssClass="errorMessage" />
					</div>

					<form:button type="submit" class="btn btn-default submitButton">
					<tiles:getAsString name="titleSubmit" />
					</form:button>
			</div>
			<div class="col-lg-6">
				<div class="form-group">
					<form:label path="comentario">Comentario</form:label>
					<form:textarea rows="13" path="comentario" cssClass="form-control" min="0" step="0.10" />
					<form:errors path="comentario" cssClass="errorMessage" />
				</div>
			</div>
				</form:form>
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

