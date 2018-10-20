<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="/resources/css/template.css" var="templateCss"/>
<link href="${templateCss}" rel="stylesheet"/>
<spring:url value="/resources/css/jquery-confirm.min.css" var="jqueryConfirmCss"/>
<link href="${jqueryConfirmCss}" rel="stylesheet"/>
<fmt:setLocale value = "es_AR" scope="session"/>

<div class="col-lg-9">
	<div class="well">
		<div class="row">
			<div class="col-lg-10">
				<h1 class="page-header">
					<tiles:getAsString name="title" />
				</h1>
			</div>
			<div class="col-lg-2">
				<spring:url value="/actividades/crearActividad" var="crearActividad" />
				<a href="${crearActividad}">
					<button class="upperButton btn-lg"><i class="fas fa-heartbeat"></i> Nueva Actividad</button>
				</a>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Costo</th>
							<th>Accion</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${actividades}" var="actividad">
							<tr id="row_${actividad.id}" class="odd gradeX">
								<td><c:out value="${actividad.nombre}"></c:out></td>
								<td><fmt:formatNumber value="${actividad.costo}" type="currency" minFractionDigits="2" currencySymbol="$ " /></td>
								<td>
									<a onclick="deleteActividad(${actividad.id})"><i
											class="fas fa-trash-alt"
											style="font-size: 24px; padding-right: 10px; padding-left: 10px;"></i>
									</a>
									<spring:url value="/actividades/${actividad.id}/detalle" var="urlActividadDetalle"/>
									<a href="${urlActividadDetalle}">
										<i class="fas fa-info-circle"></i>
									</a>

								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		$('#dataTables-example').DataTable({
			responsive : true
		});
	});
</script>
<!-- para que ande la tabla  -->


